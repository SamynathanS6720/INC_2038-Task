package tikectbooking;

import tikectbooking.Seat; 
import datastructure.LinkedList;
import datastructure.Queue ;
import tikectbooking.Tikect ;
// import tikectbooking.SeatConfermation ;

public class CreateTiketsList implements Tikect {

    private static LinkedList < Seat > berthList  ;//= new LinkedList < Seat > () ;
    private int berthCount ;
    private int sideBerthCount ;
    private int availabeCount ;

    public CreateTiketsList(int berthCount , int sideBerthCount ){
        this.berthCount = berthCount ;
        this.sideBerthCount = sideBerthCount ;
        this.availabeCount = berthCount + sideBerthCount  ;
        this.createBerthTikets( berthCount  , sideBerthCount );
    }

    private boolean createBerthTikets( int berthCount , int sideBerthCount){
        this.berthList  = new LinkedList < Seat > () ;
        for( int i = 1 ; i <= this.berthCount ; i++ ){
            String berth = new String();
            switch( i % 3 ){
                case 1:
                    berth = "Lower berth" ;
                    break;
                case 2 :
                    berth = "Middle berth" ;
                    break; 
                case 0 : 
                    berth = "Upper berth" ;
                    break;
            } 
            Seat tem = new Seat( i , berth );
            this.berthList.addNode( tem ); 
        }
        for( int i = berthCount + 1 ; i <= ( berthCount + sideBerthCount ) ; i++ ){
            Seat tem = new Seat( i , "Side Upper" ); 
            this.berthList.addNode( tem );
        }
        return true; 
    }

    public boolean isEmpty(){
        if( ( this.berthCount + this.sideBerthCount ) == this.availabeCount ){
            return true ;
        }
        return false ;
    }

    public boolean allotBerth( Passenger passenger , String pnrNumber ){
        if( this.availabeCount > 0 ){
            for( int i = 0 ; i <  berthCount + sideBerthCount ; i++ ){
                if( this.berthList.get( i ).isSeatAvailable() ){
                    this.berthList.get( i ).allotBerthToPassenger( passenger , pnrNumber ) ;
                    this.availabeCount--;
                    return true ;
                }
            }
        }
        return false ;
    }

    public boolean cancelBerth( int seatNo ){
        if( this.berthList.get( seatNo ).checkSeatDetails() ){
            Passenger cancelTiket = this.berthList.get( seatNo ).getPassengerDetils() ;
            this.berthList.get( seatNo ).cancelBerth() ;
            this.availabeCount++ ;
            return true ;
        }
        return false ;
    }

    // public String getTikectType(){
    //     return " Conformed Tikect "; 
    // }

    public Passenger remove(){
        return null;
    }
    public boolean checkTikectAvailabilty(){
        if( this.availabeCount > 0 ){
            return true ;
        }
        else{
            return false ;
        }
    }

    public int getAvailableCount(){
        return this.availabeCount ;
    }

    public int gertListTotalCount( ){
        return this.berthCount ;
    }

    public Seat getSeatDetails( int seatNo ){
        return this.berthList.get( seatNo ) ; 

    }

    public void viewBookedSeatsDetials(){
        for( int i = 0 ; i < this.berthCount + this.sideBerthCount ; i++ ){
            if( !this.berthList.get( i ).isSeatAvailable() ){
                this.berthList.get( i ).viewSeatdeails() ;
            }
        }
    }

    public void viewAvailableSeatsDetials(){
        for( int i = 0 ; i < this.berthCount + this.sideBerthCount ; i++ ){
            if( this.berthList.get( i ).isSeatAvailable() ){
                this.berthList.get( i ).viewSeatdeails() ;
            }
        }
    }

}