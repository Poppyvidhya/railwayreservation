import java.util.*;

public class Main
{
    public static void bookTicket(Passenger p)
    {
        TicketBooking booker=new TicketBooking();
        // no ticket available
        if(TicketBooking.availWaitingList==0)
        {
            Systemy.out.println("\n No Tickets Available");
            return;
        }
        //prefered berth available
        if((p.berth.equals("L")&& TicketBooking.availLowerBerths>0)||(p.berth.equals("M")&& TicketBooking.availMiddleBerths>0)||(p.berth.equals("U")&& TicketBooking.availUpperBerths>0))
        {
            System.out.println("\n Preffered Berth Available");
            if(p.berth.equals("L"))
            {
                System.out.println("\n Lower Berth Given");
                booker.bookTicket(p,(TicketBooking.lowerBerthsPosition.get(0)),"L");
                TicketBooking.lowerBerthsPosition.remove(0);
                TicketBooking.availLowerBerths--;
            }
            else if(p.berth.equals("M"))
            {
                System.out.println("\n Middle Berth Given");
                booker.bookTicket(p,(TicketBooking.middleBerthsPosition.get(0)),"M");
                TicketBooking.middleBerthsPosition.remove(0);
                TicketBooking.availMiddleBerths--;
            }
            else if(p.berth.equals("U"))
            {
                System.out.println("\n Upper Berth Given");
                booker.bookTicket(p,(TicketBooking.upperBerthsPosition.get(0)),"U");
                TicketBooking.upperBerthsPosition.remove(0);
                TicketBooking.availUpperBerths--;
            }
        }
        //preference not available
        else if(TicketBooking.availLowerBerths>0)
        {
            System.out.println("\n Lower Birth Given");
            booker.bookTicket(p,(TicketBooking.lowerBerthsPosition.get(0)),"L");
            TicketBooking.lowerBerthsPosition.remove(0);
            TicketBooking.availLowerBerths--;
        }
        else if(TicketBooking.availMiddleBerths>0)
        {
            System.out.println("\n Middle Berth Given");
            booker.bookTicket(p,(TicketBooking.middleBerthsPosition.get(0)),"M");
            TicketBooking.middleBerthsPosition.remove(0);
            TicketBooking.availMiddleBerths--;
        }
        else if(TicketBooking.availUpperBerths>0)
        {
            System.out.println("\n Upper Berth Given");
            booker.bookTicket(p,(TicketBooking.upperBerthsPosition.get(0)),"U");
            TicketBooking.middleBerthsPosition.remove(0);
            TicketBooking.middleBerthsPosition--;
        }
        else if(TicketBooking.availRacTickets>0)
        {
            System.out.println("\n RAC available");
            booker.addToRAC(p,(TicketBooking.racPosition.get(0)),"RAC");
        }
        else if(TicketBooking.availWaitingList>0)
        {
            System.out.println("\n added to Waiting List");
            booker.addToWaitingList(p,(TicketBooking.waitingListPosition.get(0)),"WL");
        }
    }

    //cancel ticket
    public static void cancelTicket(int id)
    {
        TicketBooking booker=new TicketBooking();
        if(!booker.passengers.containsKey(id))
        {
            System.out.println("Passenger Detail Unknown");
        }
        else
        booker.cancelTicket(id);
    }


public static void main(String[] args)
{
    Scanner s=new Scanner(System.in);
    boolean loop=true;

    while(loop)
    {
        System.out.println("\n 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
        int choice=s.nextInt();
        switch(choice)
        {
            case 1:
            {
                System.out.println("\n Enter Passenger Name : ");
                String name=s.next();
                System.out.println("\n Enter Passenger Age : ");
                int age=s.nextInt();
                System.out.println("\n Enter Passenger Berth Preference(L,M or U) : ");
                String berth=s.next();
                Passenger p=new Passenger(name,age,berth);
                bookTicket(p);
            }
            break;
            case 2:
            {
                System.out.println("Enter Passenger ID to Cancel : ");
                int id=s.nextInt();
                cancelTicket(id);
            }
            break;
            case 3:
            {
                TicketBooking booker =new TicketBooking();
                booker.printAvailable();
            }
            break;
            case 4:
            {
                TicketBooking booker=new TicketBooking();
                booker.printPassenger();
            }
            break;
            case 5:
            {
                loop=false;
            }
            break;
            default:
            break;
        }
    }
}
}