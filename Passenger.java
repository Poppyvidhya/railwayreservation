public class Passenger
{
    static int id=1;
    String name;
    int age;
    String berth;
    int passengerId;
    String alloted;
    int number;
    public Passenger(String name,int age,String berth)
    {
        this.name=name;
        this.age=age;
        this.berth=berth;
        this.passengerId=id++;
        alloted=" ";
        number=-1;   
    }
}