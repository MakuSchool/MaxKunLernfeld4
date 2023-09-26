import java.util.Calendar;

public class ZeitabhaengigeBegruessung {

	public static void main(String[] args) {
		
		//Aktuelle Stunde erhalten
		Calendar kalender = Calendar.getInstance();
        int stunde = kalender.get(Calendar.HOUR_OF_DAY);
        
        //Begrüßungs Switch
        switch(stunde) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 22:
        case 23: System.out.println("Gute Nacht");
        		 break;
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10: System.out.println("Guten Morgen");
        		 break;
        case 18:
        case 19:
        case 20:
        case 21: System.out.println("Guten Abend");
        		 break;
        default: System.out.println("Guten Tag");
        		 break;
        }
	}

}
