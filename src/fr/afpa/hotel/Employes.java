package fr.afpa.hotel;

import java.util.Scanner;

public class Employes {

	private String nom;
	private String prenom;
	private String numero;
	private String login;
	private String mdp;

	public Employes(String unNom, String unPrenom, String unNumero, String unLogin, String unMdp) {
		nom = unNom;
		prenom = unPrenom;
		numero = unNumero;
		login = unLogin;
		mdp = unMdp;
	}

	String nomEmp[] = { "0", "0", "0" };
	String preEmp[] = { "0", "0", "0" };
	String numEmp[] = { "0", "0", "0" };

	public static boolean connexionEmp(boolean connexionClient) {
		String loginEmp[] = { "0", "1234567890", "2345678901" };
		String mdpEmp[] = { "0", "billou", "karmater" };
		Scanner in = new Scanner(System.in);
		System.out.print("Votre login: ");
		String login = in.next();
		System.out.print("Votre mdp: ");
		String mdp = in.next();
		for (int i = 0; i < 3; i++) {
			if (login.equals(loginEmp[i]) && mdp.equals(mdpEmp[i])) {
				connexionClient = true;
				break;
			}
			if (i == 2 && (!login.equals(loginEmp[i]) || !mdp.equals(mdpEmp[i]))) {
				System.out.println("login ou mdp faux");
			}
		}
		return connexionClient;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
