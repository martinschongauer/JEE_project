package m2i.projet.JEE_REST.dto;

import java.time.LocalDate;

import m2i.projet.JEE_REST.entity.Livre;

public class EmpruntDTO {
	private LocalDate dateDebut;
	private Integer dureeEmprunt;
	private Livre livre;
	
	
	public EmpruntDTO() {
		super();
	}
	
	public EmpruntDTO(LocalDate dateDebut, Integer dureeEmprunt, Livre livre) {
		super();
		this.dateDebut = dateDebut;
		this.dureeEmprunt = dureeEmprunt;
		this.livre = livre;
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

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	@Override
	public String toString() {
		return "EmpruntDTO [dateDebut=" + dateDebut + ", dureeEmprunt=" + dureeEmprunt + ", livre=" + livre + "]";
	}
	
}
