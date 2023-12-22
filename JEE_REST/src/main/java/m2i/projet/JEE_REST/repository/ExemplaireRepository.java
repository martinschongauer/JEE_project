package m2i.projet.JEE_REST.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.Exemplaire;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
	
	//Récupérer la liste des exemplaires disponibles pour un livre
	@Query("SELECT ex FROM Exemplaire ex WHERE ex.isbnLivre like ?1 AND ex.idExemplaire not in (select id from Emprunt)")
	List<Exemplaire> findExemplairesDisponibles(String isbn);
	
	//Récupérer la liste des exemplaires indisponibles pour un livre
	@Query("SELECT ex FROM Exemplaire ex, Emprunt em WHERE ex.isbnLivre like ?1 AND ex.idExemplaire=em.id")
	List<Exemplaire> findExemplairesIndisponibles(String isbn);	
	
	//Compter le nombre total d'exemplaire d'un livre
	int countByIsbnLivre(String isbn);
	
	//Compter le nombre total d'exemplaire disponibles d'un livre
	@Query("SELECT count(ex) FROM Exemplaire ex WHERE ex.isbnLivre like ?1 AND ex.idExemplaire not in (select id from Emprunt)")	
	int countExemplairesDisponibles(String isbn);
	
	//Compter le nombre total d'exemplaire indisponibles d'un livre
	@Query("SELECT count(ex) FROM Exemplaire ex, Emprunt em WHERE ex.isbnLivre like ?1 AND ex.idExemplaire=em.id")	
	int countExemplairesIndisponibles(String isbn);
}
