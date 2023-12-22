package m2i.projet.JEE_REST.service;

import java.util.List;

import m2i.projet.JEE_REST.dto.ExemplaireDTO;
import m2i.projet.JEE_REST.entity.Exemplaire;

public interface ExemplaireService {

	ExemplaireDTO save(Exemplaire exemplaire);
	
	ExemplaireDTO findById(Integer id);
	
	//Liste des exemplaires totaux
	List<Exemplaire> findAll();
	
	void deleteById(Integer id);
	
	//Liste des exemplaires disponibles
	List<Exemplaire> findExemplairesDisponibles(String isbn); 
	
	//Liste des exemplaires indisponibles (entrée dans la table emprunt avec ou sans date de début)
	List<Exemplaire> findExemplairesIndisponibles(String isbn);
	
	//Nombre total d'exemplaires pour un livre
	int countByIsbnLivre(String isbn);
	
	//Nombre d'exemplaires disponibles pour un livre
	int countExemplairesDisponibles(String isbn);
	
	//Nombre d'exemplaires empruntés pour un livre
	int countExemplairesIndisponibles(String isbn);

	void updateExemplaire(ExemplaireDTO exemplaireDTO, Integer id);

}