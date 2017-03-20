package it.polito.tdp.libretto.model;

import java.time.LocalDate; // per la data 

/** oggetto semplice che contiene i dati relativi ad un singolo esame.
 *  POJO - plain old java object
 *  dati privati (proprietà)
 *  costruttore, metodi get/set, metodi di servizio (toString, equals, hashCode, compareTo)*/

public class Esame {
	
	private String codice;
	private String titolo;
	private String docente;
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * nuovo esame, non ancora superato
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) { 
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato=false;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public boolean isSuperato() {
		return superato;
	}

	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	public int getVoto() {
		if(this.superato)
			return voto;
		else throw new IllegalStateException("Esame "+this.codice+"già superato");
	}

	private void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataSuperamento() {
		return dataSuperamento;
	}

	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/** Se l'esame non è ancora superato lo considera superato con il voto e la data specificati-
	 * Se invece l'esame era già superato, genere eccezione.
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		if(!this.superato){
			this.superato=true;
			this.voto=voto;
			this.dataSuperamento=data;
		} else {
			throw new IllegalStateException("Esame "+this.codice+" già superato");
		}
	}
	
	
}
