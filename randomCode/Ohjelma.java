package projekti;



	public class Ohjelma {

		private int nopeus;
		public int getNopeus() {
			return nopeus;
		}
		
		public void muutaNopeus(int muutos) {
			
			nopeus = getNopeus();
			
			if (nopeus < 0) {
				
				nopeus = nopeus - muutos;
				if(nopeus < 0) {
					System.out.println("Nopeus ei voi alittaa 0");
					nopeus = 0;
				}
				
			}else if(nopeus > 0){
				nopeus = nopeus + muutos;
				if(nopeus > 45) {
					System.out.println("Ei voi kulkea 45 kovempaa");
					nopeus = 45;
				}
			}
			
		}
		

}