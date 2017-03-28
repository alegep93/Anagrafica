package com.anagrafica.persona;

public class DipendenteAzienda2 extends Dipendente{
	public DipendenteAzienda2(String nome, String cognome, String cf, String nomeAzienda){
		super(nome,cognome,cf,nomeAzienda);
		this.matricola = calcolaMatricola();
	}
	
	@Override
	protected String calcolaMatricola(){
		String nome = this.nome.substring(0, 3);
		String cognome = this.cognome.substring(0, 3);
		return "\"" + nome + cognome + "\"";
	}
}