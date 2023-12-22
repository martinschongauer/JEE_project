package m2i.projet.JEE_REST.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.projet.JEE_REST.repository.EmpruntRepository;
import m2i.projet.JEE_REST.service.EmpruntService;

@Service
public class EmpruntServiceImp implements EmpruntService {
	@Autowired
	EmpruntRepository empruntRepository;
}
