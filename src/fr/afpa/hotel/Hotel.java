package fr.afpa.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Hotel {
	static Chambres rooms[] = new Chambres[65];
	static boolean dispo[] = new boolean[65];
	static LocalDate StartDate[] = new LocalDate[65];
	static LocalDate EndDate[] = new LocalDate[65];

	int temp = 0;
	Random random = new Random();
	int comparer = 0;
	LocalDate randomDate1;
	LocalDate randomDate2;
	int libre = 1;
	int reserver = 0;
	Scanner in = new Scanner(System.in);
	Clients client = new Clients();

	String typeT[] = { "Chambre Vue Piscine", "Chambre Vue Jardin", "Chambre Vue Océan",
			"Chambre vue imprenable sur l'océan", "Suite CDA", "Suite Executive", "Suite Ambassadeur", "Suite Royale" };

	String superficyT[] = { "44 mètres carrés", "44 mètres carrés", "44 mètres carrés", "44 mètres carrés",
			"82 mètres carrés", "140 mètres carrés", "230 mètres carrés", "342 mètres carrés" };
	String viewT[] = { "Piscine Centrale", "Jardin, Forêt ou Golf", "Partielle Océan et Forêt ou Golf", "Océan",
			"Océan et Golf", "Océan", "Océan", "Océan" };
	String occupationT[] = { "2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans" };
	int priceT[] = { 300, 314, 350, 350, 450, 550, 1650, 2400 };
	int nbRoomsT[] = { 7, 12, 8, 10, 12, 5, 7, 4 };
	String optionsT[] = {
			"Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
			"Fer et planche à repasser sur demande|Téléphone |Télévision par câble|Climatisation|Bouilloire électrique|Concierge 24h/24",
			"Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Fer et planche à repasser sur demande|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Sèche-cheveux|Coffre-fort dans la chambre|Minibar|Téléphone |Accès Internet haut débit sans fil|Lecteur DVD sur demande|Télévision par câble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

	public void listRooms() {
		int temp = 0;
		int idClient = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < nbRoomsT[i]; j++) {
				boolean rand = random.nextBoolean();
				dispo[temp] = rand;
				if (rand == false) {
					idClient = random.nextInt(4);

					LocalDate start = LocalDate.of(2021, 01, 01);
					LocalDate end = LocalDate.of(2021, 12, 31);

					do {
						randomDate1 = between(start, end);
						StartDate[temp] = randomDate1;
						randomDate2 = between(start, end);
						EndDate[temp] = randomDate2;
						comparer = randomDate1.compareTo(randomDate2);
					} while (comparer != -1); // A AMELIORER
				}
				rooms[temp] = new Chambres(temp, typeT[i], superficyT[i], viewT[i], occupationT[i], priceT[i],
						nbRoomsT[i], optionsT[i], client.nomClient[idClient]);
				temp++;
			}
		}
	}

	public void affichage() {
		temp = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < nbRoomsT[i]; j++) {
				int numberRoom = temp + 1;
				if (dispo[temp] == true) {
					int libre = 1;
					String libreTr = Integer.toString(libre);
					libreTr = "Libre";
					System.out.println("  __" + "\n");
					System.out.println(" | " + "Chambre " + numberRoom + " : " + libreTr);
					System.out.println(" | " + "Type : " + typeT[i]);
					System.out.println("  __");
				} else {
					int reserver = 0;
					String reserverTr = Integer.toString(reserver);
					reserverTr = "Réserver";
					System.out.println("  __" + "\n");
					System.out.println(" | " + "Chambre " + numberRoom + " : " + reserverTr);
					System.out.println(" | " + "Type : " + typeT[i]);
					System.out.println(" | " + "Type d'occupant : " + occupationT[i]);
					System.out.println(" | " + "Nom occupant : " + rooms[temp].getNomClt());
					System.out.println(" | Du : " + StartDate[temp].format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					System.out.println(" | Au : " + EndDate[temp].format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					System.out.println("  __");
				}
				temp++;
			}
		}
	}

	public void reservedRooms() {
		int rr = 0;
		for (int i = 0; i < 65; i++) {
			if (dispo[i] == false) {
				rr++;
			}

		}
		System.out.println("  _____" + "\n");
		System.out.println(" | " + "Il y a " + rr + " chambres de réservées !");
		System.out.println("  _____" + "\n");
	}

	public static void freeRooms() {
		int rl = 0;
		for (int i = 0; i < 65; i++) {
			if (dispo[i] == true) {
				rl++;
			}
		}
		System.out.println("  _____" + "\n");
		System.out.println(" | " + "Il y a " + rl + " chambres de libres !");
		System.out.println("  _____" + "\n");
	}

	public void freeRoomsWithInfo() {
		temp = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < nbRoomsT[i]; j++) {

				if (dispo[temp - 1] == true) {
					int libre = 1;
					String libreTr = Integer.toString(libre);
					libreTr = "Libre";
					System.out.println("  __" + "\n");
					System.out.println(" | " + "Chambre " + temp + " : " + libreTr);
					System.out.println(" | " + "Type : " + typeT[i]);
					System.out.println(" | " + "Superficie : " + superficyT[i]);
					System.out.println(" | Vue sur : " + viewT[i]);
					System.out.println(" | " + "Prix : " + priceT[i] + " €");
					System.out.println("  __");
				}
				temp++;
			}
		}
	}

	public void pricePerDate() {
		temp = 1;
		int chiffreAffaire = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < nbRoomsT[i]; j++) {

				if (dispo[temp - 1] == false && StartDate[temp - 1].compareTo(LocalDate.now()) <= 0) {
					chiffreAffaire = chiffreAffaire + priceT[i];
				}
				temp++;
			}
		}
		System.out.println("  __" + "\n");
		System.out.println(" | " + "Le chiffre d'affaire jusqu'à aujourd'hui est de " + chiffreAffaire + " €");
		System.out.println("  __");
	}

	public void firstFreeRoom() {
		for (int i = 0; i < rooms.length; i++) {
			if (dispo[i] == true) {
				int j = i + 1;
				System.out.println("  __" + "\n");
				System.out.println(" | " + "Chambre " + j + " Libre !");
				System.out.println("  __");
				break;
			}
		}
	}

	public void lastFreeRoom() {
		for (int i = rooms.length - 1; i >= 0; i--) {
			if (dispo[i] == true) {
				int j = i + 1;
				System.out.println("  __" + "\n");
				System.out.println(" | " + "Chambre " + j + " Libre");
				System.out.println("  __");
				break;
			}
		}
	}

	public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
		long startEpochDay = startInclusive.toEpochDay();
		long endEpochDay = endExclusive.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

		return LocalDate.ofEpochDay(randomDay);
	}
}