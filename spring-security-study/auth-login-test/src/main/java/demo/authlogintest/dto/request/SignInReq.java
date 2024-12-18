package demo.authlogintest.dto.request;

public record SignInReq(
        String email,
        String password
) {
}
