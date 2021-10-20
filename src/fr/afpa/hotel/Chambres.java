package fr.afpa.hotel;

public class Chambres {
	private int id;
	private String view;
	private String superficy;
	private int price;
	private static String type;
	private String options;
	private String occupation;
	private int nbRooms;
	private String nomClt;

	String typeT[] = { "Chambre Vue Piscine", "Chambre Vue Jardin", "Chambre Vue Oc�an",
			"Chambre vue imprenable sur l'oc�an", "Suite CDA", "Suite Executive", "Suite Ambassadeur", "Suite Royale" };
	String superficyT[] = { "44 m�tres carr�s", "44 m�tres carr�s", "44 m�tres carr�s", "44 m�tres carr�s",
			"82 m�tres carr�s", "140 m�tres carr�s", "230 m�tres carr�s", "342 m�tres carr�s" };
	String viewT[] = { "Piscine Centrale", "Jardin, For�t ou Golf", "Partielle Oc�an et For�t ou Golf", "Oc�an",
			"Oc�an et Golf", "Oc�an", "Oc�an", "Oc�an" };
	String occupationT[] = { "2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans",
			"2 adultes et 2 enfants de moins de 12 ans", "2 adultes et 2 enfants de moins de 12 ans" };
	int priceT[] = { 300, 314, 350, 350, 450, 550, 1650, 2400 };
	int nbRoomsT[] = { 7, 12, 8, 10, 12, 5, 7, 4 };
	String optionsT[] = {
			"Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
			"Fer et planche � repasser sur demande|T�l�phone |T�l�vision par c�ble|Climatisation|Bouilloire �lectrique|Concierge 24h/24",
			"Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"Fer et planche � repasser sur demande|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24",
			"S�che-cheveux|Coffre-fort dans la chambre|Minibar|T�l�phone |Acc�s Internet haut d�bit sans fil|Lecteur DVD sur demande|T�l�vision par c�ble|Climatisation|Service aux chambres 24h/24|Concierge 24h/24" };

	public Chambres(int unId, String unType, String uneSuperficy, String unView, String uneOcuppation, int unPrice,
			int leNbRooms, String desOptions, String unNomClt) {
		id = unId;
		view = unView;
		superficy = uneSuperficy;
		price = unPrice;
		type = unType;
		options = desOptions;
		occupation = uneOcuppation;
		nbRooms = leNbRooms;
		nomClt = unNomClt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbRooms() {
		return nbRooms;
	}

	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSuperficy() {
		return superficy;
	}

	public void setSuperficy(String superficy) {
		this.superficy = superficy;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static String getType() {
		return type;
	}

	@SuppressWarnings("static-access")
	public void setType(String type) {
		this.type = type;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getNomClt() {
		return nomClt;
	}

	public void setNomClt(String nomClt) {
		this.nomClt = nomClt;
	}
}
