package data;

import java.util.ArrayList;

import data.Unit;


public class Player extends Unit {
	
	
	public Player(String Name, Class Class) {
		super(Name, Class);
	}
	
	public Player(Player toClone)
	{
		super(toClone);
	}
	
	
	
}
