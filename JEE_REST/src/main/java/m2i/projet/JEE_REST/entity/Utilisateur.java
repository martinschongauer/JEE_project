package m2i.projet.JEE_REST.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUser;
	@Column(nullable = false)
	private String nomUser;
	@Column(nullable = false)
	private String prenomUser;
	@Column(nullable = false, unique = true)
	private String mailUser;
	@Column(nullable = false)
	private Integer roleUser;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Emprunt> emprunts;
}
