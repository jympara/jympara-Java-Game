package main;

import data.Player;
import data.Storage;
import main.Prints;
import java.util.Scanner;


public class Start {

	public static void main(String[] args) {
		LoadAll();
		
		Scanner Input = new Scanner(System.in);
		Prints.Welcome();
		
		Input.nextLine();
		
		Main.Process();
		
		Input.close();
	}
	
	public static void LoadAll()
	{
		Storage.LoadDefaultClasses();
		Storage.LoadDefaultPlayers();
		Storage.LoadDefaultEnemies();
		
	}

}
