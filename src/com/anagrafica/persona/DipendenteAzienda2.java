package com.anagrafica.persona;

public class DipendenteAzienda2 extends Dipendente{
	public DipendenteAzienda2(String nome, String cognome, String cf, String nomeAzienda){
		super(nome,cognome,cf,nomeAzienda);
		this.matricola = calcolaMatricola();
	}
	
	@Override
	protected String calcolaMatricola(){
		String nome, cognome;
		
		if(this.nome.length()>3)
			nome = this.nome.substring(0, 3);
		else
			nome = this.nome;
		
		if(this.cognome.length()>3)
			cognome = this.cognome.substring(0, 3);
		else
			cognome = this.cognome;
		
		return "\"" + nome + cognome + "\"";
	}
}