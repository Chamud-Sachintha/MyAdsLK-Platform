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
	
	public List<Client> getAllClients(){
		return this.userRepository.findAll();
	}
}
