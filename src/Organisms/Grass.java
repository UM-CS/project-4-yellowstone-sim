package Organisms;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Drivers.Sim;
public class Grass extends Organism{

    private boolean isGrazed;
    protected Color color;
    private Random random = new Random();


    public Grass(Sim sim ,String ID, Environment e,Position position, double intitialHealth) {
       
        super(sim ,ID, e, position, intitialHealth, Color.GREEN);
        color=Color.GREEN;
        isGrazed=false;
        
    }

    @Override
    public void act(){
        double x=environment.getGrowthChange();
       if(random.nextDouble(x)>1 && !isGrazed)
       {
        spread();
       }
       else if(random.nextDouble(x)>1 &&  isGrazed)
       {
        grow();
       }
    }
    @Override
    public void change() {
        double x=environment.getHungerMultiplier();
         if(random.nextDouble(x)>.9)
       {
        perish();
       }
    }

    private void grow()
    {
         isGrazed=false;
        changeColor(Color.GREEN);
    }

    private void spread(){
        System.out.println("spread");
        sim.takeBabies(new Grass(sim, "babygrass", environment, this.position.randomPosition(position, 4), health));
    }
    public void graze()
    {
        
        isGrazed=true;
        changeColor(Color.WHITE);

    }
    public boolean isGrazed()
    {
        return isGrazed;
    }
    
    public String toString()
    {
       return super.toString()+ String.format(" | Grazed: %b ", isGrazed);
        
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


