package m2i.projet.JEE_REST.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpruntKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_utilisateur")
	private Integer idUtilisateur;
	
	@Column(name = "id_exemplaire")
	private Integer idExemplaire;

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idExemplaire, idUtilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmpruntKey)) {
			return false;
		}
		EmpruntKey other = (EmpruntKey) obj;
		return Objects.equals(idExemplaire, other.idExemplaire) && Objects.equals(idUtilisateur, other.idUtilisateur);
	}

}
