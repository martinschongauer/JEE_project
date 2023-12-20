package m2i.projet.JEE_REST.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Emprunt {

	@EmbeddedId
	EmpruntKey id;
	
	@JsonIgnoreProperties
	@ManyToOne
	@MapsId("idUtilisateur")
	@JoinColumn(name = "id_utilisateur")
	Utilisateur utilisateur;
	
	@JsonIgnoreProperties
	@OneToOne
	@MapsId("idExemplaire")
	@JoinColumn(name = "id_exemplaire")
	Exemplaire exemplaire;
	
	private LocalDate dateDebut;
	private Integer dureeEmprunt;
	
	public Emprunt() {
		super();
	}

	public Emprunt(Utilisateur utilisateur, Exemplaire exemplaire, LocalDate dateDebut, Integer dureeEmprunt) {
		super();
		this.utilisateur = utilisateur;
		this.exemplaire = exemplaire;
		this.dateDebut = dateDebut;
		this.dureeEmprunt = dureeEmprunt;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Integer getDureeEmprunt() {
		return dureeEmprunt;
	}

	public void setDureeEmprunt(Integer dureeEmprunt) {
		this.dureeEmprunt = dureeEmprunt;
	}

	public EmpruntKey getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dureeEmprunt, exemplaire, id, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Emprunt)) {
			return false;
		}
		Emprunt other = (Emprunt) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dureeEmprunt, other.dureeEmprunt)
				&& Objects.equals(exemplaire, other.exemplaire) && Objects.equals(id, other.id)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", utilisateur=" + utilisateur.getIdUser() + ", exemplaire=" + exemplaire.getIsbnLivre() + ", dateDebut="
				+ dateDebut + ", dureeEmprunt=" + dureeEmprunt + "]";
	}

}
