package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
