package com.anagrafica.persona;

public class Persona {
	protected String nome,cognome,cf;
	
	public Persona(){
		nome = cognome = cf = "";
	}
	
	public Persona(String nome, String cognome, String cf){
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public void printPersona(){
		System.out.println("-----------------------");
		System.out.println("Nome:           " + this.nome);
		System.out.println("Cognome:        " + this.cognome);
		System.out.println("Codice Fiscale: " + this.cf);
	}
	
	public String toString(){
		String s = "";
		return s;
	}
}
