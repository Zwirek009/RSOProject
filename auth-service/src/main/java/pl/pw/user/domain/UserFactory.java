package pl.pw.user.domain;

import lombok.experimental.UtilityClass;
import pl.pw.user.dto.UserInDto;
import pl.pw.user.dto.UserOutDto;

@UtilityClass
public class UserFactory {
    public static User createUser(UserInDto userDto) {
        return new User(userDto.getName(), userDto.getPassword(), userDto.getRole());
    }

    public static UserOutDto createUserDto(User user) {
        return new UserOutDto(user.getId(), user.getName(), user.getRole());
    }
}
