package main;


import java.util.Random;
import java.util.Scanner;
import data.Class;
import data.Enemy;
import data.Player;
import data.Stats;
import data.Storage;


public class Main {
	public static String ChatLog;
	

	public static void Process()
	{
		//CreatePlayer();
		int Fights = 1;
		Scanner reader = new Scanner(System.in);
		
		String Input;
		do
		{
			Prints.CreateNewPlayer();
			
			// New player name and class
			Input = reader.next();
			if(Input.toLowerCase().equals("end"))
			{
				//System.out.println("broke name");
				break;
			}
			String Name = Input;
			do
			{
				Input = reader.next();
			}while(!Storage.ClassList.containsKey(Input));
			String ClassName = Input;
			
			// Add new player to both player lists
			
			CreateNewPlayer(Name, ClassName);
			AddPlayer(Name);
			Prints.CreatedPlayer();
		}while(Storage.ActivePlayerList.size() < 4);
		
		
		
		do
		{
			ChatLog = new String();
			GenerateRandomEnemies();
			ClearConsole();
			String input = "";
			do
			{
				for(int ActivePlayerNumber = 0; ActivePlayerNumber < Storage.ActivePlayerList.size(); ActivePlayerNumber++)
				{
					String Command = new String();
					int Target = 0;
//					do
//					{
						System.out.println(ChatLog);
						Prints.PrintAllPlayersStats();
						Prints.PrintAllEnemyStats();
						Prints.CurrentPlayerTurn(ActivePlayerNumber);
						Prints.AvailableCommands();
						//Command = reader.next();
						//if(Command.toLowerCase().startsWith("attack") || Command.toLowerCase().startsWith("a") || Command.toLowerCase().startsWith("att"))
						//{
							do
							{
								String check = new String(reader.next());
								Target = new Integer(check);
								if(Target > 0 || Target <= Storage.ActiveEnemyList.size())
									break;
								System.out.println("Invalid Target!");
							}while(true);
							Target -= 1;
							//System.out.println("Got Attack Target!");
							
							PlayerAttack(ActivePlayerNumber, Target);
							
						//}
//						else if(Command.toLowerCase().startsWith("defend"))
//						{
//							do
//							{
//								
//								String check = reader.next();
//								Target = Integer.parseInt(check);
//								
//							}while(Target < 0 || Target > Storage.ActivePlayerList.size());
//							System.out.println("Got Defense Target!");
//							
//							PlayerDefend(ActivePlayerNumber, Target);
//							
//						}
						
						ClearConsole();
						
						CheckForDead();
						try {
							Storage.ActiveEnemyList.get(ActivePlayerNumber);
						} catch (IndexOutOfBoundsException e) {
							break;
						}
						EnemyAttack(ActivePlayerNumber);
						CheckForDead();
						
//					}while(!Command.toLowerCase().equals("attack") && !Command.toLowerCase().equals("defend"));
//					
					if(Storage.ActivePlayerList.size() == 0 || Storage.ActiveEnemyList.size() == 0)
						break;
					
				}
				
			}while(Storage.ActivePlayerList.size() != 0 && Storage.ActiveEnemyList.size() != 0);

			reader.nextLine();
			while(Storage.ActivePlayerList.size() > 0)
			{
				System.out.println("Fights so far: " + Fights);
				System.out.println("Available commands: check players | fight again");
				input = reader.nextLine();
					
				if(input.toLowerCase().equals("check players"))
				{
					ClearConsole();
					Prints.PrintAllPlayersStats();
				}
				else if(input.toLowerCase().equals("fight again"))
				{
					HealAllPlayers();
					Fights ++;
					break;
				}
				
			}
		}while(Storage.ActivePlayerList.size() > 0);
		System.out.println("End of Game.");
		reader.close();
	}
	
	static void PlayerDefend(int activePlayerNumber, int target) {
		
		
		
	}

	public static void CheckForDead()
	{
		int PlayerCount = Storage.ActivePlayerList.size();
		int EnemyCount = Storage.ActiveEnemyList.size();
		for(int i = 0; i < PlayerCount; i++)
		{
			if(!Storage.ActivePlayerList.get(i).isAlive())
			{
				KillPlayer(i);
				i --;
				PlayerCount = Storage.ActivePlayerList.size();
			}
		}
		for(int i = 0; i < EnemyCount; i++)
		{
			if(!Storage.ActiveEnemyList.get(i).isAlive())
			{
				KillEnemy(i);
				i --;
				EnemyCount = Storage.ActiveEnemyList.size();
			}
		}
		
	}
	
	public static void PlayerAttack(int Player, int Enemy)
	{
		// Checks if enemy is in the list
		try {
			Storage.ActivePlayerList.get(Player);
			Storage.ActiveEnemyList.get(Enemy);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid Target! \n " + e.getMessage());
			return;
		}
		
		int AttackDamage = Storage.ActivePlayerList.get(Player).CurrentStats.Attack;
		int AttackTimes = Storage.ActivePlayerList.get(Player).CurrentStats.AttackTimes;
		int CritDamage = Storage.ActivePlayerList.get(Player).CurrentStats.getCritChance();
		int Defense = Storage.ActiveEnemyList.get(Enemy).CurrentStats.Defense;
		boolean CritHit = false;
		if(Storage.ActivePlayerList.get(Player).CurrentStats.getCritChance() >= GetRandomNumber(0, 100))
			CritHit = true;
		int DamageTaken;
		if(CritHit == false)
			DamageTaken = (AttackDamage - Defense) * AttackTimes;
		else 
		{
			DamageTaken = (AttackDamage - Defense) * (CritDamage / 100) * AttackTimes;
			ChatLog += "\n" + Storage.ActivePlayerList.get(Player).Name + " Crit!";
		}
		
		Stats EnemyStats = Storage.ActiveEnemyList.get(Enemy).CurrentStats;
		EnemyStats.HP -= DamageTaken;
		
	}
	
