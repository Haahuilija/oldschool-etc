package testaus;

public class array {

	public static void main(String[] args) {

		String[] huonekalutArray = {"Sohva","Senkki","Nojatuoli","P�yt�"};

		    //tulostaa vain kaksi ensimm�ist� indeksi�

		for (int i=0; i < huonekalutArray.length; i++)
		    {
		System.out.println(huonekalutArray[i]);

		    }

		for (int i=0; i< huonekalutArray.length; i++)
		    {
		if (huonekalutArray[i].equals("Sohva"))
		    {
		    System.out.println("sohva l�ytyi");
		}
		else
		    {
		    System.out.println("ei l�ytynyt sohvaa");
		}
		}

	}
	
}
