package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

	@Query("select p from Personne p where p.mail = :mail")
	Optional<Personne> findByMail(@Param("mail") String mail);

}
