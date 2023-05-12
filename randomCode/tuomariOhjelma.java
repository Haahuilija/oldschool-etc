
public class tuomariOhjelma {

	public static void main(String[] args) {
		Tuomari tuomari=new Tuomari(340, "Kalle Palander", "Suomi");
		Tuomari tuomari2=new Tuomari();

	tulosta(tuomari);
	tulosta(tuomari2);
	}
	
	private static void tulosta (Tuomari tuomari) {
		
		System.out.println("ID: " + tuomari.getId());
		System.out.println("Nimi: " + tuomari.getNimi());
		System.out.println("Maa: " + tuomari.getMaa());
		
	}
}
