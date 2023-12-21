package m2i.projet.JEE_REST.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import m2i.projet.JEE_REST.repository.LivreRepository;
import m2i.projet.JEE_REST.service.LivreService;

public class LivreServiceImp implements LivreService {
	@Autowired
	LivreRepository livreRepository;
}
