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

	public static boolean connexionEmp(boolean connexionClient) {
		Scanner in = new Scanner(System.in);
		String loginEmp[] = { "GH001", "GH002", "GH003", "GH004", "GH005" };
		String mdpEmp[] = { "GH001", "GH002", "GH003", "GH004", "GH005" };
		System.out.print("Votre login: ");
		String login = in.next().toUpperCase();
		System.out.print("Votre mdp: ");
		String mdp = in.next().toUpperCase();

		for (int i = 0; i < 5; i++) {
			if (login.equals(loginEmp[i]) && mdp.equals(mdpEmp[i])) {
				connexionClient = true;
				break;
			}
			if (i == 2 && (!login.equals(loginEmp[i]) || !mdp.equals(mdpEmp[i]))) {
				System.out.println("Login ou mot de passe erronnée");
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
