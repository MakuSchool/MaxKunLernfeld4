import java.util.Scanner;

public class A624_Urlaub {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String land = "";
		while(land != "stop") {
			System.out.println("Gebe das Land an, stop wenn schluss");
			land = input.next();
			System.out.println(umrechnen(input, land));
		}
	}
	
	public static double umrechnen(Scanner input, String country) {
		System.out.println("Geben Sie die Reisekasse an");
		double gesamt = input.nextDouble();
		System.out.println("Geben Sie die Umrechmenge an");
		double menge = input.nextDouble();
		double umgerechnet;
		while(!genug(gesamt, menge)) {
			System.out.println("Reisekasse ist geringer als die Menge");
			menge = input.nextDouble();
		}
		country = country.toLowerCase();
		switch(country) {
			case "usa": umgerechnet = menge*0.98;
			break;
			case "japan": umgerechnet = menge*141;
			break;
			case "england": umgerechnet = menge*0.88;
			break;
			case "schweiz": umgerechnet = menge*0.96;
			break;
			case "daenemark": umgerechnet = menge*7.44;
			break;
			default: umgerechnet = menge;
		}
		
		return umgerechnet;
	}
	
	public static boolean genug(double gesamt, double menge) {
		if (gesamt < menge){
			return false;
		} 
		return true;
	}

}
