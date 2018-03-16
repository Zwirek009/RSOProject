package pl.pw;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.pw.users.User;
import pl.pw.users.UserService;

@Component
@RequiredArgsConstructor
class DataLoader implements ApplicationRunner {

    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder().name("user").password("user").build();
        userService.save(user);
    }
}