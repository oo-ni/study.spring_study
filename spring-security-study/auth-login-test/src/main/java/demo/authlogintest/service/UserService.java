package demo.authlogintest.service;

import demo.authlogintest.dto.request.SignInReq;
import demo.authlogintest.dto.request.SignUpReq;
import demo.authlogintest.dto.response.UserInfoRes;
import demo.authlogintest.entity.Role;
import demo.authlogintest.entity.User;
import demo.authlogintest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(SignUpReq signUpReq) {
        User user = User.builder()
                .email(signUpReq.email())
                .password(signUpReq.password())
                .username(signUpReq.username())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        log.info("유저가 등록되었습니다 : " + signUpReq.username());
    }

    public void login(SignInReq signInReq) {
        // 이메일 검증
        User user = userRepository.findByEmail(signInReq.email())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        // 비밀번호 검증
        if (passwordEncoder.matches(signInReq.password(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        log.info("로그인이 완료되었습니다 : " + signInReq.email());
    }

    public UserInfoRes userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        return UserInfoRes.from(user);
    }
}
