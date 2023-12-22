package m2i.projet.JEE_REST.entity;

import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Exemplaire {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idExemplaire;
	@Column(nullable = false)
	private String isbnLivre;
	private String integriteLivre;
	
	@OneToOne(mappedBy = "exemplaire", cascade = CascadeType.ALL)
	private Emprunt emprunt;
	
	public String getIsbnLivre() {
		return isbnLivre;
	}
	
	public void setIsbnLivre(String isbnLivre) {
		this.isbnLivre = isbnLivre;
	}
	
	public String getIntegriteLivre() {
		return integriteLivre;
	}
	
	public void setIntegriteLivre(String integriteLivre) {
		this.integriteLivre = integriteLivre;
	}
	
	public Integer getIdExemplaire() {
		return idExemplaire;
	}
	
	

	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Exemplaire() {
		super();
	}

	public Exemplaire(String isbnLivre, String integriteLivre) {
		super();
		this.isbnLivre = isbnLivre;
		this.integriteLivre = integriteLivre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idExemplaire, integriteLivre, isbnLivre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Exemplaire)) {
			return false;
		}
		Exemplaire other = (Exemplaire) obj;
		return Objects.equals(idExemplaire, other.idExemplaire) && Objects.equals(integriteLivre, other.integriteLivre)
				&& Objects.equals(isbnLivre, other.isbnLivre);
	}

	@Override
	public String toString() {
		return "Exemplaire [idExemplaire=" + idExemplaire + ", isbnLivre=" + isbnLivre + ", integriteLivre="
				+ integriteLivre + "]";
	}

	public void setIsbnLivre(Optional<String> isbn) {
		// TODO Auto-generated method stub
		
	}

	public void setIntegriteLivre(Optional<String> integrite) {
		// TODO Auto-generated method stub
		
	}

}
