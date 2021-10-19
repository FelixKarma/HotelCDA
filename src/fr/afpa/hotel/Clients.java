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

//public Clients(int unId, String unNom, String unPrenom, String unNumero, String unMail, String unLogin, String unMdp) {
//		
//		id=unId;
//		nom=unNom;
//		prenom=unPrenom;
//		numero=unNumero;
//		mail=unMail;
//		login=unLogin;
//		mdp=unMdp;
//		
//	}

	String nomClient[] = { "Callet", "TheCat", "Shoto" };
	String prenomClient[] = { "Kevin", "Billy", "Karma" };
	String numeroClient[] = { "0616186124", "0615482659", "0623147859" };
	String mailClient[] = { "j.dupont@gmail.com", "b.thecat@gmail.com", "k.shoto@gmail.com" };
	String cbClient[] = { "0000000000000000", "1111111111111111", "2222222222222222" };

	public static boolean connexionClt(boolean connexionClient) {
		String loginClient[] = { "0", "1234567890", "2345678901" };
		String mdpClient[] = { "0", "billou", "karmater" };
		Scanner in = new Scanner(System.in);
		System.out.print("Entrez votre login : ");
		String login = in.next();
		System.out.print("Entrez votre mot de passe : ");
		String mdp = in.next();
		for (int i = 0; i < 3; i++) {
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
