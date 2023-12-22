package m2i.projet.JEE_REST.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.Emprunt;


@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {
	
	@Query("SELECT e FROM Emprunt e")
	List<Emprunt> findAllEmprunts();
	
	@Query("SELECT e FROM Emprunt e WHERE e.dateDebut IS NULL")
	List<Emprunt> findEmpruntsToValidate();

    @Query(value = "SELECT * FROM emprunt WHERE DATE_ADD(date_debut, INTERVAL duree_emprunt DAY) <= CURRENT_DATE", nativeQuery = true)
    List<Emprunt> findEmpruntsExpires();
    
    @Query("UPDATE Emprunt e SET e.dateDebut = CURRENT_DATE WHERE e.id = :empruntId")
    @Modifying
    void updateDateDebutToCurrentDate(@Param("empruntId") Integer empruntId);

    @Query("UPDATE Emprunt e SET e.dateDebut = :dateDebut, e.dureeEmprunt = :duree WHERE e.id = :empruntId")
    @Modifying
    void updateEmprunt(@Param("empruntId") Integer empruntId, @Param("dateDebut") LocalDate dateDebut, @Param("duree") Integer duree);
}