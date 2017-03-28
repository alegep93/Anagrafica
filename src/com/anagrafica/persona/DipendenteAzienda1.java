package com.anagrafica.persona;

public class DipendenteAzienda1 extends Dipendente{
	public DipendenteAzienda1(String nome, String cognome, String cf, String nomeAzienda){
		super(nome,cognome,cf,nomeAzienda);
		this.matricola = calcolaMatricola(); 
	}
	
	@Override
	protected String calcolaMatricola(){
		String nome = this.nome.substring(0, 2);
		String cognome = this.cognome.substring(0, 2);
		int randNum = (int)(Math.random() * 100);
		return "\"" + nome + cognome + String.valueOf(randNum) + "\"";
	}
}
