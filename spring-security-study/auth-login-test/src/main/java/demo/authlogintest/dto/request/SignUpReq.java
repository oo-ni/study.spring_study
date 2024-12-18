package demo.authlogintest.dto.request;

public record SignUpReq(
        String email,
        String password,
        String username
) {
}
