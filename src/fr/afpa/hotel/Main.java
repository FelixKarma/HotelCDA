package fr.afpa.hotel;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String args[]) throws FileNotFoundException, DocumentException {

		Scanner scanner = new Scanner(System.in);
		Hotel hotel = new Hotel();
		Clients client = new Clients();
		Reservation reservation = new Reservation();

		boolean stop = false;
		boolean connexionClt = false;
		boolean connexionEmp = false;
		boolean coClient = false;

		hotel.listRooms();

//		System.out.println("Etes vous client(1) ou employé(2) ? ");
//		String grade = scanner.next();
//		if (grade.equalsIgnoreCase("1")) {
//			coClient = Clients.connexionClt(connexionClt);
//		} else if (grade.equalsIgnoreCase("2")) {
//			coClient = Clients.connexionClt(connexionEmp);
//		}

//		if (coClient /* || employe */) {
		do {
			System.out.println("  _____________________________________" + "\n");
			System.out.println("  | " + "A- Afficher l’état de l’hôtel");
			System.out.println("  | " + "B- Afficher le nombre de chambres réservées");
			System.out.println("  | " + "C- Afficher le nombre de chambres libres");
			System.out.println("  | " + "D- Afficher le numéro de la première chambre vide");
			System.out.println("  | " + "E- Afficher le numéro de la dernière chambre vide");
			System.out.println("  | " + "F- Réserver une chambre (Le programme doit réserver la première chambre vide");
			System.out.println("  | " + "G- Libérer une chambre (Le programme doit libérer la dernière chambre occupée)");
			System.out.println("  | " + "H- Modifier une réservation");
			System.out.println("  | " + "I- Annuler une réservation");
			System.out.println("  | " + "J- Chiffre d'affaire");
			System.out.println("  | " + "Q- Quitter ");
			System.out.println("  ______________________________________");

			String str = scanner.next().toUpperCase();
			char rep = str.charAt(0);
			System.out.println("Votre choix : " + rep);

			switch (rep) {
			case 'A':
				hotel.affichage();
				break;
			case 'B':
				hotel.reservedRooms();
				break;
			case 'C':
				hotel.freeRoomsWithInfo();
				Hotel.freeRooms();
				break;
			case 'D':
				hotel.firstFreeRoom();
				break;
			case 'E':
				hotel.lastFreeRoom();
				break;
			case 'F':
				reservation.reserver();
				break;
			case 'G':
				reservation.liberer();
				break;
			case 'H':
				reservation.modifierReservation();
				break;
			case 'I':
				reservation.AnnulerReservation();
				break;
			case 'J':
				hotel.pricePerDate();
				break;
			case 'Q':
				System.out.println("Bye !");
				stop = true;
				break;
			default:
				System.out.println("Choix incorrect !");
				break;
			}
		} while (!stop);
	}

}
