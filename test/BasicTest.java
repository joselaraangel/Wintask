import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

 @Test
public void someTestOfASecuredAction() {
    Map<String, String> loginUserParams = new HashMap<String, String>(); 
    loginUserParams.put("username", "admin"); 
    loginUserParams.put("password", "admin");

    // Login here so the following request will be authenticated:
    Response response = POST("/login", loginUserParams);

    // The following is an action that requires an authenticated user:
    Map<String, String> params;
    params.put("someparam", "somevalue");
    response = POST("/some/secured/action", params);

    assertIsOk(response); // this always fails because it is a 302 redirecting to /login
}

}
