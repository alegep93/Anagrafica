package com.anagrafica.persona;

public abstract class Dipendente extends Persona {
	protected String matricola, nomeAzienda;
	
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
		System.out.format("%-16s %s \r\n", "Matricola:", this.matricola);
		System.out.format("%-16s %s \r\n", "Nome azienda:", this.nomeAzienda);
		System.out.println("-----------------------");
	}
}
