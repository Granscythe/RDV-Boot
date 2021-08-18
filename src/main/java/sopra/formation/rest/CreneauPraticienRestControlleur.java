package sopra.formation.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import sopra.formation.model.CreneauPraticien;
import sopra.formation.repository.ICreneauPraticienRepository;


@RestController
@RequestMapping("/creneauPraticien")
@CrossOrigin("*")
public class CreneauPraticienRestControlleur {
	
	@Autowired
	private ICreneauPraticienRepository creneauPraticienRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreneauPraticien.class)
	public List<CreneauPraticien> findAll() {
		return creneauPraticienRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCreneauPraticien.class)
	public CreneauPraticien find(@PathVariable Long id) {

		Optional<CreneauPraticien> optCreneauPraticien = creneauPraticienRepo.findById(id);

		if (optCreneauPraticien.isPresent()) {
			return optCreneauPraticien.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreneauPraticien.class)
	public CreneauPraticien create(@Valid @RequestBody CreneauPraticien creneauPraticien, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreneauPraticienValidationException();
		}
		
		creneauPraticien = creneauPraticienRepo.save(creneauPraticien);

		return creneauPraticien;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreneauPraticien.class)
	public CreneauPraticien update(@RequestBody CreneauPraticien creneauPraticien, @PathVariable Long id) {
		if (!creneauPraticienRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creneauPraticien = creneauPraticienRepo.save(creneauPraticien);

		return creneauPraticien;
	}

	@PatchMapping("/{id}")
	public CreneauPraticien partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!creneauPraticienRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		CreneauPraticien creneauPraticienFind = creneauPraticienRepo.findById(id).get();

		if (updates.containsKey("dtDebutPraticien")) {
			creneauPraticienFind.setDtDebutPraticien((Date) updates.get("dtDebutPraticien"));
		}
		if (updates.containsKey("technique")) {
			creneauPraticienFind.setDtFinPraticien((Date) updates.get("technique"));
		}

		creneauPraticienFind = creneauPraticienRepo.save(creneauPraticienFind);

		return creneauPraticienFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauPraticienRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creneauPraticienRepo.deleteById(id);
	}
}


}
