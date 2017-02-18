package person;

public class Lawer extends Jury {

	public Lawer(String name, positionType position, int exp, int casesCount) {
		super(name, position, exp, (casesCount > 10 ? casesCount : 10));
	}
	
	public void askQuestion(Common person) {
		System.out.println(person.getName() + " was asked a question by a lawer.");
		person.answerQuestion();
	}

}
