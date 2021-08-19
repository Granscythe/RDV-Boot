package sopra.formation.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sopra.formation.model.Admin;
import sopra.formation.model.Patient;
import sopra.formation.model.Personne;
import sopra.formation.model.Praticien;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Personne personne;

	public CustomUserDetails(Personne Personne) {
		super();
		this.personne = Personne;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//if avec les roles
		if (this.personne instanceof Admin) {
			return AuthorityUtils.createAuthorityList("ADMIN");
		}
		if (this.personne instanceof Patient) {
			return AuthorityUtils.createAuthorityList("PATIENT");
		}
		if (this.personne instanceof Praticien) {
			return AuthorityUtils.createAuthorityList("PRATICIEN");
		}
		
		return AuthorityUtils.createAuthorityList("GUEST");
	}

	@Override
	public String getPassword() {
		return new BCryptPasswordEncoder().encode(personne.getMdp());
	}

	@Override
	public String getUsername() {
		return personne.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return personne.isEnable();
	}

}
