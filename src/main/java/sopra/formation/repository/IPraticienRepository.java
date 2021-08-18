package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Praticien;



public interface IPraticienRepository extends JpaRepository<Praticien, Long>{

	@Query("select p from Praticien p")
	List<Praticien> findAllPraticien();
	
	@Query("select p from Praticien p where p.id = :id")
	Optional<Praticien> findPraticienById(@Param("id") Long id);
	
}
