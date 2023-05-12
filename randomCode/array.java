package testaus;

public class array {

	public static void main(String[] args) {

		String[] huonekalutArray = {"Sohva","Senkki","Nojatuoli","Pöytä"};

		    //tulostaa vain kaksi ensimmäistä indeksiä

		for (int i=0; i < huonekalutArray.length; i++)
		    {
		System.out.println(huonekalutArray[i]);

		    }

		for (int i=0; i< huonekalutArray.length; i++)
		    {
		if (huonekalutArray[i].equals("Sohva"))
		    {
		    System.out.println("sohva löytyi");
		}
		else
		    {
		    System.out.println("ei löytynyt sohvaa");
		}
		}

	}
	
}
