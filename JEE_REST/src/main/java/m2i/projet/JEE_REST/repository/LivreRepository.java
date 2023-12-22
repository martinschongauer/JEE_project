package m2i.projet.JEE_REST.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {
    
    @Query("SELECT l FROM Livre l WHERE titreLivre LIKE ?1 AND auteur LIKE ?2 AND editeur LIKE ?3")
	List<Livre> getLivreFiltered(String s1, String s2, String s3);
    
	List<Livre> findByAuteurContaining(String auteur);
	List<Livre> findByEditeurContaining(String editeur);
}
