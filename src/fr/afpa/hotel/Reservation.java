package fr.afpa.hotel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Reservation {

	int id;

	Chambres chambre = new Chambres(null, null, null, null, id, id, null);
	
	public void reservation(int unId) {
		id = unId;
	}

	public void reserver() {

		boolean stop = false;
		Scanner in = new Scanner(System.in);
		Hotel.freeRooms();
		int rl=0;
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
				for(int i=0;i<chambre.nbRoomsT[0];i++) {
					if(Hotel.dispo[i]==true) {
						rl++;
					}
					
				}
				int rlt0=chambre.nbRoomsT[0]+1-rl;
				System.out.println("-----------");
				System.out.println(chambre.typeT[0] + " - " + chambre.superficyT[0]);
				System.out.println("Vur sur : " + chambre.viewT[0]);
				System.out.println("Prix : " + chambre.optionsT[0]);
				System.out.println("Prix : " + chambre.priceT[0] + " euroTTC");
				System.out.println("Disponible : " + rlt0); // ajouter une soustraction des chambres deja
																	// reserver
				System.out.println("-----------");
				break;
			case 'B':
				for(int i=chambre.nbRoomsT[0];i<chambre.nbRoomsT[1]+chambre.nbRoomsT[0];i++) {
					if(Hotel.dispo[i]==true) {
						rl++;
					}
					
				}
				int rlt1=chambre.nbRoomsT[1]+1-rl;   //a revoir 
				System.out.println("-----------");
				System.out.println(chambre.typeT[1] + " - " + chambre.superficyT[1]);
				System.out.println("Vur sur : " + chambre.viewT[1]);
				System.out.println("Prix : " + chambre.optionsT[1]);
				System.out.println("Prix : " + chambre.priceT[1] + " euroTTC");
				System.out.println("Disponible : " + rlt1); // ajouter une soustraction des chambres deja
																	// reserver
				System.out.println("-----------");
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
			default:
				break;
			}
		} while (stop);
				
		String repTab[]= {"Oui", "Non"};
		System.out.println("Selectionez cette chambre Oui/Non (mot) ");
		String rep = in.next();
		float days=0;

		String fin;
		
		//demander la date
		for (int j = 0; j < 2;j++) {
			if (rep.equalsIgnoreCase(repTab[j])) {
				
				System.out.println("Jusqu'à quand ? ");
				do {
					System.out.print("Annee ? "); int annee = in.nextInt();
					System.out.print("Mois ? "); int mois = in.nextInt();
					System.out.print("Jour ? "); int jour = in.nextInt();

					 fin = ""+jour+"/"+mois+"/"+annee;	
					 days = dateReserve(fin);
					if(days>30) {
						System.out.println("Vous ne pouvez réserver que la chambre qu'un mois");
					}
				}while(days>30);
				
		// demande d'argent
				
				
				
				
				
				
				
				System.out.println("Chambre reserver !");
				break;
			} else {
				System.out.println("Chambre annuler !");
				break;
			}
		}
		
			
		
				
			
			
		
	}
	

		  public static float dateReserve(String fin){
		     float res = 0;
		   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		     try {
		         Date dateAvant = sdf.parse("19/10/2021");
		         Date dateApres = sdf.parse(fin);
		         long diff = dateApres.getTime() - dateAvant.getTime();
		         res = (diff / (1000*60*60*24));
		     } catch (Exception e) {
		         e.printStackTrace();
		     }
			
			return res;
		   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
