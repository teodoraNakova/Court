package person;

public abstract class Jury extends Person {
	
	public enum positionType{JUDGE, JURYMAN, LAWER, PROSECUTOR};

	private positionType position;
	private int experience;
	private int casesCount;
	
	public Jury(String name, positionType position, int exp, int casesCount) {
		super(name);
		this.position = position;
		this.experience = exp;
		this.casesCount = casesCount;
	}
	
	public int getCasesCount() {
		return casesCount;
	}
	
	public void setCasesCount(int casesCount) {
		this.casesCount = casesCount;
	}
}
