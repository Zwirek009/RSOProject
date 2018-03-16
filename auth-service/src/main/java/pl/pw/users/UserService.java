package pl.pw.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void save(User user) {
        userRepository.save(user);
    }

}
