package com.anagrafica.main;

import java.awt.PageAttributes;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.anagrafica.persona.Persona;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Persona[] pList = new Persona[2];
		String welcomeMessage = "", input = "";
		int counter = 0;
		
		for(int i=0; i<args.length; i++)
			welcomeMessage += args[i];
		
		System.out.println("Ciao " + welcomeMessage);
		
		printMsg();
		
		while(!("q".equals(input = scan.nextLine()))){
			switch(input){
				case "n":
					if(counter < pList.length){
						pList[counter] = inserisciPers(scan);
						counter++;
						printMsg();
					}else{
						System.err.println("Non è possibile inserire una nuova persona!");
						printMsg();
					}
				break;
				case "l":
					System.out.println("---");
					System.out.println("Sono state inserite " + counter + " persone");
					System.out.println("---");
					printMsg();
				break;
				case "d":
					if(counter != 0){
						for(int i=0; i<counter; i++){
							Persona.printPersona(pList[i].getNome(), pList[i].getCognome(), pList[i].getCf());
						}
					}else{
						System.out.println("---");
						System.out.println("Non sono ancora state inserite delle persone");
						System.out.println("---");
					}
					printMsg();
				break;
			}
		}
		System.out.println("Esecuzione Terminata!");
		scan.close();
	}
	
	public static void printMsg(){
		System.out.println("Scegli un'azione tra le seguenti: ");
		System.out.println("  n - Inserisci una nuova persona");
		System.out.println("  l - Visualizza il numero di persone inserite");
		System.out.println("  d - Visualizza i dati delle persone inserite");
		System.out.println("  q - Termina il programma");
	}
	
	public static Persona inserisciPers(Scanner scan){
		Persona p;
		
		System.out.println("Inserisci il nome: ");
		String nome = scan.nextLine();
		
		System.out.println("Inserisci il cognome: ");
		String cognome = scan.nextLine();
		
		System.out.println("Inserisci il codice fiscale: ");
		String cf = scan.nextLine();
		
		while(!(controllaCF(cf))){
			System.err.println("Il codice fiscale NON ha il formato corretto");
			
			System.out.println("Inserisci il codice fiscale: ");
			cf = scan.nextLine();
		}
		
		p = new Persona(nome, cognome, cf);
		
		return p;
	}
	
	public static boolean controllaCF(String cf){
		Pattern cfRegExp = Pattern.compile("[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z0-9]{4}[A-Za-z]{1}");
		Matcher match = cfRegExp.matcher(cf);
		Boolean cfMatch = match.matches();
		
		if(cfMatch)
			return true;
		else
			return false;
	}
}
