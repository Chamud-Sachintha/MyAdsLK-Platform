package lk.myads.myadslkplatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.myads.myadslkplatform.domain.Client;

public interface UserRepository extends JpaRepository<Client, Long> {
	
	public Client findByEmailAddress(String emailAddress);
	
	public Client findByEmailAddressAndUserPass(String email,String password);
}
