package m2i.projet.JEE_REST.dto;

import java.time.LocalDate;

public class EmpruntDateDTO {
	private LocalDate dateDebut;
	private Integer dureeEmprunt;
	
	
	public EmpruntDateDTO() {
		super();
	}
	public EmpruntDateDTO(LocalDate dateDebut, Integer dureeEmprunt) {
		super();
		this.dateDebut = dateDebut;
		this.dureeEmprunt = dureeEmprunt;
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
	
}
