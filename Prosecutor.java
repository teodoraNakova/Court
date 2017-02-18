package person;

import cases.Case.IAccuser;

public class Prosecutor extends Jury implements IAccuser {

	public Prosecutor(String name, positionType position, int exp, int casesCount) {
		super(name, position, (exp > 10 ? exp : 10), casesCount);
	}
	
	public void askQuestion(Common person) {
		System.out.println(person.getName() + " was asked a question by a prosecutor.");
		person.answerQuestion();
	}

}
