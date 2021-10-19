package fr.afpa.hotel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Reservation {

	int id;

	Chambres chambre = new Chambres(id, null, null, null, null, id, id, null, null);
	Clients client = new Clients();

	public void reserver() {

		boolean stop = false;
		Scanner in = new Scanner(System.in);
		Hotel.freeRooms();
		int rl = 0;
		int roomForPrice = 0;
		do {

			for (int i = 0; i < chambre.typeT.length; i++) {
				System.out.println(chambre.typeT[i] + " - " + chambre.superficyT[i]);
			}
			System.out.println("-----------");
			System.out.println("Selectionnez un type de chambre. ");
			String str = in.next().toUpperCase();
			char rep = str.charAt(0);
			System.out.println("Votre choix : " + rep);

			switch (rep) {
			case 'A':
				for (int i = 0; i < chambre.nbRoomsT[0]; i++) {
					if (Hotel.dispo[i] == true) {
						rl++;
					}

				}
				int rlt0 = chambre.nbRoomsT[0] + 1 - rl;
				System.out.println("-----------");
				System.out.println(chambre.typeT[0] + " - " + chambre.superficyT[0]);
				System.out.println("Vur sur : " + chambre.viewT[0]);
				System.out.println("Prix : " + chambre.optionsT[0]);
				System.out.println("Prix : " + chambre.priceT[0] + " euroTTC");
				System.out.println("Disponible : " + rlt0); // ajouter une soustraction des chambres deja
															// reserver
				System.out.println("-----------");
				roomForPrice = 0;
				break;
			case 'B':
				for (int i = chambre.nbRoomsT[0]; i < chambre.nbRoomsT[1] + chambre.nbRoomsT[0]; i++) {
					if (Hotel.dispo[i] == true) {
						rl++;
					}

				}
				int rlt1 = chambre.nbRoomsT[1] + 1 - rl; // a revoir
				System.out.println("-----------");
				System.out.println(chambre.typeT[1] + " - " + chambre.superficyT[1]);
				System.out.println("Vur sur : " + chambre.viewT[1]);
				System.out.println("Prix : " + chambre.optionsT[1]);
				System.out.println("Prix : " + chambre.priceT[1] + " euroTTC");
				System.out.println("Disponible : " + rlt1); // ajouter une soustraction des chambres deja
															// reserver
				System.out.println("-----------");
				roomForPrice = 1;
				break;
			case 'C':
				System.out.println("-----------");
				System.out.println(chambre.typeT[2] + " - " + chambre.superficyT[2]);
				System.out.println("Vur sur : " + chambre.viewT[2]);
				System.out.println("Prix : " + chambre.optionsT[2]);
				System.out.println("Prix : " + chambre.priceT[2] + " euroTTC");
				System.out.println("Disponible : " + chambre.nbRoomsT[2]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("-----------");
				roomForPrice = 2;
				break;
			case 'D':
				System.out.println("-----------");
				System.out.println(chambre.typeT[3] + " - " + chambre.superficyT[3]);
				System.out.println("Vur sur : " + chambre.viewT[3]);
				System.out.println("Prix : " + chambre.optionsT[3]);
				System.out.println("Prix : " + chambre.priceT[3] + " euroTTC");
				System.out.println("Disponible : " + chambre.nbRoomsT[3]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("-----------");
				roomForPrice = 3;
			default:
				break;
			}
		} while (stop);

		String repTab[] = { "Oui", "Non" };
		System.out.println("Selectionez cette chambre Oui/Non (mot) ");
		String rep = in.next();
		float days = 0;
		String fin;
		boolean nomCorrect = false;

		// demander la date
		for (int j = 0; j < 2; j++) {
			if (rep.equalsIgnoreCase(repTab[j])) {

				System.out.println("Jusqu'à quand ? ");
				do {
					System.out.print("Annee ? ");
					String annee = in.next();
					System.out.print("Mois ? ");
					String mois = in.next();
					System.out.print("Jour ? ");
					String jour = in.next();

					fin = "" + annee + "-" + mois + "-" + jour;
					days = dateReserve(fin);
					if (days > 30) {
						System.out.println("Vous ne pouvez réserver la chambre qu'un mois");
					}
				} while (days > 30);

				// demande d'argent
				System.out.print("Votre nom : ");
				String name = in.next();
				for (int i = 0; i < 3; i++) {
					if (name.equalsIgnoreCase(client.nomClient[i])) {
						System.out.println("Nom enregisté");
						nomCorrect = true;
						break;
					}
					if (i == 2 && !name.equalsIgnoreCase(client.nomClient[i])) {
						System.out.println("Nom incorrect");

					}
				}
				if (nomCorrect) {
					float argent = (days + 1) * chambre.priceT[roomForPrice];
					System.out.println("Le prix de votre réservation est de : " + argent);
					System.out.print("Veuillez donner votre numero de carte : ");
					String carte = in.next();

					for (int i = 0; i < client.cbClient.length; i++) {
						if (carte.equals(client.cbClient[i])) {
							System.out.println("Payement validé");
							System.out.println("Chambre réservée !");

							for (int k = 0; k < Hotel.dispo.length; k++) {
								if (Hotel.dispo[k] == true) {
									Hotel.dispo[k] = false;
									LocalDate dateFin = LocalDate.parse(fin);
									Hotel.StartDate[k] = LocalDate.now();
									Hotel.EndDate[k] = dateFin;
									Hotel.rooms[k] = new Chambres(k, chambre.typeT[roomForPrice],
											chambre.superficyT[roomForPrice], chambre.viewT[roomForPrice],
											chambre.occupationT[roomForPrice], chambre.priceT[roomForPrice],
											chambre.nbRoomsT[roomForPrice], chambre.optionsT[roomForPrice],
											client.nomClient[i]);
									System.out.println("Votre chambre sera la numéro " + k);
									break;
								}
							}

							break;
						}
						if (i == client.cbClient.length - 1 && !carte.equals(client.cbClient[i])) {
							System.out.println("Payement refusé");
							System.out.println("Chambre annulée !");
						}
					}
				}

				break;
			} else {
				System.out.println("Chambre annulée !");
				break;
			}
		}

	}

	public void liberer() {
		System.out.println("Voulez-vous liberer votre chambre ? (oui ou non)");
		Scanner in = new Scanner(System.in);
		String liberty = in.next();

		if (liberty.equalsIgnoreCase("Oui")) {
			System.out.println("Votre nom svp : ");
			String reponse = in.next();

			for (int i = 0; i < client.nomClient.length; i++) {
				if (reponse.equalsIgnoreCase(
						client.nomClient[i]) /* || reponse.equalsIgnoreCase((String)Hotel.rooms[i].getId()) */) {
				}
			}

			System.out.println("Votre numero de chambre svp : ");
			int repNbChambre = in.nextInt();
			for (int j = 0; j < Hotel.rooms.length; j++) {
				if (repNbChambre-1 == (Hotel.rooms[j].getId())) {
					System.out.println("Chambre libérée. A bientot");
				}
			}

		}
	}

	public static float dateReserve(String fin) {
		float res = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateAvant = new Date();
			Date dateApres = sdf.parse(fin);
			long diff = dateApres.getTime() - dateAvant.getTime();
			res = (diff / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
