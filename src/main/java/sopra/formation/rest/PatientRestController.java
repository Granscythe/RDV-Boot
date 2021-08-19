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

import sopra.formation.model.Patient;
import sopra.formation.model.Views;
import sopra.formation.repository.IPatientRepository;
@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientRestController {
	@Autowired
	private IPatientRepository patientRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewPatient.class)
	public List<Patient> findAll() {
		return patientRepo.findAll();
	}
	

	@GetMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient find(@PathVariable Long id) {

		Optional<Patient> optpatient = patientRepo.findById(id);
	
		if (optpatient.isPresent()) {
			return optpatient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewPatient.class)
	public Patient create(@RequestBody Patient patient) {
		patient = patientRepo.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient update(@RequestBody Patient patient, @PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		patient = patientRepo.save(patient);
		return patient;
	}
	@PatchMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public ResponseEntity<Patient> partialUpdate(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}

		Patient PatientFind = patientRepo.findById(id).get();

		if (updates.containsKey("nom")) {
			PatientFind.setNom((String) updates.get("nom"));
		}
		if (updates.containsKey("prenom")) {
			PatientFind.setPrenom((String) updates.get("prenom"));
		}
		if (updates.containsKey("mail")) {
			PatientFind.setMail((String) updates.get("mail"));
		}
		if (updates.containsKey("mdp")) {
			PatientFind.setMdp((String) updates.get("mdp"));
		}
		if (updates.containsKey("numSecuriteSociale")) {
			PatientFind.setNumSecuriteSociale((String) updates.get("numSecuriteSociale"));
		}


		PatientFind = patientRepo.save(PatientFind);

		return new ResponseEntity<Patient>(PatientFind, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!patientRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		patientRepo.deleteById(id);
	}
}
