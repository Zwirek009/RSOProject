package pl.pw.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void save(User user) {
        User encodedUser = encodePassword(user);
        userRepository.save(encodedUser);

    }

    private User encodePassword(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        return new User(user.getName(), password, user.getRole());
    }

    public Optional<User> getCurrentUser() {
        return userRepository.findByName(getCurrentUserName());
    }

    private String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
