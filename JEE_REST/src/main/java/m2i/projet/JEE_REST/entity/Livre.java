package m2i.projet.JEE_REST.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Livre {

	@Id
	private String isbnLivre;
	@Column(nullable = false)
	private String titreLivre;
	@Column(nullable = false)
	private String auteur;
	@Column(nullable = false)
	private String editeur;
	
	@JoinColumn(nullable = false)
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private TypeLivre typeLivre;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "isbnLivre", referencedColumnName = "isbnLivre")
	private List<Exemplaire> exemplaires;

	public String getIsbnLivre() {
		return isbnLivre;
	}

	public void setIsbnLivre(String isbnLivre) {
		this.isbnLivre = isbnLivre;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public TypeLivre getTypeLivre() {
		return typeLivre;
	}

	public void setTypeLivre(TypeLivre typeLivre) {
		this.typeLivre = typeLivre;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public Livre() {
		super();
	}

	public Livre(String isbnLivre, String titreLivre, String auteur, String editeur, TypeLivre typeLivre) {
		super();
		this.isbnLivre = isbnLivre;
		this.titreLivre = titreLivre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.typeLivre = typeLivre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur, editeur, exemplaires, isbnLivre, titreLivre, typeLivre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Livre)) {
			return false;
		}
		Livre other = (Livre) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(editeur, other.editeur)
				&& Objects.equals(exemplaires, other.exemplaires) && Objects.equals(isbnLivre, other.isbnLivre)
				&& Objects.equals(titreLivre, other.titreLivre) && Objects.equals(typeLivre, other.typeLivre);
	}

	@Override
	public String toString() {
		return "Livre [isbnLivre=" + isbnLivre + ", titreLivre=" + titreLivre + ", auteur=" + auteur + ", editeur="
				+ editeur + ", typeLivre=" + typeLivre.getNomType() + "]";
	}
	
}
