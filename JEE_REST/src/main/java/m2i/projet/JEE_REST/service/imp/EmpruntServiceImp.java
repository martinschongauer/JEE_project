package m2i.projet.JEE_REST.service.imp;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
import java.util.List;
>>>>>>> e49f7e3b4ca07034eea6dccda0daf680937c7c9e

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import m2i.projet.JEE_REST.dto.EmpruntDTO;
import m2i.projet.JEE_REST.dto.EmpruntDateDTO;
import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Livre;
import m2i.projet.JEE_REST.repository.EmpruntRepository;
import m2i.projet.JEE_REST.repository.LivreRepository;
import m2i.projet.JEE_REST.service.EmpruntService;

@Service
public class EmpruntServiceImp implements EmpruntService {
	@Autowired
	EmpruntRepository empruntRepository;
	@Autowired
	LivreRepository livreRepository;
	@Override
	public EmpruntDTO save(Emprunt emprunt) {
		empruntRepository.save(emprunt);
		EmpruntDTO empruntDTO = new EmpruntDTO();
		empruntDTO.setDateDebut(emprunt.getDateDebut());
		empruntDTO.setDureeEmprunt(emprunt.getDureeEmprunt());
		Livre livre = livreRepository.findByIsbnLivre(emprunt.getExemplaire().getIsbnLivre());
		empruntDTO.setLivre(livre);
		return empruntDTO;
	}

	@Override
	public EmpruntDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprunt> findAllWithFilter(String filter) {
		 if (filter != null && filter.equals("toValidate")){
				return empruntRepository.findEmpruntsToValidate();
		} else if (filter != null && filter.equals("expired")) {
			return empruntRepository.findEmpruntsExpires();
		}
		return empruntRepository.findAll();

	}
	@Override
	@Transactional
	public void validateEmprunt(Integer empruntId) {
	    empruntRepository.updateDateDebutToCurrentDate(empruntId);
	}

	@Override
	public void delete(Integer id) {
		empruntRepository.deleteById(id);	
		
	}

	@Override
	@Transactional
	public void updateEmprunt(Integer empruntId ,EmpruntDateDTO date) {
		empruntRepository.updateEmprunt(empruntId, date.getDateDebut(),date.getDureeEmprunt());
	}
}
