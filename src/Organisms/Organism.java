package Organisms;

import Environment.*;

import Drivers.Sim;

public abstract class Organism{

    protected Sim sim;
    protected Environment environment;
    protected int age; 
    protected String ID;
    protected double health;
    protected Position position;
    protected boolean alive;



    public Organism(Sim sim2,String ID, Environment e ,double intitialHealth)
    {
        this.sim=sim2;
        environment=e;
        age=0;
        this.ID=ID;
        health = intitialHealth;
        position=null;
        alive=true; 
    }

    public void perish()
    {
        alive=false;
        System.out.println(ID+" died");
    }

    public boolean isAlive()
    {
        return alive;
    }

    public abstract void act();

    public abstract void change();

    public Position getPosition() { 
    return position; 
    }

    @Override
public String toString() {
    return String.format("[%s] Age: %d | Health: %.1f | Pos: %s | Alive: %s",
        ID, age, health,
        position != null ? position.toString() : "None",
        alive ? "Yes" : "No");
}

  public String getID()
    {
        return ID;
    }
}