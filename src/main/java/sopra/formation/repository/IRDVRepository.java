package sopra.formation.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import sopra.formation.model.RDV;

public interface IRDVRepository extends JpaRepository<RDV, Long> {
	
}
