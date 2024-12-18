package demo.authlogintest.controller;

import demo.authlogintest.dto.request.SignInReq;
import demo.authlogintest.dto.request.SignUpReq;
import demo.authlogintest.dto.response.UserInfoRes;
import demo.authlogintest.service.CustomUserDetails;
import demo.authlogintest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpReq signUpReq) {
        userService.register(signUpReq);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SignInReq signInReq) {
        userService.login(signInReq);
        // jwt 토큰 구현하면, 헤더에 토큰정보 담아서 보내줘야 함.
        return ResponseEntity.ok("로그인 성공");
    }

    @GetMapping("/me")
    public ResponseEntity<UserInfoRes> getCurrentUser(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        UserInfoRes userInfoRes = userService.userInfo(customUserDetails.getUsername());
        return ResponseEntity.ok(userInfoRes);
    }
}
