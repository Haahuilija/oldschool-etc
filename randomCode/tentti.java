package testaus;

import java.util.Scanner;


public class tentti {
		
	static void tulostaOtsikko(){
		
		System.out.println("KIRJAUTUMINEN" + "\n");
		
	}

	static void tarkistaKirjautuminen(String kayttajatunnus, String salasana) {
		
		String oikeaKtunnus = "kirsikka";
		String oikeaSalasana = "punainen";
		Scanner lukija = new Scanner(System.in);
		
		if(oikeaKtunnus.contentEquals(kayttajatunnus) && oikeaSalasana.contentEquals(salasana)) {
			
			System.out.println("Kirjautuminen onnistui" + "\n");
			
		}else{
			
			System.out.println("Kirjautuminen ep�onnistui" + "\n");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		String kayttajatunnus, salasana;
		int arvaustenMaara = 0;
		
		tulostaOtsikko();
		
		Scanner lukija = new Scanner(System.in);
		
		
		do {
		
		System.out.println("Sy�t� k�ytt�j�tunnus");
		kayttajatunnus = lukija.nextLine();
		System.out.println("Sy�t� salasana");
		salasana = lukija.nextLine();
		
		tarkistaKirjautuminen(kayttajatunnus, salasana);
		
		arvaustenMaara++;
		
		System.out.println("Arvausten m��r�: " + arvaustenMaara + "\n");
		
		}while(arvaustenMaara < 3);
		
		
	}
	
}
