package person;

import java.util.HashSet;

public class Defendant extends Common {

	private HashSet<Lawer> lawers;
	
	public Defendant(String name, String address, int age) {
		super(name, address, age);
		lawers = new HashSet<Lawer>();
	}
	
	public void addLawer(Lawer lawer) {
		this.lawers.add(lawer);
	}
	
	public HashSet<Lawer> getLawers() {
		return lawers;
	}
}
