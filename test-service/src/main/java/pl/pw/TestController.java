package pl.pw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
class TestController {

    @RequestMapping(value = "/some", method = RequestMethod.GET)
    ResponseEntity<String> getSome(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }

    @RequestMapping(value = "/wtf", method = RequestMethod.POST)
    ResponseEntity<String> wtf(@RequestParam String param) {
        return ResponseEntity.ok(param);
    }
}
