package person;

import java.util.HashSet;

import cases.Case.IAccuser;

public class Accuser extends Common implements IAccuser {

	private HashSet<Lawer> lawers;
	
	public Accuser(String name, String address, int age) {
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
