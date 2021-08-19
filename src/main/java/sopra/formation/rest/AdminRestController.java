package sopra.formation.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Admin;
import sopra.formation.model.Admin;
import sopra.formation.model.Views;
import sopra.formation.repository.IAdminRepository;
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {
	@Autowired
	private IAdminRepository AdminRepo;

	@GetMapping("")
	@JsonView(Views.ViewAdmin.class)
	public List<Admin> findAll() {
		return AdminRepo.findAll();
	}
	

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin find(@PathVariable Long id) {

		Optional<Admin> optAdmin = AdminRepo.findById(id);
	
		if (optAdmin.isPresent()) {
			return optAdmin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewAdmin.class)
	public Admin create(@RequestBody Admin Admin) {
		Admin = AdminRepo.save(Admin);

		return Admin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin update(@RequestBody Admin Admin, @PathVariable Long id) {
		if (!AdminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Admin = AdminRepo.save(Admin);

		return Admin;
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Admin> partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!AdminRepo.existsById(id)) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}

		Admin AdminFind = AdminRepo.findById(id).get();

		if (updates.containsKey("nom")) {
			AdminFind.setNom((String) updates.get("nom"));
		}
		if (updates.containsKey("prenom")) {
			AdminFind.setPrenom((String) updates.get("prenom"));
		}
		if (updates.containsKey("mail")) {
			AdminFind.setMail((String) updates.get("mail"));
		}
		if (updates.containsKey("mdp")) {
			AdminFind.setMdp((String) updates.get("mdp"));
		}

		AdminFind = AdminRepo.save(AdminFind);

		return new ResponseEntity<Admin>(AdminFind, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!AdminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		AdminRepo.deleteById(id);
	}
}
