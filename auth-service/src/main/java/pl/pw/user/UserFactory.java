package pl.pw.user;

import lombok.experimental.UtilityClass;
import pl.pw.user.dto.UserDto;

@UtilityClass
class UserFactory {
    static User createUser(UserDto userDto) {
        return new User(userDto.getName(), userDto.getPassword(), userDto.getRole());
    }
}
