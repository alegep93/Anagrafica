package com.anagrafica.persona;

public abstract class Dipendente extends Persona {
	String matricola, nomeAzienda;
	
	public Dipendente(String nome, String cognome, String cf, String nomeAzienda){
		super(nome, cognome, cf);
		this.matricola = calcolaMatricola();
		this.nomeAzienda = nomeAzienda;
	}

	public String getMatricola() {
		return matricola;
	}
	
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	
	protected abstract String calcolaMatricola();
	
	@Override
	public void printPersona(){
		super.printPersona();
		System.out.println("Matricola:      " + this.matricola);
		System.out.println("Nome Azienda:   " + this.nomeAzienda);
		System.out.println("-----------------------");
	}
}
