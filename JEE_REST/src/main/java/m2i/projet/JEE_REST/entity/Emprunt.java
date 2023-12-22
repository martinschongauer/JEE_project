package m2i.projet.JEE_REST.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Emprunt {
	
	@Id
    private Integer id; // Clé primaire de Emprunt

    @OneToOne 
    @MapsId("id")
    @JoinColumn(name = "id_exemplaire")
    private Exemplaire exemplaire;

	@JsonIgnoreProperties
	@ManyToOne 
	@JoinColumn(name = "id_utilisateur")
	Utilisateur utilisateur;
	
	private LocalDate dateDebut;
	private Integer dureeEmprunt;
	
	public Emprunt() {
		super();
	}

	public Emprunt(Exemplaire exemplaire, Utilisateur utilisateur, LocalDate dateDebut, Integer dureeEmprunt) {
		super();
		this.id = exemplaire.getIdExemplaire();
		this.exemplaire = exemplaire;
		this.utilisateur = utilisateur;
		this.dateDebut = dateDebut;
		this.dureeEmprunt = dureeEmprunt;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
		return "Emprunt [id=" + id + ", exemplaire=" + exemplaire.getIdExemplaire() + ", utilisateur=" + utilisateur.getIdUser() + ", dateDebut="
				+ dateDebut + ", dureeEmprunt=" + dureeEmprunt + "]";
	}



}
