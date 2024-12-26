package demo.authlogintest.dto.response;

import demo.authlogintest.entity.Role;
import demo.authlogintest.entity.User;

public record UserInfoRes(
        Long id,
        String email,
        String username,
        Role role
) {
    public static UserInfoRes from(User user) {
        return new UserInfoRes(
            user.getId(),
            user.getEmail(),
            user.getUsername(),
            user.getRole()
        );
    }
}
