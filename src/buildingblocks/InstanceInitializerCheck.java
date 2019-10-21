package buildingblocks;

public class InstanceInitializerCheck {
	private String name = "experiment";
	{ System.out.println("Hello experiment");}
	public static void main(String[] args) {
		InstanceInitializerCheck initializer = new InstanceInitializerCheck();
		System.out.println(initializer.name);
	}

}
