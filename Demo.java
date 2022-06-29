
class passenger{
    String name ;
    int age ;
    boolean gender ;
    int SeatNo ;
    String allotedBerthType ;
}

class Tikect{
    String pnrNumber ;
    String tikectStatus ; // Tikect type ( Confermed berth , RAC , waiting liDt)
    String Date ;
    String trainNumber ;
    double tikectTotalFair ; // cost for a tikect 
    Map< Integer , Passenger > passengerList ; // int SeatNumber , Passenger passenger details 
}


class Seat{
    Passenger passenger ;
    int seatNo ;
    boolean availabe ;
    String berthtype ; 
}

class TrainRequrements {

    Map< String , Tikect > tikectList ; // String PNR number 
    LinkedList< Seat > totalSeatList ;
    Queue< Tikect > racSeatList ;
    Queue< TIkect > WaitingList ;
    LinkedList< Tikect > CanceledTikectList ;

}
