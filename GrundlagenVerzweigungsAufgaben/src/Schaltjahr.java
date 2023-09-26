import java.util.Scanner;

public class Schaltjahr {

	public static void main(String[] args) {
		
		boolean schaltjahr;
		
		//Jahr Abfrage
		System.out.print("Jahr: ");
		Scanner input = new Scanner(System.in);
		int jahr = input.nextInt();
		
		//Abfragen, ob Jahr durch 4 teilbar
		if(jahr%4 < 0 || jahr%4 > 0) {
			schaltjahr = true;
		} else {
			//Abfrage, ob Jahr durch 100 teilbar
			if(jahr%100 == 0) {
				//Abfrage, ob Jahr durch 400 teilbar
				if(jahr%400 == 0) {
					schaltjahr = true;
				} else {
					schaltjahr = false;
				}
			} else {
				schaltjahr = true;
			}
		}
		
		//Ausgabe Schaltjahrstatus
		System.out.println(schaltjahr);

	}

}
