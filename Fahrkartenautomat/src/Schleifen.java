
public class Schleifen {

	public static void main(String[] args) {
		
		//for schleife
		for(int i=10; i<=20; i=i+1) {
		      System.out.printf("%d ", i*i);
		}
		
		System.out.println("\n");
		
		//while schleife
		int i = 10;
		while(i <= 20) {
			if (i == 11) {
				i = i+1; 
				continue;
			}
			if (i == 18) {
				break;
			}
		    System.out.printf("%d ", i*i);
		    i = i+1;
		}
	}

}
