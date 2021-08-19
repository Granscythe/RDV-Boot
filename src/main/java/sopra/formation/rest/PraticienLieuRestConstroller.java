package sopra.formation.rest;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;


import sopra.formation.model.PraticienLieu;
import sopra.formation.model.Views;

import sopra.formation.repository.IPraticienLieuRepository;
import sopra.formation.rest.exception.LieuValidationException;

@RestController
@RequestMapping("/praticienLieu")
@CrossOrigin("*")
public class PraticienLieuRestConstroller {
	
	@Autowired
	private IPraticienLieuRepository praticienLieuRepo;

	@GetMapping("/{id}")
	@JsonView(Views.ViewPraticienLieu.class)
	public PraticienLieu find(@PathVariable Long id) {

		Optional<PraticienLieu> optPraticienLieu = praticienLieuRepo.findById(id);

		if (optPraticienLieu.isPresent()) {
			return optPraticienLieu.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPraticienLieu.class)
	public PraticienLieu create(@Valid @RequestBody PraticienLieu praticienLieu, BindingResult result) {
		if(result.hasErrors()) {
			throw new LieuValidationException();
		}
		
		praticienLieu = praticienLieuRepo.save(praticienLieu);

		return praticienLieu;
	}

	@PutMapping("/{id}")
	
	public PraticienLieu update(@RequestBody PraticienLieu praticienLieu, @PathVariable Long id) {
		if (!praticienLieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		praticienLieu = praticienLieuRepo.save(praticienLieu);

		return praticienLieu;
	}

	
//	@PatchMapping("/{id}")
//	@JsonView(Views.ViewPraticienLieu.class)
//	public Lieu partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
//		if (!praticienLieu.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//
//		Lieu lieuFind = lieuRepo.findById(id).get();
//
//		if (updates.containsKey("typeLieu")) {
//			lieuFind.setTypeLieu((String) updates.get("typeLieu"));
//		}
//		if (updates.containsKey("rue")) {
//			lieuFind.setRue((String) updates.get("rue"));
//		}
//		if (updates.containsKey("ville")) {
//			lieuFind.setVille((String) updates.get("ville"));
//		}
//		
//		if (updates.containsKey("codePostal")) {
//			lieuFind.setCodePostal((String) updates.get("codePostal"));
//		}
//		
//		if (updates.containsKey("numero")) {
//			lieuFind.setNumero((Integer) updates.get("numero"));
//		}
//
//		lieuFind = lieuRepo.save(lieuFind);
//
//		return lieuFind;
//	}

	@DeleteMapping("/{id}")
	
	public void delete(@PathVariable Long id) {
		if (!praticienLieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		praticienLieuRepo.deleteById(id);
	}


}
