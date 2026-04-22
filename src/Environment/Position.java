package Environment;

import java.util.Random;

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

   
    return new Position(Math.abs(x),Math.abs(y));
     
}


public double distaceTo(Position other)
{
    int dx = other.getX() - this.x;
    int dy = other.getX() - this.y;
    double dist = Math.sqrt(dx*dx + dy*dy);
    return dist;

}
@Override
public String toString()
{
    return  String.format(" | x: %d | y: %d ",
        x,y);
}
}
