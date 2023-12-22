package m2i.projet.JEE_REST.service;

import java.util.List;

import m2i.projet.JEE_REST.dto.UtilisateurDTO;
import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Utilisateur;

public interface UtilisateurService {
	/**Service de Lecture d'un utilisateur renvoyant un utilisateur**/
	public Utilisateur getUser(String email);
	
	/**Service de Lecture d'un utilisateur renvoyant un utilisateur DTO**/
	public UtilisateurDTO getUserDTO(String email);
	
	/**Service de creation d'un utilisateur**/
	public void createUser(UtilisateurDTO userDTO);
	
	/**Service de supression d'un utilisateur**/
	public void deleteUser(Utilisateur user);
	
	/**Service de supression d'un utilisateur a partir d'ub DTO**/
	public void deleteUserDTO(UtilisateurDTO userDTO);
	
	/**Service de mise a jour d'un utilisateur**/
	public void updateUser(UtilisateurDTO userDTO, Integer id );
	
	/**Service de consultation de la totalité des utilisateur dans une liste**/
	public List<Utilisateur> getUtilisateurs();
	
	/**Service de consultation de la totalité des utilisateur dans une liste**/
	public List<UtilisateurDTO> getUtilisateursDTO();
	
	/**Service de consultation des emprunts d'un utilisateur dans une liste**/
	public List<Emprunt> getEmpruntFromUser(UtilisateurDTO user);
}

