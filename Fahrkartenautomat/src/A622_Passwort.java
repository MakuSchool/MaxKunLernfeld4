
public class A622_Passwort {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			if (checkPasscode(i)) {
				System.out.println(i);
			}
		}

	}
	
	public static boolean checkPasscode(int H4XOR) {
		boolean result = false ;
		//(52 ^ (9x6c)) = ( 52 ^ 108) = 00110100 XOR 01101100 = 01011000 = 88
		//(3 << (14%6)) = (3 << 2) = 11 << 2 = 1100 = 12
		//(E1337 + (2 >>> 1)) = E1337 + (10 >>> 1) = (E1337 + 1)
		// 123456789 & 0 = 0
		for (int E1337 = 42; E1337 <= (52 ^ (0x6c)); E1337 += (3 << (14%6))) {
			if (result = ((++E1337 | E1337 + ( 2 >>> 1)) ^ (1+H4XOR )) == (123456789 & 0)) break;
		}
		return result;
	}

}
