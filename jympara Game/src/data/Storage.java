package data;

import data.Class;
import data.Enemy;
import java.util.ArrayList;
import java.util.TreeMap;


public class Storage {
	public static TreeMap<String, Class> ClassList = new TreeMap<String, Class>();
	
	
	public static void LoadDefaultClasses()
	{
		ClassList.put("Warrior", new Class("Warrior", new Stats(20,10,200,0,0,1),new Stats(2,2,20,0,0,0)));
		ClassList.put("Archer", new Class("Archer", new Stats(30,5,150,10,150,1),new Stats(4,1,10,1,10,0)));
		ClassList.put("Rogue", new Class("Rogue", new Stats(25,4,120,35,175,2),new Stats(2,1,200,5,10,0)));
		ClassList.put("Mage", new Class("Mage", new Stats(40,3,100,10,150,1),new Stats(3,0,200,0,0,0)));
		ClassList.put("GunSlinger", new Class("GunSlinger", new Stats(8,2,120,5,150,5),new Stats(2,0,5,2,15,1)));
	}
	
	
	public static ArrayList<Player> PlayerList = new ArrayList<Player>();
	public static ArrayList<Player> ActivePlayerList = new ArrayList<Player>();
	
	public static void LoadDefaultPlayers()
	{
		PlayerList.add(CreatePlayerWithCustomStats("Rambo", "GunSlinger", new Stats(10,0,300,1,120,10)));
		PlayerList.add(CreatePlayerWithCustomStats("Hawkeye", "GunSlinger", new Stats(25,5,175,10,160,2)));
		PlayerList.add(CreatePlayerWithCustomStats("Harry_Potter", "Mage", new Stats(50,0,100,20,500,1)));
		PlayerList.add(CreatePlayerWithCustomStats("King_Arthur", "Warrior", new Stats(40,15,250,0,0,1)));
		PlayerList.add(CreatePlayerWithCustomStats("Golem", "Warrior", new Stats(95,10,200,0,0,1)));
	}
	
	public static Player CreatePlayerWithCustomStats(String Name, String ClassName, Stats CustomStats)
	{
		Player S = new Player(Name, new Class(ClassList.get(ClassName).Name, new Stats(CustomStats), ClassList.get(ClassName).PerLevelStats));
		return S;
	}
	
	public static ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
	public static ArrayList<Enemy> ActiveEnemyList = new ArrayList<Enemy>();
	
	public static void LoadDefaultEnemies()
	{
		EnemyList.add(CreateEnemyWithCustomStats("Murloc", "Warrior", new Stats(15,8,100,0,0,1)));
		EnemyList.add(CreateEnemyWithCustomStats("Archer_Murloc", "Archer", new Stats(25,2,100,0,0,1)));
		EnemyList.add(CreateEnemyWithCustomStats("Mage_Murloc", "Mage", new Stats(25,2,125,0,0,1)));
		EnemyList.add(CreateEnemyWithCustomStats("Goblin", "Warrior", new Stats(20,5,150,0,0,1)));
		EnemyList.add(CreateEnemyWithCustomStats("Archer_Goblin", "Archer",new Stats(50,3,75,0,0,1)));
	}
	
	public static Enemy CreateEnemyWithCustomStats(String Name, String ClassName, Stats CustomStats)
	{
		Enemy S = new Enemy(Name, new Class(ClassList.get(ClassName).Name, new Stats(CustomStats), ClassList.get(ClassName).PerLevelStats));
		return S;
	}
	
	
	public static int getPlayerListIndexFromName(String Name)
	{
		for (Player player : PlayerList) {
			if(player.Name.equals(Name))
				return PlayerList.indexOf(player);
		}
		throw new NullPointerException("Player Doesn't Exist");
	}
	
	
	public static int getEnemyListIndexFromName(String Name)
	{
		for (Enemy enemy : EnemyList) {
			if(enemy.Name.equals(Name))
				return EnemyList.indexOf(enemy);
			else 
				throw new NullPointerException("Player Doesn't Exist");
		}
		return (Integer) null;
	}
	
}
