package Environment;

import java.util.Random;

import Organisms.Organism;

public class Position {
private int x;
private int y;

public Position(int x,int y)
{
    this.x=x;
    this.y=y;
}



public int getX()
{
    return x;
}
public int getY()
{
    return y;
}

public Position randomPosition(Position currPosition, int speed)
{
    Random rand = new Random();
    int sign = rand.nextBoolean() ? 1 : -1;
    
    int x = currPosition.getX() +(sign *rand.nextInt(speed));
    sign = rand.nextBoolean() ? 1 : -1;
    int y = currPosition.getY() +(sign *rand.nextInt(speed));

    if(x>100)
    {
        x=100;
    }
     if(y>100)
    {
        y=100;
    }
    if(x<0)
    {
        x=0;
    }
     if(y<0)
    {
        y=0;
    }

   
    return new Position(Math.abs(x),Math.abs(y));
     
}


public double distaceTo(Position other)
{
    int dx = other.getX() - this.x;
    int dy = other.getY() - this.y;
    double dist = Math.sqrt(dx*dx + dy*dy);
    return dist;

}
@Override
public String toString()
{
    return  String.format(" x: %d y: %d ",
        x,y);
}

//I used claude to help with this.
public Position flee(Organism source, Organism threat, int speed) {
    
    int dx = source.getPosition().getX() - threat.getPosition().getX();
    int dy = source.getPosition().getY() - threat.getPosition().getY();

    double magnitude = Math.sqrt(dx * dx + dy * dy);
    double normalX = dx / magnitude;
    double normalY = dy / magnitude;

    int newX = (int) (source.getPosition().getX() + normalX * speed);
    int newY = (int) (source.getPosition().getY() + normalY * speed);
    
    if(newX>100)
    {
        x=100;
    }
     if(newY>100)
    {
        y=100;
    }
    if(newX<0)
    {
        x=0;
    }
     if(newY<0)
    {
        y=0;
    }

    return new Position(newX, newY);
}
}
