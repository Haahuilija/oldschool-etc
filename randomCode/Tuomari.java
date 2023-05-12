
public class Tuomari {
	
	private int id;
	private String nimi;
	private String maa;
	

	public Tuomari(int id, String nimi, String maa) {
		this.id=567;
		this.nimi="Lasse Ottesen";
		this.maa="Norja";
		
	}
	
	public Tuomari() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getMaa() {
		return maa;
	}
	public void setMaa(String maa) {
		this.maa = maa;
	}
}
