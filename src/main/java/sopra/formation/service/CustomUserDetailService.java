package sopra.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sopra.formation.model.Personne;
import sopra.formation.repository.IPersonneRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private IPersonneRepository personneRepo;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Optional<Personne> opt = personneRepo.findByMail(mail);

		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		} else {
			throw new UsernameNotFoundException(mail + " Inconnu");
		}
	}

}
