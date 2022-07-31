package lk.myads.myadslkplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.myads.myadslkplatform.domain.Client;
import lk.myads.myadslkplatform.repo.UserRepository;

@Service
public class AuthService {
	
	private UserRepository userRepository;
	
	@Autowired
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Client saveuserDetails(Client newUserDetails) {
		return this.userRepository.save(newUserDetails);
	}
	
	public Client checkUserByEmail(String email) {
		return this.userRepository.findByEmailAddress(email);
	}
	
	public List<Client> getAllClients(){
		return this.userRepository.findAll();
	}
	
	public Client getClientByEmailAndPassword(String email,String password) {
		return this.userRepository.findByEmailAddressAndUserPass(email, password);
	}
	
	public Client getClientByEmailAddress(String email) {
		return this.checkUserByEmail(email);
	}
}
