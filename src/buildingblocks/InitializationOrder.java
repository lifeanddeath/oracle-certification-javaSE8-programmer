package buildingblocks;

public class InitializationOrder {
	private String name = "Fluffy";
	{System.out.println("setting field");}
	
	public InitializationOrder(){
		name = "Tiny";
		System.out.println("Setting the constructor");
	}
	
	public static void main(String[] args) {
		InitializationOrder initializationorder  = new InitializationOrder();
		System.out.println(initializationorder.name);
	}

}
