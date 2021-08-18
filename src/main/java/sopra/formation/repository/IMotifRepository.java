package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Motif;
import sopra.formation.model.RDV;

public interface IMotifRepository extends JpaRepository<Motif, Long> {
	
}