	public static void EnemyAttack(int Enemy)
	{
		int Player = GetRandomNumber(0,Storage.ActivePlayerList.size());
//		try {
//			Storage.ActivePlayerList.get(Enemy);
//			Storage.ActiveEnemyList.get(Player);
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("Invalid Target! \n " + e.getMessage());
//			return;
//		}
//		
		int AttackDamage = Storage.ActiveEnemyList.get(Enemy).CurrentStats.Attack;
		int AttackTimes = Storage.ActiveEnemyList.get(Enemy).CurrentStats.AttackTimes;
		int CritDamage = Storage.ActiveEnemyList.get(Enemy).CurrentStats.getCritChance();
		int Defense = Storage.ActivePlayerList.get(Player).CurrentStats.Defense;
		boolean CritHit = false;
		if(Storage.ActiveEnemyList.get(Enemy).CurrentStats.getCritChance() >= GetRandomNumber(0, 100))
			CritHit = true;
		int DamageTaken;
		if(CritHit == false)
			DamageTaken = (AttackDamage - Defense) * AttackTimes;
		else 
		{
			DamageTaken = (AttackDamage - Defense) * (CritDamage / 100) * AttackTimes;
			ChatLog += "\n" + Storage.ActiveEnemyList.get(Enemy).Name + " Crit!";
		}
			
		Stats PlayerStats = Storage.ActivePlayerList.get(Player).CurrentStats;
		PlayerStats.HP -= DamageTaken;
	}
	
	public static void KillPlayer(int PlayerPos)
	{
		String PlayerName = new String(Storage.ActivePlayerList.get(PlayerPos).Name);
		ChatLog += "\nPlayer " + PlayerPos + "(" + PlayerName + ") has died!";
		Storage.ActivePlayerList.remove(PlayerPos);
	}
	
	public static void KillEnemy(int EnemyPos)
	{
		String EnemyName = new String(Storage.ActiveEnemyList.get(EnemyPos).Name);
		ChatLog += "\nEnemy " + EnemyPos + "(" + EnemyName + ") has died!";
		Storage.ActiveEnemyList.remove(EnemyPos);
	}
	
	public static void CreatePlayer()
	{
		Scanner reader = new Scanner(System.in);
		
		String Input;
		do
		{
			Prints.CreateNewPlayer();
			
			// New player name and class
			Input = reader.next();
			if(Input.toLowerCase().equals("end"))
			{
				//System.out.println("broke name");
				break;
			}
			String Name = Input;
			do
			{
				Input = reader.next();
			}while(!Storage.ClassList.containsKey(Input));
			String ClassName = Input;
			
			// Add new player to both player lists
			
			CreateNewPlayer(Name, ClassName);
			AddPlayer(Name);
			Prints.CreatedPlayer();
		}while(Storage.ActivePlayerList.size() < 4);
		reader.close();
	}
	
	public static void CreateNewPlayer(String Name, String ClassName)
	{
		Player Player = new Player(Name, new Class(data.Storage.ClassList.get(ClassName)));
		Storage.PlayerList.add(Player);
	}
	
	public static void AddPlayer(String Name)
	{
		Player NewPlayer = new Player(Storage.PlayerList.get(Storage.getPlayerListIndexFromName(Name)));
		Storage.ActivePlayerList.add(NewPlayer);
	}
	
	
	public static void CreateNewEnemy(String Name, String ClassName)
	{
		Enemy Enemy = new Enemy(Name, Storage.ClassList.get(ClassName));
		Storage.EnemyList.add(Enemy);
	}
	
	public static void CreateNewEnemy(String Name, Class CustomClass)
	{
		Enemy Enemy = new Enemy(Name, new Class(CustomClass));
		Storage.EnemyList.add(Enemy);
	}
	
	public static void AddEnemy(String Name)
	{
		Enemy NewEnemy = new Enemy(Storage.EnemyList.get(Storage.getEnemyListIndexFromName(Name)));
		Storage.ActiveEnemyList.add(NewEnemy);
	}
	
	
	
	public static void GenerateRandomEnemies()
	{
		int PlayerCount = Storage.ActivePlayerList.size();
		for(int i=0 ; i < PlayerCount ; i++)
		{
			int rNum = GetRandomNumber(0,Storage.EnemyList.size());
			Enemy NewEnemy = new Enemy(Storage.EnemyList.get(rNum));
			Storage.ActiveEnemyList.add(NewEnemy);
		}
	}
	
	public static int GetRandomNumber(int min, int max)
	{
		Random RandomNumber = new Random();
		int Number = min + RandomNumber.nextInt(max);
		return Number;
	}
	
	public static void HealAllPlayers()
	{
		for(Player player : Storage.ActivePlayerList)
		{
			player.CurrentStats.HP = player.Class.BaseStats.HP;
		}
	}
	
	public final static void ClearConsole()
	{
		// 20 \n's per line
	    String Clear =  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	    		+ 		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	    		+ 		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	    		+		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	    		+		"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	    System.out.println(Clear);
	}
	
}
