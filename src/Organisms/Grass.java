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


    public Grass(Sim sim ,String ID, Environment e,Position position, double intitialHealth) {
        Color initialColor = e.getColor();
        super(sim ,ID, e, position, intitialHealth, initialColor);
        this.color = initialColor;
    }

    @Override
    public void act(){
        color=environment.getColor();
        double x=environment.getGrowthChange();
       if(Math.random()<x && sim.organismsCount()<150)
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
       }

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
        int drawSize = 15; 
        g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10); 
        g.setColor(Color.WHITE); 
        
    }
}


