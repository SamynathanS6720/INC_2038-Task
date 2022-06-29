package tikectbooking;

import tikectbooking.Passenger;
import tikectbooking.Seat; 
import datastructure.Queue ;
import tikectbooking.Tikect ;

public class RACList implements Tikect {
    private static Queue < Seat > racList ;//= new Queue < Tickets > () ;
    private int racCount ;
    private int availabeCount ;
    
    public RACList( int racCount ){
        this.racCount = racCount ;
        this.availabeCount = racCount ;
        this.createRACTikets( racCount );
    }

    private boolean createRACTikets( int racCount ){
        racList = new Queue< Seat >( racCount ) ;
        for( int i = 1 ; i <= racCount  ; i++ ){
            Seat tem = new Seat( i , "RAC" );
            this.racList.offer( tem );
        }
        return true ;
    }

    public boolean allotBerth( Passenger passenger , String pnrNumber ){
        if( this.availabeCount > 0 ){
            for( int i = 0 ; i < this.racCount ; i++ ){
                this.racList.get( racCount - availabeCount ).allotBerthToPassenger( passenger , pnrNumber ) ;
                this.availabeCount-- ;
                return true ;
            }
        }
        return false ;
    }

    public boolean isEmpty(){
        if( this.racCount  == this.availabeCount ){
            return true ;
        }
        return false;
    }

    // public String getTikectType(){
    //     return " RAC Tikect " ;
    // }

    public int gertListTotalCount(){
        return this.racCount ;
    }

    public int getAvailableCount(){
        return this.availabeCount ;
    }

    public boolean cancelBerth( int seatNo ){
        return false ;
    } 

    public Passenger remove(){
        Passenger passenger = this.racList.poll().getPassengerDetils() ;
        Seat tem = new Seat( this.racCount - 1  , "RAC" );
        this.racList.offer( tem );
        return passenger  ;
    }

    public boolean checkTikectAvailabilty(){
        if( this.availabeCount > 0 ){
            return true ;
        }
        else{
            return false ;
        }
    }

    public Seat getSeatDetails( int seatNo ){
        return this.racList.get( seatNo ) ;    
    }

    public void viewBookedSeatsDetials(){
        for( int i = 0 ; i < this.racCount ; i++ ){
            if( !this.racList.get( i ).isSeatAvailable() ){
                this.racList.get( i ).viewSeatdeails() ;
            }
        }
    }

    public void viewAvailableSeatsDetials(){
        for( int i = 0 ; i < this.racCount ; i++ ){
            if( this.racList.get( i ).isSeatAvailable() ){
                this.racList.get( i ).viewSeatdeails() ;
            }
        }
    }

} 