package demo;

import java.util.ArrayList;

import cases.Case;
import cases.Civil;
import cases.Criminal;
import person.Accuser;
import person.Common;
import person.Defendant;
import person.Judge;
import person.Jury;
import person.JuryMan;
import person.Lawer;
import person.Prosecutor;
import person.Witness;
import court.Court;

public class Demo {

	public static void main(String[] args) {
		//1
		Court courtVT = new Court("Court Veliko Tyrnovo", "Veliko Tyrnovo");
		
		//2
		ArrayList<Judge> judges = new ArrayList<Judge>();
		for (int i = 0; i < 3; i++) {
			Judge judge = new Judge("Judge Number " + (i + 1), Jury.positionType.JUDGE, 15, 15);
			courtVT.addJudgeToCourt(judge);
			judges.add(judge);
		}
		
		ArrayList<JuryMan> juryMen = new ArrayList<JuryMan>();
		for(int i = 0; i < 13; i++) {
			JuryMan juryMan = new JuryMan("JuryMan Number " + (i + 1), Jury.positionType.JURYMAN, 15, 15);
			courtVT.addJuryManToCourt(juryMan);
			juryMen.add(juryMan);
		}
		
		ArrayList<Lawer> lawers = new ArrayList<Lawer>();
		for (int i = 0; i < 5; i++) {
			Lawer lawer = new Lawer("Lawer Number " + (i + 1), Jury.positionType.LAWER, 15, 15);
			courtVT.addLawerToCourt(lawer);
			lawers.add(lawer);
		}
		
		ArrayList<Prosecutor> prosecutors = new ArrayList<Prosecutor>();
		for(int i = 0; i < 2; i++) {
			Prosecutor prosecutor = new Prosecutor("Prosecutor Number " + (i + 1), Jury.positionType.PROSECUTOR, 15, 15);
			courtVT.addProsecutorToCourt(prosecutor);
			prosecutors.add(prosecutor);
		}
		
		//3
		ArrayList<Defendant> defendants = new ArrayList<Defendant>();
		ArrayList<Accuser> accusers = new ArrayList<Accuser>();
		ArrayList<Witness> witnesses = new ArrayList<Witness>();
		for(int i = 0; i < 5; i++) {
			Accuser accuser = new Accuser("Accuser Number " + (i + 1), "Sofia", 36);
			Defendant defendant = new Defendant("Defendant Number " + (i + 1), "Sofia", 25);
			accusers.add(accuser);
			defendants.add(defendant);
		}
		
		for(int i = 0; i < 10; i++) {
			Witness witness = new Witness("Witness Number " + (i + 1), "Sofia", 30);
			witnesses.add(witness);
		}
		
		//4
		Civil civilCase1 = new Civil(Case.caseType.CIVIL);
		Civil civilCase2 = new Civil(Case.caseType.CIVIL);
		Civil civilCase3 = new Civil(Case.caseType.CIVIL);
		courtVT.addCase(civilCase1);
		courtVT.addCase(civilCase2);
		courtVT.addCase(civilCase3);
		
		civilCase1.addJudje(judges.get(0));
		civilCase2.addJudje(judges.get(1));
		civilCase3.addJudje(judges.get(2));
		
		for(int i = 0; i < 9; i++) {
			if(i < 3) {
				civilCase1.addJuryMan(juryMen.get(i));
			}
			if(i >= 3 && i < 6) {
				civilCase2.addJuryMan(juryMen.get(i));
			}
			if(i >= 6) {
				civilCase3.addJuryMan(juryMen.get(i));
			}
		}
		
		civilCase1.addDefendant(defendants.get(0));
		civilCase1.getDefendant().addLawer(lawers.get(0));
		civilCase2.addDefendant(defendants.get(1));
		civilCase2.getDefendant().addLawer(lawers.get(1));
		civilCase3.addDefendant(defendants.get(2));
		civilCase3.getDefendant().addLawer(lawers.get(3));
		
		civilCase1.addAccuser(accusers.get(0));
		accusers.get(0).addLawer(lawers.get(0));
		civilCase2.addAccuser(accusers.get(1));
		accusers.get(1).addLawer(lawers.get(1));
		civilCase3.addAccuser(accusers.get(2));
		accusers.get(2).addLawer(lawers.get(3));
		
		for(int i = 0; i < 3; i++) {
			civilCase1.addWitness(witnesses.get(i));
			civilCase2.addWitness(witnesses.get(i));
			civilCase3.addWitness(witnesses.get(i));
		}
		
		//5
		Criminal criminalCase1 = new Criminal(Case.caseType.CRIMINAL);
		Criminal criminalCase2= new Criminal(Case.caseType.CRIMINAL);
		Criminal criminalCase3 = new Criminal(Case.caseType.CRIMINAL);
		courtVT.addCase(criminalCase1);
		courtVT.addCase(criminalCase2);
		courtVT.addCase(criminalCase3);
		
		criminalCase1.addJudje(judges.get(0));
		criminalCase2.addJudje(judges.get(1));
		criminalCase3.addJudje(judges.get(2));
		
		for(int i = 0; i < juryMen.size(); i++) {
			criminalCase1.addJuryMan(juryMen.get(i));
			criminalCase2.addJuryMan(juryMen.get(i));
			criminalCase3.addJuryMan(juryMen.get(i));
		}
		
		criminalCase1.addDefendant(defendants.get(0));
		criminalCase1.getDefendant().addLawer(lawers.get(0));
		criminalCase2.addDefendant(defendants.get(1));
		criminalCase2.getDefendant().addLawer(lawers.get(1));
		criminalCase3.addDefendant(defendants.get(2));
		criminalCase3.getDefendant().addLawer(lawers.get(2));
		
		criminalCase1.addAccuser(prosecutors.get(0));
		criminalCase2.addAccuser(prosecutors.get(1));
		criminalCase3.addAccuser(prosecutors.get(0));
		
		//6, 7
		courtVT.printDataForJury();
		
		civilCase1.conductCase();
		civilCase2.conductCase();
		civilCase3.conductCase();
		criminalCase1.conductCase();
		criminalCase2.conductCase();
		criminalCase3.conductCase();
		
		courtVT.printDataForJury();
	}

}
