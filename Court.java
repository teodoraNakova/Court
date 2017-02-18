package court;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import cases.Case;
import person.Judge;
import person.Jury;
import person.JuryMan;
import person.Lawer;
import person.Prosecutor;

public class Court {

	private String name;
	private String address;
	private HashSet<Judge> judges;
	private HashSet<JuryMan> juryMan;
	private HashSet<Lawer> lawers;
	private HashSet<Prosecutor> prosecutors;
	private HashSet<Case> cases;
	
	public Court(String name, String address) {
		this.judges = new HashSet<Judge>();
		this.juryMan = new HashSet<JuryMan>();
		this.lawers = new HashSet<Lawer>();
		this.prosecutors = new HashSet<Prosecutor>();
		this.cases = new HashSet<Case>();
		this.name = name;
		this.address = address;
	}
	
	public void addJudgeToCourt(Judge judge) {
		this.judges.add(judge);
	}
	
	public void addJuryManToCourt(JuryMan juryMan) {
		this.juryMan.add(juryMan);
	}
	
	public void addLawerToCourt(Lawer lawer) {
		this.lawers.add(lawer);
	}
	
	public void addProsecutorToCourt(Prosecutor prosecutor) {
		this.prosecutors.add(prosecutor);
	}
	
	public void addCase(Case lawCase) {
		this.cases.add(lawCase);
	}
	
	public void printDataForJury() {
		TreeSet<Jury> jury = new TreeSet<Jury>(new Comparator<Jury>() {
			@Override
			public int compare(Jury o1, Jury o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		jury.addAll(judges);
		jury.addAll(juryMan);
		jury.addAll(lawers);
		jury.addAll(prosecutors);
		for(Jury j : jury) {
			System.out.println(j.getName() + " - " + j.getCasesCount());
		}
	}
}
