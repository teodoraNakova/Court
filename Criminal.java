package cases;

import person.Prosecutor;

public class Criminal extends Case {

	public Criminal(caseType type) {
		super(type);
	}
	
	public void addAccuser(Prosecutor prosecutor) {
		this.accuser = prosecutor;
	}

}
