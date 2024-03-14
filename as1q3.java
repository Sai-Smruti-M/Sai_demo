class point
{
public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
int x;
int y;
point(int x,int y)
{
    this.x=x;
    this.y=y;
    
}
public point(point oldp)
{
    this.x=oldp.getX();
    this.y=oldp.getY();
}
}
public class as1q3 
{
    public static void main(String[] args) 
    {
        point old=new point(2,3);
        point newp=new point(old);
        System.out.println(newp.getX()+","+newp.getY());
    }
}
