import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		int k = 0;
		int ziffer;
		Scanner input = new Scanner(System.in);
		
		//Zifferneingabe
		do
		{
			System.out.println("Gebe eine Ziffer zwischen 2 und 9 ein");
			ziffer = input.nextInt();
		}
		while(ziffer < 2 || ziffer > 9);
			
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				//Zahl enthaelt Ziffer
				if(String.valueOf(k).contains(String.valueOf(ziffer))) {
					System.out.print("* ");
					k++;
					continue;
				}
				//Zahl ist durch ziffer teilbar
				if(k % ziffer == 0) {
					System.out.print("* ");
					k++;
					continue;
				}
				//Quersumme ist Ziffer
				if(k % 10 + (k/10) % 10 == ziffer) {
					System.out.print("* ");
					k++;
					continue;
				}
				System.out.print(k + " ");
				k++;
			}
			System.out.println("\n");
		}

	}

}
