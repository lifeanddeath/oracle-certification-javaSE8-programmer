package primitives;

public class Example11 {

	public static void main(String[] args) {
		byte a = 1;
		short b = 1;
		int c  = 1;
		long l = 1;
		float f = 1;
		double d = 1;
		Byte charWrapper = 1;
		Short shortWrapper = 1;
		Integer integer  = 1;
		Long longWrapper = 1l;
		Float floatWrapper = 1f;
		Double doubleWrapper = 1d;
		
		printnumber(a);
		printnumber(b);
		printnumber(c);
	//	printnumber(l); // doesnt compile
	//	printnumber(f); // doesn't compile
	//	printnumber(d); // doesn't compile
		printnumber(charWrapper);
		printnumber(shortWrapper);
		printnumber(integer);
	//	printnumber(longWrapper); // doesn't compile
	//	printnumber(floatWrapper);	 // doesn't compile
	}
	
	public static int printnumber(int a) {
		System.out.println(a);
		return a;
	}
}
