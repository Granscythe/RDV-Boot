package sopra.formation.rest;

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

import sopra.formation.model.Lieu;
import sopra.formation.model.RDV;
import sopra.formation.model.Views;
import sopra.formation.repository.ILieuRepository;
import sopra.formation.repository.IRDVRepository;
import sopra.formation.rest.exception.LieuValidationException;
import sopra.formation.rest.exception.RDVValidationException;


@RestController
@RequestMapping("/lieu")
@CrossOrigin("*")
public class LieuRestController {

	@Autowired
	private ILieuRepository lieuRepo;

	@GetMapping("/{id}")
	@JsonView(Views.ViewLieu.class)
	public Lieu find(@PathVariable Long id) {

		Optional<Lieu> optLieu = lieuRepo.findById(id);

		if (optLieu.isPresent()) {
			return optLieu.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewLieu.class)
	public Lieu create(@Valid @RequestBody Lieu lieu, BindingResult result) {
		if(result.hasErrors()) {
			throw new LieuValidationException();
		}
		
		lieu = lieuRepo.save(lieu);

		return lieu;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLieu.class)
	public Lieu update(@RequestBody Lieu lieu, @PathVariable Long id) {
		if (!lieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		lieu = lieuRepo.save(lieu);

		return lieu;
	}

	
	@PatchMapping("/{id}")
	@JsonView(Views.ViewLieu.class)
	public Lieu partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!lieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Lieu lieuFind = lieuRepo.findById(id).get();

		if (updates.containsKey("typeLieu")) {
			lieuFind.setTypeLieu((String) updates.get("typeLieu"));
		}
		if (updates.containsKey("rue")) {
			lieuFind.setRue((String) updates.get("rue"));
		}
		if (updates.containsKey("ville")) {
			lieuFind.setVille((String) updates.get("ville"));
		}
		
		if (updates.containsKey("codePostal")) {
			lieuFind.setCodePostal((String) updates.get("codePostal"));
		}
		
		if (updates.containsKey("numero")) {
			lieuFind.setNumero((Integer) updates.get("numero"));
		}

		lieuFind = lieuRepo.save(lieuFind);

		return lieuFind;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewLieu.class)
	public void delete(@PathVariable Long id) {
		if (!lieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		lieuRepo.deleteById(id);
	}

}


