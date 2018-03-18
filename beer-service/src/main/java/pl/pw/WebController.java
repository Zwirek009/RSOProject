package pl.pw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@RequestMapping("/")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("XD");
	}

}
