package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

}
