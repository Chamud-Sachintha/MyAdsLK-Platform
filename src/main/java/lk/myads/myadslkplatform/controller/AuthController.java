package lk.myads.myadslkplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.myads.myadslkplatform.domain.Client;
import lk.myads.myadslkplatform.service.AuthService;

@RestController
@RequestMapping(name = "api/v1/auth")
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
	
	@GetMapping
	public List<Client> getAllClients(){
		return this.authservice.getAllClients();
	}
}
