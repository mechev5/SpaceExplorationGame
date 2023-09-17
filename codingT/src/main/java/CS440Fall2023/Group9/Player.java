package CS440Fall2023.Group9;

public class Player {
	
	String playerName;
	int maxHealth;
	int currentHealth;
	int maxHunger;
	int currentHunger;
	int maxThirst;
	int currentThirst;
	
	public Player(String pN, int mHe, int cHe, int mHu, int cHu, int mT, int cT) {
		this.playerName = pN;
		this.maxHealth = mHe;
		this.currentHealth = cHe;
		this.maxHunger = mHu;
		this.currentHunger = cHu;
		this.maxThirst = mT;
		this.currentThirst = cT;
	}
	
	public Player() {
		this.playerName = "None";
		this.maxHealth = 100;
		this.currentHealth = 100;
		this.maxHunger = 100;
		this.currentHunger = 100;
		this.maxThirst = 100;
		this.currentThirst = 100;
	}
	
	public void ShowStatus() {
		System.out.println("Character name: " + this.playerName);
		System.out.println("Current health: " + this.currentHealth);
		System.out.println("Current hunger: " + this.currentHunger);
		System.out.println("Current thirst: " + this.currentThirst);
	}
	
	
}