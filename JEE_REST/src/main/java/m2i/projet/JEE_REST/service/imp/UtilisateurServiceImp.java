package m2i.projet.JEE_REST.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.projet.JEE_REST.repository.UtilisateurRepository;
import m2i.projet.JEE_REST.service.UtilisateurService;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
}
