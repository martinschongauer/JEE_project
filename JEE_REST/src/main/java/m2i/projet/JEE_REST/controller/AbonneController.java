package m2i.projet.JEE_REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.projet.JEE_REST.dto.EmpruntDTO;
import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Exemplaire;
import m2i.projet.JEE_REST.entity.Livre;
import m2i.projet.JEE_REST.entity.Utilisateur;
import m2i.projet.JEE_REST.repository.LivreRepository;
import m2i.projet.JEE_REST.repository.UtilisateurRepository;
import m2i.projet.JEE_REST.service.EmpruntService;
import m2i.projet.JEE_REST.service.imp.EmpruntServiceImp;


@RestController
@RequestMapping("/lagrandelibrairie/user/")
public class AbonneController {
	@Autowired
	EmpruntService empruntService;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	LivreRepository livreRepository;
	@PostMapping("{idUser}/livres/{isbnLivre}")
	public String addNewEmprunt(@PathVariable("idUser") Integer idUser,@PathVariable("isbnLivre") String idLivre) {
		Emprunt newEmprunt = new Emprunt();
		Utilisateur utilisateur = utilisateurRepository.getReferenceById(idUser);
		Livre livre = livreRepository.getReferenceById(idLivre);
		// TODO : rajouter un test si il reste des exemplaires dispo
		List <Exemplaire> exemplaires =  livre.getExemplaires();
		// TODO : Rajouter un filtre sur les exemplaire deja reservée
		newEmprunt.setExemplaire(exemplaires.get(0));
		newEmprunt.setUtilisateur(utilisateur);
		return empruntService.save(newEmprunt).toString();
	}
	@GetMapping("/{idUser}/emprunts")
	public String findEmpruntsForUser(@PathVariable("idUser") Integer idUser) {
		Utilisateur utilisateur = utilisateurRepository.getReferenceById(idUser);
		return utilisateur.getEmprunts().toString();
	}
}
