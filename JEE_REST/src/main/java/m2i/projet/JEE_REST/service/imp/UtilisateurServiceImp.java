package m2i.projet.JEE_REST.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import m2i.projet.JEE_REST.repository.UtilisateurRepository;
import m2i.projet.JEE_REST.service.UtilisateurService;

public class UtilisateurServiceImp implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
}
