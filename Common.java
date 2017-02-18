package person;

public class Common extends Person {
	
	private String address;
	private int age;
	
	public Common(String name, String address, int age) {
		super(name);
		this.address = address;
		this.age = age;
	}
	
	public void answerQuestion() {
		System.out.println(this.getName() + " replied.");
	}
	
}
