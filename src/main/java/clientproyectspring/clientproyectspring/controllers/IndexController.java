package clientproyectspring.clientproyectspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String sayHello() {
		return "<h1>Bievenidos a mi Api Rest</h1>";
	}
}
