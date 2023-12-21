package m2i.projet.JEE_REST.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import m2i.projet.JEE_REST.repository.ExemplaireRepository;
import m2i.projet.JEE_REST.service.ExemplaireService;

public class ExemplaireServiceImp implements ExemplaireService {
	@Autowired
	ExemplaireRepository exemplaireRepository;
}
