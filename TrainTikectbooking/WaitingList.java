package tikectbooking;

import tikectbooking.Passenger;
import tikectbooking.Seat; 
import datastructure.Queue ;
import tikectbooking.Tikect ;

public class WaitingList implements Tikect { 

    private static Queue < Seat > waitingList ;// = new Queue < Tickets >() ;
    private int availabeCount ;
    private int waitingListCount ;

    public WaitingList( int waitingListCount ){
        this.waitingListCount = waitingListCount;
        this.availabeCount = waitingListCount ;
        this.createWaitingList( waitingListCount);
    }

    private boolean createWaitingList( int waitingListCount ){
        this.waitingList = new Queue< Seat >( waitingListCount ) ;
        for( int i = 1 ; i <= waitingListCount ; i++ ){
            Seat tem = new Seat( i , "waitingList" );
            this.waitingList.offer( tem );
        }
        return true ;
    }

    public boolean allotBerth ( Passenger passenger , String pnrNumber ){
        if( this.availabeCount > 0 ){
            for( int i = 0 ; i < this.waitingListCount ; i++ ){
                if( this.waitingList.get( i ).isSeatAvailable() ){
                    this.waitingList.get( i ).allotBerthToPassenger( passenger , pnrNumber ) ;
                    this.availabeCount-- ;
                    return true ;
                }
            }
        }
        return false ;
    }

    public boolean isEmpty(){
        if( ( this.waitingListCount ) == this.availabeCount ){
            return true ;
        }
        return false;
    }

    public boolean cancelBerth( int seatNo ){
        if( this.waitingList.get( seatNo ).checkSeatDetails() ){
            Passenger cancelTiket = this.waitingList.get( seatNo ).getPassengerDetils() ;
            this.waitingList.get( seatNo ).cancelBerth() ;
            this.availabeCount++;  
            return true ; 
        }
        return false ;
    }

    public Passenger remove(){
        Passenger passenger = this.waitingList.poll().getPassengerDetils() ;
        Seat tem = new Seat( this.waitingListCount - 1  , "RAC" );
        this.waitingList.offer( tem );
        return passenger  ;
    }

    // public String getTikectType(){
    //     return " WaitingList " ;
    // }

    public int gertListTotalCount(){
        return this.waitingListCount ;
    }

    public int getAvailableCount(){
        return this.availabeCount ;
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
       return this.waitingList.get( seatNo ) ;    
    }

    public boolean increaseWaitingListCount( int newCount ){
        this.waitingListCount = newCount ;
        this.createWaitingList( this.waitingListCount );
        return true ;
    }

    public void viewBookedSeatsDetials(){
        for( int i = 0 ; i < this.waitingListCount  ; i++ ){
            if( !  waitingList.get( i ).isSeatAvailable() ){
                waitingList.get( i ).viewSeatdeails() ;
            }
        }
    }

    public void viewAvailableSeatsDetials(){
        for( int i = 0 ; i < this.waitingListCount ; i++ ){
            if( waitingList.get( i ).isSeatAvailable() ){
                waitingList.get( i ).viewSeatdeails() ;
            }
        }
    }
}