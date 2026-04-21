package Environment;

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

public double distaceTo(Position other)
{
    int dx = other.getX() - this.x;
    int dy = other.getX() - this.y;
    double dist = Math.sqrt(dx*dx + dy*dy);
    return dist;

}
}
