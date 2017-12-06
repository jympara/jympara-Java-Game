package data;

public class Stats {
	public int Attack;
	public int Defense;
	public int HP;
	private int CritChance;
	public int CritDamage;
	public int AttackTimes;
	
	
	public int getCritChance() {
		return this.CritChance;
	}
	
	public void setCritChance(int critChance) {
		if(critChance >= 100)
			this.CritChance = 100;
		else
			this.CritChance = critChance;
	}

	public Stats(int Attack, int Defense, int HP, int CritChance, int CritDamage, int AttackTimes)
	{
		this.Attack = Attack;
		this.Defense = Defense;
		this.HP = HP;
		this.setCritChance(CritChance);
		this.CritDamage = CritDamage;
		this.AttackTimes = AttackTimes;
	}
	
	public Stats(Stats toClone)
	{
		this.Attack = toClone.Attack;
		this.Defense = toClone.Defense;
		this.HP = toClone.HP;
		this.setCritChance(toClone.getCritChance());
		this.CritDamage = toClone.CritDamage;
		this.AttackTimes = toClone.AttackTimes;
	}
	
	public Stats add(Stats Stats1, Stats Stats2)
	{
		Stats Stats3= new Stats(0,0,0,0,0,0);
		Stats3.Attack = Stats1.Attack + Stats2.Attack;
		Stats3.Defense = Stats1.Defense + Stats2.Defense;
		Stats3.HP = Stats1.HP + Stats2.HP;
		Stats3.setCritChance(Stats1.getCritChance() + Stats2.getCritChance());
		Stats3.CritDamage = Stats1.CritDamage + Stats2.CritDamage;
		Stats3.AttackTimes = Stats1.AttackTimes + Stats2.AttackTimes;
		return Stats3;
	}
	
	public void takeDamage(int Amount)
	{
		
	}
	
}
