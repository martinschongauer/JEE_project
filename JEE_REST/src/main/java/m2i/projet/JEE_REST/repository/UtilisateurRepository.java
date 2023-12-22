package m2i.projet.JEE_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	@Query("SELECT u FROM Utilisateur u where mailUser = ?1")
	public Utilisateur getClientWithMail(String mail);
}
