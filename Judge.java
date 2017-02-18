package person;

import java.util.Random;

public class Judge extends Jury {

	public Judge(String name, positionType position, int exp, int casesCount) {
		super(name, position, (exp > 5 ? exp : 5), casesCount);
	}

	public void imposeSentence() {
		int sentence = new Random().nextInt(37) + 3;
		System.out.println("The judge decided, " + sentence + " years in jail!");
		System.out.println("==================================================");
	}
}
