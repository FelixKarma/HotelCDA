package fr.afpa.hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Reservation {

	int id;
	Scanner in = new Scanner(System.in);
	Chambres chambre = new Chambres(id, null, null, null, null, id, id, null, null);
	Clients client = new Clients();
	float argent = 0;
	float days = 0;
	String lastNameClt = "";
	String firstNameClt = "";
	String affichageViewT;
	String affichageTypeT;
	String affichageDebutDate;
	String affichageFinDate;
	String affichageOptionsT;
	String fin;
	String debut;

	public void reserver() throws DocumentException, AddressException, MessagingException, IOException {

		boolean stop = false;
		Scanner in = new Scanner(System.in);
		Hotel.freeRooms();
		int rl = 0;
		int roomForPrice = 0;
		do {
			System.out.println("  __" + "\n");
			for (int i = 0; i < chambre.typeT.length; i++) {
				char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
				System.out.println(" | " + alphabet[i] + " : " + chambre.typeT[i] + " - " + chambre.superficyT[i]);
			}
			System.out.println("  __");
			System.out.println("  __" + "\n");
			System.out.println(" | " + "Selectionnez un type de chambre !");
			System.out.println("  __");
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
				System.out.println("  __" + "\n");
				System.out.println(" | " + chambre.typeT[0] + " - " + chambre.superficyT[0]);
				System.out.println(" | " + "Vur sur : " + chambre.viewT[0]);
				System.out.println(" | " + "Prix : " + chambre.optionsT[0]);
				System.out.println(" | " + "Prix : " + chambre.priceT[0] + " €");
				System.out.println(" | " + "Disponible : " + rlt0); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 0;
				break;
			case 'B':
				for (int i = chambre.nbRoomsT[0]; i < chambre.nbRoomsT[1] + chambre.nbRoomsT[0]; i++) {
					if (Hotel.dispo[i] == true) {
						rl++;
					}
				}
				int rlt1 = chambre.nbRoomsT[1] + 1 - rl; // a revoir
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[1] + " - " + chambre.superficyT[1]);
				System.out.println("Vur sur : " + chambre.viewT[1]);
				System.out.println("Prix : " + chambre.optionsT[1]);
				System.out.println("Prix : " + chambre.priceT[1] + " €");
				System.out.println("Disponible : " + rlt1); // ajouter une soustraction des chambres deja
															// reserver
				System.out.println("  __");
				roomForPrice = 1;
				break;
			case 'C':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[2] + " - " + chambre.superficyT[2]);
				System.out.println("Vur sur : " + chambre.viewT[2]);
				System.out.println("Prix : " + chambre.optionsT[2]);
				System.out.println("Prix : " + chambre.priceT[2] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[2]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 2;
				break;
			case 'D':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[3] + " - " + chambre.superficyT[3]);
				System.out.println("Vur sur : " + chambre.viewT[3]);
				System.out.println("Prix : " + chambre.optionsT[3]);
				System.out.println("Prix : " + chambre.priceT[3] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[3]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 3;
			case 'E':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[2] + " - " + chambre.superficyT[4]);
				System.out.println("Vur sur : " + chambre.viewT[4]);
				System.out.println("Prix : " + chambre.optionsT[4]);
				System.out.println("Prix : " + chambre.priceT[4] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[4]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 2;
				break;
			case 'F':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[5] + " - " + chambre.superficyT[5]);
				System.out.println("Vur sur : " + chambre.viewT[5]);
				System.out.println("Prix : " + chambre.optionsT[5]);
				System.out.println("Prix : " + chambre.priceT[5] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[5]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 2;
				break;
			case 'G':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[6] + " - " + chambre.superficyT[6]);
				System.out.println("Vur sur : " + chambre.viewT[6]);
				System.out.println("Prix : " + chambre.optionsT[6]);
				System.out.println("Prix : " + chambre.priceT[6] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[6]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 2;
				break;
			case 'H':
				System.out.println("  __" + "\n");
				System.out.println(chambre.typeT[7] + " - " + chambre.superficyT[7]);
				System.out.println("Vur sur : " + chambre.viewT[7]);
				System.out.println("Prix : " + chambre.optionsT[7]);
				System.out.println("Prix : " + chambre.priceT[7] + " €");
				System.out.println("Disponible : " + chambre.nbRoomsT[7]); // ajouter une soustraction des chambres deja
				// reserver
				System.out.println("  __");
				roomForPrice = 2;
				break;
			default:
				break;
			}
		} while (stop);

		String repTab[] = { "Oui", "Non" };
		System.out.println("  __" + "\n");
		System.out.println(" | " + "Selectionez cette chambre Oui/Non ! ");
		System.out.println("  __");
		String rep = in.next();
		float days = 0;

		boolean nomCorrect = false;

		// demander la date
		for (int j = 0; j < 2; j++) {
			if (rep.equalsIgnoreCase(repTab[j])) {
				System.out.println("Entrez vos date de reservation ! ");
				do {
					System.out.println("Date de debut");
					System.out.print("Jour ? ");
					String jourDebut = in.next();
					System.out.print("Mois ? ");
					String moisDebut = in.next();
					System.out.print("Année ? ");
					String anneeDebut = in.next();
					debut = "" + anneeDebut + "-" + moisDebut + "-" + jourDebut;
					System.out.println("Date de fin");
					System.out.print("Jour ? ");
					String jourFin = in.next();
					System.out.print("Mois ? ");
					String moisFin = in.next();
					System.out.print("Année ? ");
					String anneeFin = in.next();
					fin = "" + anneeFin + "-" + moisFin + "-" + jourFin;
					days = dateReserve(debut, fin);
					affichageDebutDate = "" + jourDebut + "/" + moisDebut + "/" + anneeDebut;
					affichageFinDate = "" + jourFin + "/" + moisFin + "/" + anneeFin;

					if (days > 30) {
						System.out.println("Vous ne pouvez réserver la chambre qu'un seul mois");
					}
				} while (days > 30);

				System.out.print("Entrez votre nom : ");
				String name = in.next();
				for (int i = 0; i < 3; i++) {
					if (name.equalsIgnoreCase(client.nomClient[i])) {
						System.out.println("Chambre validée !");
						lastNameClt = client.nomClient[i];
						firstNameClt = client.prenomClient[i];
						nomCorrect = true;
						break;
					}
					if (i == 2 && !name.equalsIgnoreCase(client.nomClient[i])) {
						System.out.println("Nom incorrect");
					}
				}
				if (nomCorrect) {
					argent = (days + 1) * chambre.priceT[roomForPrice];
					System.out.println("Le prix de votre réservation est de : " + argent + " €");
					System.out.print("Veuillez entrez votre numero de carte : ");
					String carte = in.next();

					for (int i = 0; i < client.cbClient.length; i++) {
						if (carte.equals(client.cbClient[i])) {
							System.out.println("  __" + "\n");
							System.out.println(" | " + "Payement validé !");
							System.out.println(" | " + "Chambre réservée !");
							System.out.println("  __");

							for (int k = 0; k < Hotel.dispo.length; k++) {
								if (Hotel.dispo[k] == true) {
									Hotel.dispo[k] = false;
									LocalDate dateDebut = LocalDate.parse(debut);
									LocalDate dateFin = LocalDate.parse(fin);
									Hotel.StartDate[k] = dateDebut;
									Hotel.EndDate[k] = dateFin;
									Hotel.rooms[k] = new Chambres(k, chambre.typeT[roomForPrice],
											chambre.superficyT[roomForPrice], chambre.viewT[roomForPrice],
											chambre.occupationT[roomForPrice], chambre.priceT[roomForPrice],
											chambre.nbRoomsT[roomForPrice], chambre.optionsT[roomForPrice],
											client.nomClient[i]);
									affichageTypeT = chambre.typeT[roomForPrice];
									affichageViewT = chambre.viewT[roomForPrice];
									affichageOptionsT = chambre.optionsT[roomForPrice];
									System.out.println("  __" + "\n");
									System.out.println(" | " + "Votre chambre sera la numéro " + (k + 1) + " ! "); // debute
																													// à
																													// 0
									System.out.println("  __");
									break;
								}
							}
							pdf();
							mail();
							break;
						}
						if (i == client.cbClient.length - 1 && !carte.equals(client.cbClient[i])) {
							System.out.println("  __" + "\n");
							System.out.println(" | " + "Payement refusé !");
							System.out.println(" | " + "Chambre annulée !");
							System.out.println("  __");
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

	public void mail() throws AddressException, MessagingException, IOException {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kev.callet@gmail.com", "Fm2xp3W^rs");
			}
		});

		Message message = new MimeMessage(session);
		Address addressTo = new InternetAddress("kev.callet@gmail.com");
		message.setRecipient(Message.RecipientType.TO, addressTo);
		message.setSubject("HotelCDA - Chambre réservée");

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("Bonjour,\n\n"
				+ "Veuillez retrouver votre résumé de votre chambre réservée chez nous.\n\n" + "Cordialement");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		MimeBodyPart attachmentPart = new MimeBodyPart();

		attachmentPart.attachFile(new File("D:\\DEV\\Java\\Projets Eclipse\\HotelCDA\\facture.pdf"));

		multipart.addBodyPart(attachmentPart);

		message.setContent(multipart);

		Transport.send(message);
	}

	public void pdf() throws FileNotFoundException, DocumentException {

		Document document = new Document();
		PdfWriter.getInstance(document,
//				new FileOutputStream("D:\\Cours\\Java\\Projets Eclipse\\HotelCDA\\facture.pdf"));
				new FileOutputStream("D:\\DEV\\Java\\Projets Eclipse\\HotelCDA\\facture.pdf"));

		Paragraph title = new Paragraph(
				(new Chunk("HOTEL CDA" + " \n ", FontFactory.getFont(FontFactory.COURIER_BOLD, 20))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapNp = new Paragraph((new Chunk("Nom Prenom : " + lastNameClt + " " + firstNameClt,
				FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapType = new Paragraph(
				(new Chunk("Type : " + affichageTypeT, FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapView = new Paragraph(
				(new Chunk("Vue : " + affichageViewT, FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapOptions = new Paragraph(
				(new Chunk("Options : " + affichageOptionsT, FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapPrix = new Paragraph(
				(new Chunk("Prix : " + argent + " €", FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapDateDebut = new Paragraph((new Chunk("Date de debut : " + affichageDebutDate,
				FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		Paragraph recapDateFin = new Paragraph(
				(new Chunk("Date de fin : " + affichageFinDate, FontFactory.getFont(FontFactory.COURIER_BOLD, 15))));
		title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

		document.open();
		document.add(title);
		document.add(recapNp);
		document.add(recapView);
		document.add(recapOptions);
		document.add(recapOptions);
		document.add(recapDateDebut);
		document.add(recapDateFin);
		document.add(recapPrix);
		document.close();
	}

	public void modifierReservation() {

		System.out.println("Voulez-vous annuler une chambre ? (oui ou non)");
		String repoUInO = in.next();

		if (repoUInO.equalsIgnoreCase("oui")) {
			System.out.println("Entrez votre numero de chambre : ");
			int repNbChambre = in.nextInt();

			if (Hotel.dispo[repNbChambre - 1] == false) {
				do {
					System.out.println("Date de debut");
					System.out.print("Jour ? ");
					String jourDebut = in.next();
					System.out.print("Mois ? ");
					String moisDebut = in.next();
					System.out.print("Année ? ");
					String anneeDebut = in.next();
					debut = "" + anneeDebut + "-" + moisDebut + "-" + jourDebut;
					System.out.println("Date de fin");
					System.out.print("Jour ? ");
					String jourFin = in.next();
					System.out.print("Mois ? ");
					String moisFin = in.next();
					System.out.print("Année ? ");
					String anneeFin = in.next();
					fin = "" + anneeFin + "-" + moisFin + "-" + jourFin;
					days = dateReserve(debut, fin);

					if (days > 30) {
						System.out.println("Vous ne pouvez réserver la chambre qu'un seul mois");
					}
				} while (days > 30);

				LocalDate dateDebut = LocalDate.parse(debut);
				LocalDate dateFin = LocalDate.parse(fin);
				Hotel.StartDate[repNbChambre - 1] = dateDebut;
				Hotel.EndDate[repNbChambre - 1] = dateFin;

				System.out.println("Chambre " + repNbChambre + " modifier !");
			} else {
				System.out.println("La chambre est déjà libre !");
			}

		} else {
			System.out.println("Bye !");
		}
	}

	public void AnnulerReservation() {

		System.out.println("Voulez-vous annuler une chambre ? (oui ou non)");
		String repoUInO = in.next();

		if (repoUInO.equalsIgnoreCase("oui")) {

			System.out.println("Entrez votre numero de chambre : ");
			int repNbChambre = in.nextInt();

			if (Hotel.dispo[repNbChambre - 1] == false) {
				for (int i = 0; i < Hotel.rooms.length; i++) {
					if (i == repNbChambre - 1) {
						Hotel.dispo[i] = true;
						Hotel.rooms[i] = new Chambres(id, null, null, null, null, id, id, null, null);
						System.out.println("Chambre libérée. A bientot !");
					}
				}
			} else {
				System.out.println("La chambre est déjà libre !");
			}
		} else {
			System.out.println("Bye !");
		}
	}

	public void liberer() {
		System.out.println("Voulez-vous liberer votre chambre ? (oui ou non)");
		Scanner in = new Scanner(System.in);
		String liberty = in.next();
		boolean clientFlag = false;
		boolean roomFlag = false;
		String nomClient = null;

		if (liberty.equalsIgnoreCase("Oui")) {
			System.out.println("Entrez votre numero de chambre : ");
			int repNbChambre = in.nextInt();
			for (int i = 0; i < Hotel.rooms.length; i++) {
				if (repNbChambre - 1 == (Hotel.rooms[i].getId())) {
					roomFlag = true;
					nomClient = Hotel.rooms[i].getNomClt();
				}
			}

			System.out.println("Entrez votre nom : ");
			String reponse = in.next();
			for (int i = 0; i < client.nomClient.length; i++) {
				if (reponse.equalsIgnoreCase(nomClient)) {
					clientFlag = true;
				}
			}

			if (clientFlag && roomFlag) {
				for (int i = 0; i < Hotel.rooms.length; i++) {
					if (i == repNbChambre - 1) {
						Hotel.dispo[i] = true;
						Hotel.rooms[i] = new Chambres(id, null, null, null, null, id, id, null, null);
						System.out.println("Chambre libérée. A bientot !");
					}
				}
			}
		}
	}

	public static float dateReserve(String debut, String fin) {
		float res = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateAvant = sdf.parse(debut);
			Date dateApres = sdf.parse(fin);
			long diff = dateApres.getTime() - dateAvant.getTime();
			res = (diff / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
