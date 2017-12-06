package main;

import data.Enemy;
import data.Player;
import data.Storage;


public class Prints {
	
	static void Welcome()
	{
		System.out.println("Welcome to jympara's Game!");
		System.out.println("This is a turn-base console game.");
		System.out.println();
	}
	
	static void AvailableCommands()
	{
		System.out.println("Available commands: Attack X ");//| Defend X");
	}
	
	static void CurrentPlayerTurn(int PlayerPos)
	{
		String playerName = new String(Storage.ActivePlayerList.get(PlayerPos).Name);
		System.out.println("It's player " + (PlayerPos+1) + "(" + playerName + ")'s turn.");
	}
	
	
	
	static void CreateNewPlayer()
	{
		System.out.println("Choose New Player's Info:");
		System.out.println("Name - One word");
		System.out.println("Class - Warrior, Archer, Rogue, Mage, GunSlinger");
		System.out.println("Template: Name Class");
		System.out.println();
	}
	
	static void PrintAllPlayersStats()
	{
		int PlayersCount = Storage.ActivePlayerList.size();
		if(PlayersCount == 1)
			PrintPlayerStats(0);
		else if (PlayersCount == 2)
			PrintPlayerStats(0, 1);
		else if (PlayersCount == 3)
			PrintPlayerStats(0, 1, 2);
		else if (PlayersCount == 4)
			PrintPlayerStats(0, 1, 2, 3);
	}
	
	static void CreatedPlayer()
	{
		System.out.println("Player successfully created!");
	}
	
	static void PrintPlayerStats(int Player1)
	{
		Player CPP1 = Storage.ActivePlayerList.get(Player1);
		System.out.println("Player 1");
		System.out.println("Player Name: " + CPP1.Name);
		System.out.println("Class: " + CPP1.Class.Name);
		System.out.println("Attack: " + CPP1.CurrentStats.Attack);
		System.out.println("Defense: " + CPP1.CurrentStats.Defense);
		System.out.println("HP: " + CPP1.CurrentStats.HP);
		System.out.println("Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%");
		System.out.println("Crit Damage: " + CPP1.CurrentStats.CritDamage);
		System.out.println("Attack Times: " + CPP1.CurrentStats.AttackTimes);
		System.out.println();
	}
	
