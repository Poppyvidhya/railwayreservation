import java.util.*;
public class TicketBooking
{
    static int availLowerBerths=1;//21
    static int availMiddleBerths=1;//21
    static int availUpperBerths=1;//21
    static int availRacTickets=1;//18
    static int availWaitingList=1;//10

    static Queue<Integer> waitingList = new LinkedList<>();
    static Queue<Integer> racList = new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    static List<Integer> lowerBerthsPosition = new ArrayList<>(Arrays.asList(1));//1,2,3,.......21
    static List<Integer> middleBerthsPosition = new ArrayList<>(Arrays.asList(1));//1,2,3,.......21
    static List<Integer> upperBerthsPosition = new ArrayList<>(Arrays.asList(1));//1,2,3,.......21
    static List<Integer> racPosition = new ArrayList<>(Arrays.asList(1));//1,2,3,.......18
    static List<Integer> waitingListPosition = new ArrayList<>(Arrays.asList(1));//1,2,3,.......10

    static Map<Integer,Passenger> passengers = new HashMap<>();,

    //book ticket
    public void bookTicket(Passenger p,int berthInfo,String allotedBerth)
    {
        p.number = berthInfo;
        p.alloted=allotedBerth;
        passengers.put(p.passengerId,p);
        bookedTicketList.add(p.passengerId);
        System.out.println("--------------------------Booked Successfully-------------------------");
    }

    //RAC
    public void addToRAC(Passenger p,int racInfo,String allotedRAC)
    {
        p.number=racInfo;
        p.alloted=allotedRAC;
        passengers.put(p.passengerId,p);
        racList.add(p.passengerId);
        availRacTickets--;
        racPositions.remove(0);
        System.out.println("--------------------------Booked to RAC Successfully-------------------------");
    }

    //WL
    public void addToWaitingList(Passenger p,int waitingListInfo,String allotedWL)
    {
        p.number=waitingListInfo;
        p.alloted=allotedWL;
        pasengers.put(p.passengerId,p);
        waitingList.add(p.passengerId);
        availwaitingList--;
        waitingListPosition.remove(0);
        System.out.println("--------------------------added to Waiting List Successfully-------------------------");
    }

    //Cancel Ticket
    public void cancelTicket(int passengerId)
    {
        Passenger p=pasengers.get(passengerId);
        passengers.remove(passengerId);
        bookedTicketList.remove(passengerId);
        int positionbooked =p.number;
        System.out.println("--------------------------Cancelled Successfully-------------------------");

        //alloting Free Tickets To WL
        if(p.alloted.equals("L"))
        {
            availLowerBerths++;
            lowerBerthsPosition.add(positionbooked);
        }
        else if(p.alloted.equals("M"))
        {
            availMiddleBerths++;
            middleBerthsPosition.add(positionbooked);
        }
        else if(p.alloted.equals("U"))
        {
            availUpperBerths++;
            upperBerthsPosition.add(positionbooked);
        },

        //for RAC
        if(racList.size()>0)
        {
            Passenger passengerfromRAC=pasengers.get(racList.poll());
            int positionRac=passengerfromRAC.number;
            racPositions.add(positionRac)



        }
    }

    //Avail Seats
    

    //Booked Tickets


}