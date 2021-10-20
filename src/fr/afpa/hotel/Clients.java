package fr.afpa.hotel;

import java.util.Scanner;

public class Clients {
	private int id;
	private String nom;
	private String prenom;
	private String numero;
	private String cb;
	private String mail;
	private String login;
	private String mdp;
	static Scanner in = new Scanner(System.in);

	String nomClient[] = { "Callet", "TheCat", "Shoto", "Nedved" };
	String prenomClient[] = { "Kevin", "Billy", "Karma", "Singed" };
	String numeroClient[] = { "0616186124", "0615482659", "0623147859", "0623647159" };
	String mailClient[] = { "j.dupont@gmail.com", "b.thecat@gmail.com", "k.shoto@gmail.com", "dzqd.gmail.com" };
	String cbClient[] = { "0000000000000000", "0000000000000000", "0000000000000000", "0000000000000000" };
	static String loginClient[] = { "0123456789", "1234567890", "2345678901", "3456789012" };
	static String mdpClient[] = { "0123456789", "1234567890", "2345678901", "3456789012" };

	public static boolean connexionClt(boolean connexionClient) {

		System.out.print("Entrez votre login : ");
		String login = in.next().toUpperCase();
		System.out.print("Entrez votre mot de passe : ");
		String mdp = in.next().toUpperCase();
		for (int i = 0; i < 4; i++) {
			if (login.equals(loginClient[i]) && mdp.equals(mdpClient[i])) {
				connexionClient = true;
				break;
			}
			if (i == 2 && (!login.equals(loginClient[i]) || !mdp.equals(mdpClient[i]))) {
				System.out.println("Login ou mot de passe erronée");
			}
		}
		return connexionClient;
	}

	public void affichageReservation() {
		for (int i = 0; i < 3; i++) {
			if (login.equals(loginClient[i]) && mdp.equals(mdpClient[i])) {
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
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
