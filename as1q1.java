class car
{
    private int make;
    private String model;
    car(int make,String model)
    {
        this.make=make;
        this.model=model;
    }
    car()
    {

    }
    public int getMake() {
        return make;
    }
    public void setMake(int make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    
}
public class as1q1 
{
    public static void main(String[] args)
     {
        car c1= new car();
        car c2=new car(2,"f");
        c1.setMake(3);
        c1.setModel("f");
        System.out.println(c1.getMake());
        System.out.println(c1.getModel());

    }
}
