package m2i.projet.JEE_REST.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.projet.JEE_REST.dto.UtilisateurDTO;
import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Utilisateur;
import m2i.projet.JEE_REST.repository.UtilisateurRepository;
import m2i.projet.JEE_REST.service.UtilisateurService;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
	
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	
	@Override
	public Utilisateur getUser(String email) {
		Utilisateur user = new Utilisateur();
		// recherche de l'utilisateur a supprimer
		user = utilisateurRepository.getClientWithMail(email);
		return user;
	}
	@Override
	public UtilisateurDTO getUserDTO(String email) {
		UtilisateurDTO userDTO = new UtilisateurDTO(utilisateurRepository.getClientWithMail(email));
		return userDTO;
	}

	@Override
	public void createUser(UtilisateurDTO userDTO) {
		Utilisateur user = new Utilisateur();
		user.setMailUser(userDTO.getMailUser());
		user.setNomUser(userDTO.getNomUser());
		user.setPrenomUser(userDTO.getPrenomUser());
		user.setRoleUser(userDTO.getRoleUser());
		utilisateurRepository.save(user);
	}
	
	@Override
	public void deleteUser(Utilisateur user) {
		//supression de l'utilisateur via le repository
		utilisateurRepository.delete(user);
	}

	@Override
	public void deleteUserDTO(UtilisateurDTO userDTO) {
		Utilisateur user = new Utilisateur();
		// recherche de l'utilisateur a supprimer
		user = utilisateurRepository.getClientWithMail(userDTO.getMailUser());
		// supression de l'utilisateur
		deleteUser(user);

	}

	@Override
	public void updateUser(UtilisateurDTO userDTO, Integer id) {
		Utilisateur userToUpdate = new Utilisateur();
		Optional<Utilisateur> userTampon = utilisateurRepository.findById(id);
		if(userTampon.isPresent())
		{
			userToUpdate = userTampon.get();
			userToUpdate.setNomUser(userDTO.getNomUser());
			userToUpdate.setPrenomUser(userDTO.getPrenomUser());
			userToUpdate.setMailUser(userDTO.getMailUser());
			// mise a jour de l'utilisateur
			utilisateurRepository.save(userToUpdate);	
		}else 
		{
			return;
		}
	
	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();
	}
	
	@Override
	public List<UtilisateurDTO> getUtilisateursDTO() {
		List<Utilisateur>  users = new ArrayList<Utilisateur>();
		List<UtilisateurDTO>  usersDTO = new ArrayList<UtilisateurDTO>();
		for(Utilisateur u : users )
		{
			usersDTO.add(new UtilisateurDTO(u));
		}
		return usersDTO;
		
			
	}

	@Override
	public List<Emprunt> getEmpruntFromUser(UtilisateurDTO user) {
		return null;
	}
	


}
