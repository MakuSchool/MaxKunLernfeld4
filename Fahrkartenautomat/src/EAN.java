public class EAN {

	public static void main(String[] args) {
		long ean = 4780201379636L;
		int[] array = nummerInArray(ean);
		System.out.println(ean + " ist gültig: " + istGueltigeEAN(array));
		ean = 2222222222221L;
		array = nummerInArray(ean);
		System.out.println(ean + " ist gültig: " + istGueltigeEAN(array));
		ean = 1234567890128L;
		array = nummerInArray(ean);
		System.out.println(ean + " ist gültig: " + istGueltigeEAN(array));
		ean = 9807522453694L;
		array = nummerInArray(ean);
		System.out.println(ean + " ist gültig: " + istGueltigeEAN(array));
		ean = 7539518524561L;
		array = nummerInArray(ean);
		System.out.println(ean + " ist gültig: " + istGueltigeEAN(array));
		
	}
	
	public static int[] nummerInArray(long zahl) {
		int[] digits = new int[13];

        for (int i = 12; i >= 0; i--) {
            digits[i] = (int) (zahl % 10);
            zahl /= 10;
        }

        return digits;
	}
	
	public static boolean istGueltigeEAN(int[] array) {
		
		int sum = 0;
        for (int i = 0; i < 12; i++) {
        	if((i + 1) % 2 == 0) {
        		sum += array[i] * 3;
        	} else {
        		sum += array[i];
        	}  
        }
        
        int rest = sum % 10;
        int ergebnis = 10 - rest;
        
        if(ergebnis==array[12]) {
        	return true;
        }
        return false;   
	}

}
