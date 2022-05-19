
package tikectbooking ;

import tikectbooking.Passenger;

public interface Tikect {

    public boolean allotBerth( Passenger passenger , String pnrNumber );
    public boolean cancelBerth( int seatNo);
    // public String getTikectType() ; 
    public Passenger remove();
    public boolean checkTikectAvailabilty();
    public int getAvailableCount() ;
    public int gertListTotalCount() ;
    public Seat getSeatDetails( int seatNo );
    public void viewBookedSeatsDetials();
    public void viewAvailableSeatsDetials();
    public boolean isEmpty(); 

}