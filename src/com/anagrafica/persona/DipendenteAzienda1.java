package com.anagrafica.persona;

public class DipendenteAzienda1 extends Dipendente{
	public DipendenteAzienda1(String nome, String cognome, String cf, String nomeAzienda){
		super(nome,cognome,cf,nomeAzienda);
		this.matricola = calcolaMatricola(); 
	}
	
	@Override
	protected String calcolaMatricola(){
		String nome, cognome;
		double randNum;
		
		if(this.nome.length()>2)
			nome = this.nome.substring(0, 2);
		else
			nome = this.nome;
		
		if(this.cognome.length()>2)
			cognome = this.cognome.substring(0, 2);
		else
			cognome = this.cognome;
		
		randNum = (int)(Math.random() * 100);
		return "\"" + nome + cognome + String.valueOf(randNum) + "\"";
	}
}
