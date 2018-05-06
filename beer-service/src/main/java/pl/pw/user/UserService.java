//package pl.pw.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.pw.beer.Beer;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//	private final UserRepository userRepository;
//
//	@Autowired
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	public void createUser(User user) {
//		userRepository.save(user);
//	}
//
//	public void addBeer(long id, Beer beer) {
//		Optional<User> user = userRepository.findById(id);
//		user.ifPresent(user1 -> user1.addBeer(beer));
//	}
//
//	public List<Beer> getBeers(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get().getBeers();
//		}
//		return new ArrayList<>();
//	}
//
//}
