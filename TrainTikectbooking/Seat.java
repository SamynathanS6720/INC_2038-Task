package tikectbooking ;

import datastructure.LinkedList ;
import datastructure.Queue ;
import tikectbooking.Passenger ;
// import _____.SeatConfermation ;

public class Seat{
 
    private Passenger passenger ;
    private boolean availabe ;
    private int seatNo ;
    private String berthType ;
    private String pnrNumber ;

    public Seat( int seatNo , String berthType ){
        this.seatNo = seatNo ;
        this.availabe = true ;
        this.berthType = berthType ;
    }

    public boolean allotBerthToPassenger ( Passenger passenger , String pnrNumber ){
        this.passenger = passenger ; 
        this.passenger.setSeatNo( this.seatNo );
        this.passenger.setPNRnumber( pnrNumber );
        this.passenger.setBerthType( this.berthType );
        this.pnrNumber = pnrNumber ;
        this.availabe = false ;
        return true ;
    }

    public Passenger cancelBerth(){
        Passenger tem = this.passenger ;
        this.pnrNumber = "" ;
        this.passenger = null ;
        this.availabe = true ;
        return tem ;
    }

    public boolean checkSeatDetails(){
        if( this.passenger == null ){
            return false ;
        }
        return true ;
    }

    public boolean isSeatAvailable() {
        return this.availabe ; 
    }

    public Passenger getPassengerDetils(){
        return this.passenger ;
    }

    public int getSeatNo(){
        return this.seatNo ;
    } 

    public String getBerthType(){
        return this.berthType ;
    }

    public String getPNRNumber( ){
        return this.pnrNumber ;
    }

    public void viewSeatdeails(){
        if( !this.availabe ){
            // System.out.print( this.pnrNumber + "\t") ;
            this.passenger.display() ;
        }
        else{
            System.out.println( "\n" +  this.berthType + seatNo ) ;
            System.out.println( "Status : Available \n") ;
        }
    }
}