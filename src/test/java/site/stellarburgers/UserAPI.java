package site.stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import site.stellarburgers.pageobject.RefreshTokenPOJO;
import site.stellarburgers.pageobject.UserPOJO;

import static io.restassured.RestAssured.given;

public class UserAPI {
    final static String USERREGISTERED = "/api/auth/register";
    final static String USERDATA = "/api/auth/user";
    final static String USERLOGIN = "/api/auth/login";
    final static String USERLOGOUT = "api/auth/logout";

    @Step("Make post-request to create user")
    public static Response createUser(UserPOJO user) {

        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .post(USERREGISTERED);
        return response;
    }

    @Step("Make post-request to login of user")
    public static Response authorizedUser(UserPOJO user){

        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .post(USERLOGIN);
        return response;
    }

    @Step("Make post-request to login of user")
    public static String getToken (UserPOJO user){
        String token = UserAPI.authorizedUser(user).body().asString();
        String[] split = token.split(" ");
        String tokenNumber = split[1].substring(0, 171);
        System.out.println(tokenNumber);
        return tokenNumber;
    }

    @Step("Make delete-request to delete of user")
    public static Response deleteUser(String token, UserPOJO user){

        Response response = given()
                .header("Content-type", "application/json")
                .auth().oauth2(token)
                .body(user)
                .delete(USERDATA);
        return response;
    }


    @Step("Make request to make logout")
    public static ValidatableResponse makeLogout(String token){
        RefreshTokenPOJO refreshToken = new RefreshTokenPOJO(token);

        return given()
                .header("Content-type", "application/json")
                .body(refreshToken)
                .post(USERLOGOUT)
                .then();
    }

}
