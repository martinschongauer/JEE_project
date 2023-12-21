package m2i.projet.JEE_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Exemplaire;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

}
