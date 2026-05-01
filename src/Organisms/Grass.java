package Organisms;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Animals.elk;
import Drivers.Sim;
public class Grass extends Organism{

    protected Color color;
    private Random random = new Random();
    private double growthRate;
    private boolean grazed;
    private int size;
    private final int maxSize = 5;


    public Grass(Sim sim ,String ID, Environment e,Position position, double intitialHealth) {
        super(sim ,ID, e, position, intitialHealth, e.getColor());
        this.color = e.getColor();
        growthRate = 1.0;
        grazed = false;
        size = 1;
    }

    @Override
    public void act(){
        color=environment.getColor();
        double x=environment.getGrowthChange();
       if(size >= maxSize && Math.random()<x && sim.organismsCount()<250)
       {
        spread();
       }

    }
    @Override
    public void change() {
        double x=environment.getDeathChange();
         if(Math.random()<x)
       {
        perish();
        return;
       }

       grow();
    }

    private void grow(){
        if(!grazed && size < maxSize && Math.random() < environment.getGrowthChange() * growthRate)
        {
            size++;
        }
        grazed = false;
    }

    public double graze(){
        grazed = true;
        int amountEaten = Math.min(size, 2);
        size -= amountEaten;

        if(size <= 0)
        {
            perish();
        }

        return amountEaten * 10;
    }





    private void spread(){
        sim.takeBabies(new Grass(sim, "babygrass", environment, this.position.randomPosition(position, 4), health));
    }


    public String toString()
    {
       return super.toString();
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color); 
        int drawX = position.getX() * 15 + 4; 
        int drawY = position.getY() * 15 + 4; 
        // the 15 in drawsize can be changed into a variable later 
        int drawSize = 5 + (size * 2); 
        g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10); 
        g.setColor(Color.WHITE); 
        
    }
}


