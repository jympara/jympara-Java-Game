package data;

public abstract class Unit {
	public String Name;
	public Class Class;
	public Stats CurrentStats;
	
	public Unit(String Name, Class Class)
	{
		this.Name = Name;
		this.Class = Class;
		this.CurrentStats = Class.BaseStats;
	}
	
	public Unit(Unit toClone)
	{
		this.Name = toClone.Name;
		this.Class = new Class(toClone.Class);
		this.CurrentStats = new Stats(toClone.CurrentStats);
	}
	
	public boolean isAlive()
	{
		return this.CurrentStats.HP > 0;
	}

}
