import java.security.*;

public class Main {

	public static void main(String[] args) {
		
		SecureRandom randomNumber = new SecureRandom();
		
		Warrior warrior1 = new Warrior("warrior1", 400, 100);
		Warrior warrior2 = new Warrior("warrior2", 400, 100);
		Warrior warrior3 = new Warrior("warrior3", 400, 100);
		
		Mage mage1 = new Mage("mage1", 280, 200);
		Mage mage2 = new Mage("mage2", 280, 200);
		Mage mage3 = new Mage("mage3", 280, 200);
		
		Warrior[] warriors = {warrior1, warrior2, warrior3};
		Mage[] mages = {mage1, mage2, mage3};
		
		while(true) {
			int w = randomNumber.nextInt(3);
			int m = randomNumber.nextInt(3);
			System.out.println(warriors[w].getName() + " attacked " + mages[m].getName() + "...");
			warriors[w].NewMoon(mages[m]);
			
			w = randomNumber.nextInt(3);
			m = randomNumber.nextInt(3);
			System.out.println(mages[m].getName() + " attacked " + warriors[w].getName() + "...");
			mages[m].SmallFire(warriors[w]);
		}

	}

}