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

import sopra.formation.model.CreneauUnitaire;
import sopra.formation.model.Views;
import sopra.formation.repository.ICreneauUnitaireRepository;
import sopra.formation.rest.exception.CreneauUnitaireValidationException;


@RestController
@RequestMapping("/creneauUnitaire")
@CrossOrigin("*")
public class CreneauUnitaireRestControlleur {
	
	@Autowired
	private ICreneauUnitaireRepository creneauUnitaireRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreneauUnitaire.class)
	public List<CreneauUnitaire> findAll() {
		return creneauUnitaireRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCreneauUnitaire.class)
	public CreneauUnitaire find(@PathVariable Long id) {

		Optional<CreneauUnitaire> optCreneauUnitaire = creneauUnitaireRepo.findById(id);

		if (optCreneauUnitaire.isPresent()) {
			return optCreneauUnitaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreneauUnitaire.class)
	public CreneauUnitaire create(@Valid @RequestBody CreneauUnitaire creneauUnitaire, BindingResult result) {
		if(result.hasErrors()) {
			throw new CreneauUnitaireValidationException();
		}
		
		creneauUnitaire = creneauUnitaireRepo.save(creneauUnitaire);

		return creneauUnitaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreneauUnitaire.class)
	public CreneauUnitaire update(@RequestBody CreneauUnitaire creneauUnitaire, @PathVariable Long id) {
		if (!creneauUnitaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creneauUnitaire = creneauUnitaireRepo.save(creneauUnitaire);

		return creneauUnitaire;
	}

	@PatchMapping("/{id}")
	public CreneauUnitaire partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!creneauUnitaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		CreneauUnitaire creneauUnitaireFind = creneauUnitaireRepo.findById(id).get();

		if (updates.containsKey("dtDebutUnitaire")) {
			creneauUnitaireFind.setDtDebutUnitaire((Date) updates.get("dtDebutUnitaire"));
		}
		if (updates.containsKey("duree")) {
			creneauUnitaireFind.setDuree((Integer) updates.get("duree"));
		}
		if (updates.containsKey("statut")) {
			creneauUnitaireFind.setStatut((boolean) updates.get("Statut"));
		}

		creneauUnitaireFind = creneauUnitaireRepo.save(creneauUnitaireFind);

		return creneauUnitaireFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauUnitaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creneauUnitaireRepo.deleteById(id);
	}
}
