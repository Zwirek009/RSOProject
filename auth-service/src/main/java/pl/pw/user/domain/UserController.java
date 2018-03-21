package pl.pw.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.user.domain.UserFactory;
import pl.pw.user.domain.UserService;
import pl.pw.user.dto.UserInDto;
import pl.pw.user.dto.UserOutDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity createUser(@RequestBody UserInDto userDto) {
        userService.save(UserFactory.createUser(userDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/current")
    public ResponseEntity<UserOutDto> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser().map(UserFactory::createUserDto).get());
    }
}