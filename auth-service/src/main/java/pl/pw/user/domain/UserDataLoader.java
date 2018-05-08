package pl.pw.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserDataLoader implements ApplicationRunner {

    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.save(new User("user@gmail.com","user", "USER"));
    }
}