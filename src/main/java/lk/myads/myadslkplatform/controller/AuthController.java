package lk.myads.myadslkplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lk.myads.myadslkplatform.domain.Client;
import lk.myads.myadslkplatform.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthController {
	
	private AuthService authservice;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authservice = authService;
	}
	
	@PostMapping
	public Client saveNewUserDetails(@RequestBody Client newUserDetails) {
		return this.authservice.saveuserDetails(newUserDetails);
	}
	
	@GetMapping(path = "check")
	public Client checkUserAlreadyExistsByEmail(@RequestParam(name = "email") String email) {
		return this.authservice.checkUserByEmail(email);
	}
	
	@GetMapping
	public List<Client> getAllClients(){
		return this.authservice.getAllClients();
	}
	
	@GetMapping(path = "sign-in")
	public Client getClientByEmailAndPassword(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		return this.authservice.getClientByEmailAndPassword(email, password);
	}
	
	@GetMapping(path = "byEmail")
	public Client getClientByEmailAddress(@RequestParam(name = "email") String email) {
		return this.authservice.getClientByEmailAddress(email);
	}
}
