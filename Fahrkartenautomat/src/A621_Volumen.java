
public class A621_Volumen {

	public static void main(String[] args) {
		System.out.println(volume(3));
		System.out.println(volume(0.9));

	}
	
	public static double volume(double edge_length) {
		return Math.pow(edge_length, 3);
	}

}
