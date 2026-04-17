package Organisms;

import Enviorment.*;


public abstract class Organism{

    Enviroment enviroment;
    protected int age; 
    protected String ID;
    protected double health;
    protected Position position;
    protected boolean alive;

    public Organism(Enviroment e ,double intitialHealth)
    {
        enviroment=e;
        age=0;
        ID="organism";
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


}