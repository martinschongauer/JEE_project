package m2i.projet.JEE_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.projet.JEE_REST.entity.TypeLivre;

@Repository
public interface TypeLivreRepository extends JpaRepository<TypeLivre, Integer> {

}
