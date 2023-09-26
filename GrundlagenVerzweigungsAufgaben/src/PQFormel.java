import java.util.Scanner;
public class PQFormel {

	public static void main(String[] args) {
		double p;
		double q;
		double wurzelterm;
		double preTerm;
		double x1, x2;
		Scanner input = new Scanner(System.in);
		
		//p und q angeben
		System.out.print("p ist: ");
		p = input.nextInt();
		
		System.out.print("q ist: ");
		q = input.nextInt();
		
		//Berechne Term in der Wurzel
		wurzelterm = Math.pow((p/(double)2),2)-q;
		
		//Ist Wurzelterm negativ ?
		if(wurzelterm < 0) {
			System.out.println("Es gibt keine Nullstelle.");
		} else if(wurzelterm == 0) {
			//p berechnen
			preTerm = -(p/2);
			System.out.println("Die Nullstelle liegt bei x1 = " + preTerm);
		} else {
			//p berechnen
			preTerm = -(p/2);
			//Nullstellen berechnen
			x1 = preTerm + Math.sqrt(wurzelterm);
			x2 = preTerm - Math.sqrt(wurzelterm);
			System.out.println("Die Nullstellen liegen bei x1 = " + x1 + " und x2 = " + x2 + " .");
		}

	}

}
