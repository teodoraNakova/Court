package cases;

import java.util.HashSet;
import java.util.Random;

import person.Accuser;
import person.Defendant;
import person.Judge;
import person.Jury;
import person.JuryMan;
import person.Lawer;
import person.Prosecutor;
import person.Witness;

public abstract class Case {
	
	public interface IAccuser{
		
	}

	public enum caseType{CIVIL, CRIMINAL};
	
	private caseType type;
	private Judge judge;
	private HashSet<JuryMan> juryMan;
	private Defendant defendant;
	protected IAccuser accuser;
	private HashSet<Witness> witnesses;
	
	public Case(caseType type) {
		juryMan = new HashSet<JuryMan>();
		witnesses = new HashSet<Witness>();
		this.type = type;
	}
	
	public void addJudje(Judge judge) {
		this.judge = judge;
	}
	
	public void addJuryMan(JuryMan juryMan) {
		this.juryMan.add(juryMan);
	}
	
	public void addDefendant(Defendant defendant) {
		this.defendant = defendant;
	}
	
	public void addWitness(Witness witness) {
		this.witnesses.add(witness);
	}
	
	public Defendant getDefendant() {
		return defendant;
	}
	
	public IAccuser getAccuser() {
		return (Accuser) accuser;
	}
	
	public void conductCase() {
		for(JuryMan juryMan : this.juryMan) {
			int currentCasesCount = juryMan.getCasesCount();
			juryMan.setCasesCount(currentCasesCount + 1); 
		}
		
		if(this.accuser instanceof Prosecutor) {
			Prosecutor p = (Prosecutor) this.accuser;
			int currentCasesCount = p.getCasesCount();
			p.setCasesCount(currentCasesCount + 1);
		}
		
		checkCaseType(this);
		
		HashSet<Lawer> lawers = this.getDefendant().getLawers();
		for(Lawer l : lawers) {
			for(Witness w : this.witnesses) {
				for(int i = 0; i < 5; i++) {
					l.askQuestion(w);
				}		
			}
		}
		
		int guiltyVote = 0;
		for(JuryMan j : this.juryMan) {
			if(new Random().nextBoolean()) {
				guiltyVote++;
			} 
		}
		boolean isGuilty = (guiltyVote > this.juryMan.size() / 2) ? true : false;
		
		if(isGuilty) {
			this.judge.imposeSentence();
		} else {
			System.out.println("The jurymen decided, not guilty!");
			System.out.println("================================");
		}
	}
	
	private void checkCaseType(Case currentCase) {
		if(currentCase instanceof Civil) {
			Accuser accuser = (Accuser) currentCase.getAccuser();
			HashSet<Lawer> lawers = accuser.getLawers();
			for(Lawer l : lawers) {
				int currentCasesCount = l.getCasesCount();
				l.setCasesCount(currentCasesCount + 1); 
				for(int i = 0; i < 3; i++) {
					l.askQuestion(currentCase.defendant);
				}
				
				for(Witness w : currentCase.witnesses) {
					l.askQuestion(w);
					l.askQuestion(w);
				}
			}
		} else {
			Prosecutor p = (Prosecutor) currentCase.accuser;
			for(int i = 0; i < 5; i++) {
				p.askQuestion(this.defendant);
			}
			for(Witness w : currentCase.witnesses) {
				for(int i = 0; i < 5; i++) {
					p.askQuestion(w);
				}		
			}
		}	
	}
	
}
