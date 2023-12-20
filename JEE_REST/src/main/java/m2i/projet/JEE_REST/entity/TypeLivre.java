package m2i.projet.JEE_REST.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeLivre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idType;
	@Column(nullable = false)
	private String nomType;
	
	// cascade = CascadeType.ALL ?
	@OneToMany
	private List<Livre> livres;
}
