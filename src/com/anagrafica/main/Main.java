package com.anagrafica.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.anagrafica.persona.DipendenteAzienda1;
import com.anagrafica.persona.DipendenteAzienda2;
import com.anagrafica.persona.Persona;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Persona[] pList = new Persona[2];
		String welcomeMessage = "", input = "";
		int counter = 0;

		for(int i=0; i<args.length; i++)
			welcomeMessage += args[i];

		System.out.format("Ciao %-10.10s\r\n", welcomeMessage);

		printMsg();

		while(!("q".equals(input = scan.nextLine()))){
			switch(input){
				case "n":
					if(counter < pList.length){
						pList[counter] = inserisciPers(scan);
						counter++;
						printMsg();
					}else{
						System.err.println("Non � possibile inserire una nuova persona!");
						printMsg();
					}
				break;
				case "l":
					System.out.println("---");
					System.out.format("Sono state inserite %-1d persone \r\n", counter);
					System.out.println("---");
					printMsg();
				break;
				case "d":
					if(counter != 0){
						for(int i=0; i<counter; i++){
							pList[i].printPersona();
						}
					}else{
						System.out.println("---");
						System.out.println("Non sono ancora state inserite delle persone");
						System.out.println("---");
					}
					printMsg();
				break;
				default:
					System.err.println("Comando inserito non valido, scegli un comando tra quelli disponibili!");
					printMsg();
				break;
			}
		}
		System.out.println("Esecuzione Terminata!");
		scan.close();
	}

	public static void printMsg(){
		System.out.println("Scegli un'azione tra le seguenti: ");
		System.out.println("  n => Inserisci una nuova persona");
		System.out.println("  l => Visualizza il numero di persone inserite");
		System.out.println("  d => Visualizza i dati delle persone inserite");
		System.out.println("  q => Termina il programma");
	}

	public static Persona inserisciPers(Scanner scan){
		Persona pers;

		System.out.println("Inserisci il nome: ");
		String nome = scan.nextLine();

		System.out.println("Inserisci il cognome: ");
		String cognome = scan.nextLine();

		System.out.println("Inserisci il codice fiscale: ");
		String cf = scan.nextLine();
		
		while(!(controllaCF(cf))){			
			System.out.println("Il codice fiscale NON ha il formato corretto");
			System.out.println("Inserisci un Codice Fiscale valido: ");
			cf = scan.nextLine();
		}

		System.out.println("Inserisci il nome dell'azienda: ");
		String nomeAzienda = scan.nextLine();

		System.out.println("Inserisci il codice azienda [1 o 2]: ");
		String codAzienda = scan.nextLine();

		while(!("1".equals(codAzienda) || "2".equals(codAzienda))){
			System.out.println("Codice Azienda Errato - Inserisci 1 oppure 2: ");
			codAzienda = scan.nextLine();
		}

		if("1".equals(codAzienda))
			pers = new DipendenteAzienda1(nome, cognome, cf, nomeAzienda);
		else
			pers = new DipendenteAzienda2(nome, cognome, cf, nomeAzienda);

		return pers;
	}

	public static boolean controllaCF(String cf){
		Pattern cfRegExp = Pattern.compile("[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z0-9]{4}[A-Za-z]{1}");
		Matcher match = cfRegExp.matcher(cf);

		if(match.matches())
			return true;
		else
			return false;
	}
}
