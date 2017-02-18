package cases;

import person.Accuser;
import person.JuryMan;

public class Civil extends Case {

	public Civil(caseType type) {
		super(type);
	}
	
	public void addAccuser(Accuser accuser) {
		this.accuser = accuser;
	}

}
