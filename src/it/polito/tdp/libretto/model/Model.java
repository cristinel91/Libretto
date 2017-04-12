package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;


public class Model {
	
	private HashMap<String,Esame> esami=null;
	
	public Model() {
		this.esami=new HashMap<String,Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti,
	 * verificando che non ci sia già
	 * @param e
	 * @return true se l'ha inserito, false se esisteva già e quindi non l'ha potuto inserire
	 */
	public boolean addEsame(Esame e) {
		EsameDAO dao=new EsameDAO();
		return dao.create(e);
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste, lo restituisce, altrimenti restituisce null.
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice) {
		EsameDAO dao=new EsameDAO();
		Esame e=dao.find(codice);
		return e;
	}

}