	static void PrintPlayerStats(int Player1, int Player2)
	{
		int Length = 35;
		
		Player CPP1 = Storage.ActivePlayerList.get(Player1);
		Player CPP2 = Storage.ActivePlayerList.get(Player2);
		
		String Line;
		Line = "Player 1";
		Line = EqualizeLine(Line, Length);
		Line += "Player 2";
		System.out.println(Line);
		
		Line = "Player Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Player Name: " + CPP2.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	static void PrintPlayerStats(int Player1, int Player2, int Player3)
	{
		int Length = 35;

		Player CPP1 = Storage.ActivePlayerList.get(Player1);
		Player CPP2 = Storage.ActivePlayerList.get(Player2);
		Player CPP3 = Storage.ActivePlayerList.get(Player3);
		
		String Line;
		
		Line = "Player 1";
		Line = EqualizeLine(Line, Length);
		Line += "Player 2";
		Line = EqualizeLine(Line, Length*2);
		Line += "Player 3";
		System.out.println(Line);
		
		Line = "Player Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Player Name: " + CPP2.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Player Name: " + CPP3.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Class: " + CPP3.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack: " + CPP3.CurrentStats.Attack;
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*2);
		Line += "Defense: " + CPP3.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*2);
		Line += "HP: " + CPP3.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance();
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Chance: " + CPP3.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Damage: " + CPP3.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack Times: " + CPP3.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	static void PrintPlayerStats(int Player1, int Player2, int Player3, int Player4)
	{
		int Length = 35;
		
		Player CPP1 = Storage.ActivePlayerList.get(Player1);
		Player CPP2 = Storage.ActivePlayerList.get(Player2);
		Player CPP3 = Storage.ActivePlayerList.get(Player3);
		Player CPP4 = Storage.ActivePlayerList.get(Player4);
		
		String Line;
		
		Line = "Player 1";
		Line = EqualizeLine(Line, Length);
		Line += "Player 2";
		Line = EqualizeLine(Line, Length*2);
		Line += "Player 3";
		Line = EqualizeLine(Line, Length*3);
		Line += "Player 4";
		System.out.println(Line);
		
		Line = "Player Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Player Name: " + CPP2.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Player Name: " + CPP3.Name;
		Line = EqualizeLine(Line, Length*3);
		Line += "Player Name: " + CPP4.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Class: " + CPP3.Class.Name;
		Line = EqualizeLine(Line, Length*3);
		Line += "Class: " + CPP4.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack: " + CPP3.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*3);
		Line += "Attack: " + CPP4.CurrentStats.Attack;
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*2);
		Line += "Defense: " + CPP3.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*3);
		Line += "Defense: " + CPP4.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*2);
		Line += "HP: " + CPP3.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*3);
		Line += "HP: " + CPP4.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Chance: " + CPP3.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*3);
		Line += "Crit Chance: " + CPP4.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Damage: " + CPP3.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*3);
		Line += "Crit Damage: " + CPP4.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack Times: " + CPP3.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*3);
		Line += "Attack Times: " + CPP4.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	
	static void PrintAllEnemyStats()
	{
		int EnemyCount = Storage.ActiveEnemyList.size();
		if(EnemyCount == 1)
			PrintEnemyStats(0);
		else if (EnemyCount == 2)
			PrintEnemyStats(0, 1);
		else if (EnemyCount == 3)
			PrintEnemyStats(0, 1, 2);
		else if (EnemyCount == 4)
			PrintEnemyStats(0, 1, 2, 3);
	}
	
	static void PrintEnemyStats(int Enemy1)
	{
		Enemy CPP1 = Storage.ActiveEnemyList.get(Enemy1);
		System.out.println("Enemy 1");
		System.out.println("Enemy Name: " + CPP1.Name);
		System.out.println("Class: " + CPP1.Class.Name);
		System.out.println("Attack: " + CPP1.CurrentStats.Attack);
		System.out.println("Defense: " + CPP1.CurrentStats.Defense);
		System.out.println("HP: " + CPP1.CurrentStats.HP);
		System.out.println("Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%");
		System.out.println("Crit Damage: " + CPP1.CurrentStats.CritDamage);
		System.out.println("Attack Times: " + CPP1.CurrentStats.AttackTimes);
		System.out.println();
	}
	
	static void PrintEnemyStats(int Enemy1, int Enemy2)
	{
		int Length = 35;
		
		Enemy CPP1 = Storage.ActiveEnemyList.get(Enemy1);
		Enemy CPP2 = Storage.ActiveEnemyList.get(Enemy2);
		
		String Line;
		
		Line = "Enemy 1";
		Line = EqualizeLine(Line, Length);
		Line += "Enemy 2";
		System.out.println(Line);
		
		Line = "Enemy Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Enemy Name: " + CPP2.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	static void PrintEnemyStats(int Enemy1, int Enemy2, int Enemy3)
	{
		int Length = 35;
		
		Enemy CPP1 = Storage.ActiveEnemyList.get(Enemy1);
		Enemy CPP2 = Storage.ActiveEnemyList.get(Enemy2);
		Enemy CPP3 = Storage.ActiveEnemyList.get(Enemy3);
		
		String Line;
		
		Line = "Enemy 1";
		Line = EqualizeLine(Line, Length);
		Line += "Enemy 2";
		Line = EqualizeLine(Line, Length*2);
		Line += "Enemy 3";
		System.out.println(Line);
		
		Line = "Enemy Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Enemy Name: " + CPP2.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Enemy Name: " + CPP3.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Class: " + CPP3.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack: " + CPP3.CurrentStats.Attack;
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*2);
		Line += "Defense: " + CPP3.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*2);
		Line += "HP: " + CPP3.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance();
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Chance: " + CPP3.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Damage: " + CPP3.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack Times: " + CPP3.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	static void PrintEnemyStats(int Enemy1, int Enemy2, int Enemy3, int Enemy4)
	{
		int Length = 35;
		
		Enemy CPP1 = Storage.ActiveEnemyList.get(Enemy1);
		Enemy CPP2 = Storage.ActiveEnemyList.get(Enemy2);
		Enemy CPP3 = Storage.ActiveEnemyList.get(Enemy3);
		Enemy CPP4 = Storage.ActiveEnemyList.get(Enemy4);
		
		String Line;
		
		Line = "Enemy 1";
		Line = EqualizeLine(Line, Length);
		Line += "Enemy 2";
		Line = EqualizeLine(Line, Length*2);
		Line += "Enemy 3";
		Line = EqualizeLine(Line, Length*3);
		Line += "Enemy 4";
		System.out.println(Line);
		
		Line = "Enemy Name: " + CPP1.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Enemy Name: " + CPP2.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Enemy Name: " + CPP3.Name;
		Line = EqualizeLine(Line, Length*3);
		Line += "Enemy Name: " + CPP4.Name;
		System.out.println(Line);
		
		Line = "Class: " + CPP1.Class.Name;
		Line = EqualizeLine(Line, Length);
		Line += "Class: " + CPP2.Class.Name;
		Line = EqualizeLine(Line, Length*2);
		Line += "Class: " + CPP3.Class.Name;
		Line = EqualizeLine(Line, Length*3);
		Line += "Class: " + CPP4.Class.Name;
		System.out.println(Line);
		
		Line = "Attack: " + CPP1.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length);
		Line += "Attack: " + CPP2.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack: " + CPP3.CurrentStats.Attack;
		Line = EqualizeLine(Line, Length*3);
		Line += "Attack: " + CPP4.CurrentStats.Attack;
		System.out.println(Line);
		
		Line = "Defense: " + CPP1.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length);
		Line += "Defense: " + CPP2.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*2);
		Line += "Defense: " + CPP3.CurrentStats.Defense;
		Line = EqualizeLine(Line, Length*3);
		Line += "Defense: " + CPP4.CurrentStats.Defense;
		System.out.println(Line);
		
		Line = "HP: " + CPP1.CurrentStats.HP;
		Line = EqualizeLine(Line, Length);
		Line += "HP: " + CPP2.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*2);
		Line += "HP: " + CPP3.CurrentStats.HP;
		Line = EqualizeLine(Line, Length*3);
		Line += "HP: " + CPP4.CurrentStats.HP;
		System.out.println(Line);
		
		Line = "Crit Chance: " + CPP1.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length);
		Line += "Crit Chance: " + CPP2.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Chance: " + CPP3.CurrentStats.getCritChance() + "%";
		Line = EqualizeLine(Line, Length*3);
		Line += "Crit Chance: " + CPP4.CurrentStats.getCritChance() + "%";
		System.out.println(Line);
		
		Line = "Crit Damage: " + CPP1.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length);
		Line += "Crit Damage: " + CPP2.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*2);
		Line += "Crit Damage: " + CPP3.CurrentStats.CritDamage;
		Line = EqualizeLine(Line, Length*3);
		Line += "Crit Damage: " + CPP4.CurrentStats.CritDamage;
		System.out.println(Line);
		
		Line = "Attack Times: " + CPP1.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length);
		Line += "Attack Times: " + CPP2.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*2);
		Line += "Attack Times: " + CPP3.CurrentStats.AttackTimes;
		Line = EqualizeLine(Line, Length*3);
		Line += "Attack Times: " + CPP4.CurrentStats.AttackTimes;
		System.out.println(Line);
		System.out.println();
	}
	
	
	static String EqualizeLine(String Line, int Length)
	{
		while(Line.length() < Length)
			Line += " ";
		return Line;
	}
	
	static void FightStart(String EnemyName)
	{
		
	}
	
}
