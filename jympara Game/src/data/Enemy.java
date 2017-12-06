package data;

import data.Class;


public class Enemy extends Unit {
	
	
	public Enemy(String Name, Class Class) {
		super(Name, Class);
	}
	
	public Enemy(Enemy toClone)
	{
		super(toClone);
	}
	
	
}
