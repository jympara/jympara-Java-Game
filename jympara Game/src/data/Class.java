package data;


public class Class {
	public String Name;
	public Stats BaseStats;
	public Stats PerLevelStats;
	
	public Class(String Name, Stats BaseStats, Stats PerLevelStats)
	{
		this.Name = Name;
		this.BaseStats = BaseStats;
		this.PerLevelStats = PerLevelStats;
	}
	
	// Clone Class
	public Class(Class toClone)
	{
		this.Name = toClone.Name;
		this.BaseStats = new Stats(toClone.BaseStats);
		this.PerLevelStats = new Stats(toClone.PerLevelStats);
	}
	
	
}
