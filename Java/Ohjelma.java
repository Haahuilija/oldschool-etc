        // importataan scanneri sek‰ array lista
import java.util.Scanner;
import java.util.ArrayList;

public class Ohjelma {
        
        // luodaan metodi joka tulostaa yksinkertaisen logon
    static void logoMetodi() {
        System.out.println("*******************");
        System.out.println("* Pauline's Pizza *");
        System.out.println("*******************" + "\n");
    }    

public static void main(String[] args) {
        // tuodaan ja nimet‰‰n scanneri mainissa
    Scanner lukija = new Scanner(System.in);
        // m‰‰ritell‰‰n pizza muuttuja stringiksi, ei tarvitse myˆhemmin erikseen
    String pizza;
        // omat muuttujat pizzan tietojen korjausta varten
    int myynninNro;
    String muutos;
        // m‰‰ritell‰‰n indeksi muuttuja jota k‰tet‰‰n listan tulostuksen yhteydess‰
        // saadaan numerot listan sis‰ll‰ olevien kohteiden eteen
        // indeksi alkaisi muuten luvusta 0 joten asetetaan sille suoraan arvo 1
    int indeksi = 1;
        // m‰‰ritell‰‰n array listan nimi
    ArrayList<String> myydytPizzat = new ArrayList<String>();
        
        // kutsutaan metodia mainissa
    logoMetodi();
       
        // aloitetaan do/while looppi jonka aikana voidaan syˆtt‰‰ listaan tietoa      
    do{
    
            // pyydet‰‰n syˆtt‰m‰‰n pizzan nimi ja otetaan scanneria k‰ytt‰en muuttujaan talteen
    System.out.println("1 Vege - 2 Salami - 3 Mozzarella - poistu: e");
        pizza = lukija.nextLine();
            // if lauseella k‰ytt‰j‰ voi vied‰ pizzan nimen listaan pelk‰st‰‰n nro k‰ytt‰en
            // jos k‰ytt‰j‰ kirjoittaa "e" niin sit‰ ei vied‰ listaan
        if(pizza.contentEquals("1")){
            myydytPizzat.add("Vege");
        }else if(pizza.contentEquals("2")){
            myydytPizzat.add("Salami");
        }else if(pizza.contentEquals("3")){ 
            myydytPizzat.add("Mozzarella");
        }else if(pizza.contentEquals("e")){
                // break komennolla hyp‰t‰‰n ulos loopista
            break;
        }else{
            System.out.println("1 Vege - 2 Salami - 3 Mozzarella - poistu: e");
        }
        // loop pyˆrii niin kauan kunnes k‰ytt‰j‰ kirjoittaa "e"
    }while (!pizza.contentEquals("e"));

        // for loopilla tuodaan lista arrayListiin viedyist‰
        // indeksin avulla j‰rjestysnumero
    System.out.println("\n" + "Myydyt pizzat" + "\n");
        for(String s : myydytPizzat){    
    System.out.println((indeksi++)+". "+s);
    }
        // printataan monta pizzaa myytiin k‰ytt‰en indeksi‰, t‰m‰ laskee "e" mukaan 
        // joten se saadaan pois k‰ytt‰en (indeksi - 1)
    System.out.println("\n" + "Pizzoja myytiin: " + (indeksi - 1));
    
        // pyydet‰‰n numeroa joka listassa korjataan, int scannerilla talteen omaan muuttujaan
    System.out.println("\n" + "Kirjoita myynnin numero, mink‰ tiedon haluat muuttaa.");
        myynninNro = Integer.parseInt(lukija.nextLine());
        // pyydet‰‰n nimi joka listassa korjataan, scannerilla talteen omaan muuttujaan
    System.out.println("Kirjoita pizza");
        muutos = lukija.nextLine();
        
        // array nimi.set korjataan listassa oleva kohta
        // suluissa ensin listan j‰rjestys nro, koska array indeksi alkaa normaalisti kohdasta 0
        // ja t‰ss‰ on (katso rivit 22-25) korjattu indeksi 1. alkavaksi
        // nyt joudutaan poistamaan 1
        // "muutos" muuttuja asettaa mik‰ uusi nimi kyseisen indeksin kohdalle tulee
    myydytPizzat.set(myynninNro-1, muutos);   
        
        // tuodaan array lista uudestaan esille muutoksen j‰lkeen
        // "\n" tuodaan hieman v‰lej‰ tekstille niin ohjelmaa on mukavempi lukea :)
    System.out.println("\n");
        for(String s : myydytPizzat){    
    System.out.println((indeksi++)+". "+s);
    }
}