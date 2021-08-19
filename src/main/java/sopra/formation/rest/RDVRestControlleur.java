package sopra.formation.rest;

import java.util.List;
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

import sopra.formation.model.RDV;
import sopra.formation.model.Views;
import sopra.formation.repository.IRDVRepository;
import sopra.formation.rest.exception.RDVValidationException;

@RestController
@RequestMapping("/rdv")
@CrossOrigin("*")
public class RDVRestControlleur {
	
	@Autowired
	private IRDVRepository RDVRepo;

	@GetMapping("/{id}")
	@JsonView(Views.ViewRDV.class)
	//TODO @PreAuthorize("hasAnyRole('USER','ADMIN')")
	public RDV find(@PathVariable Long id) {

//	@PutMapping("/{id}")
//	@JsonView(Views.ViewRDV.class)
//	//TODO@PreAuthorize("hasRole('ADMIN')")
//	public RDV update(@RequestBody RDV RDV, @PathVariable Long id) {
//		if (!RDVRepo.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}	@Autowired
		private IRDVRepository RDVRepo;
//
//		RDV = RDVRepo.save(RDV);
//
//		return RDV;
//	}

	//TODO Need patch ?
//	@PatchMapping("/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public RDV partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
//		if (!RDVRepo.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//
//		RDV RDVFind = RDVRepo.findById(id).get();
//
//		if (updates.containsKey("comportemental")) {
//			RDVFind.setComportemental((Integer) updates.get("comportemental"));
//		}
//		if (updates.containsKey("technique")) {
//			RDVFind.setTechnique((Integer) updates.get("technique"));
//		}
//		if (updates.containsKey("commentaires")) {
//			RDVFind.setCommentaires((String) updates.get("commentaires"));
//		}
//
//		RDVFind = RDVRepo.save(RDVFind);
//
//		return RDVFind;
//	}

	@DeleteMapping("/{id}")
	//TODO @PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable Long id) {
		if (!RDVRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		RDVRepo.deleteById(id);
	}

}
