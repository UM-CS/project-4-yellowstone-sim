package Organisms;

import Environment.*;
import java.awt.Color;
import java.awt.Graphics;

import Drivers.Sim;

public abstract class Organism{

    protected Sim sim;
    protected Environment environment;
    protected int age; 
    protected String ID;
    protected double health;
    protected Position position;
    protected boolean alive;
    protected Color color;

    public Organism(Sim sim, String ID, Environment e ,Position position, double intitialHealth, Color color)
    {
        this.sim=sim;
        environment=e;
        age=0;
        this.ID=ID;
        health = intitialHealth;
        this.position=position;
        alive=true; 
        this.color=color;
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

    public void draw(Graphics g) { 
        g.setColor(color); 
        int drawX = position.getX() * 15 + 4; 
        int drawY = position.getY() * 15 + 4; 
        // the 15 in drawsize can be changed into a variable later 
        int drawSize = 15; 
        g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10); 
        g.setColor(Color.WHITE); 
        g.drawString(ID, drawX + 2, drawY + (drawSize / 2) + 5);
    }
}