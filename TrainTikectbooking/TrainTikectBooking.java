
import java.io.BufferedReader;
import java.io.InputStreamReader ;
import java.io.IOException;

import tikectbooking.Tikect; 
import tikectbooking.CreateTiketsList;
import tikectbooking.RACList;
import tikectbooking.WaitingList ;
import tikectbooking.Passenger;
import tikectbooking.BookingMethods;

public class TrainTikectBooking{

    public static void main( String[] args ) throws IOException{
        BufferedReader reader = new BufferedReader ( new InputStreamReader( System.in ) ) ;
        BookingMethods tikect = new BookingMethods();
        boolean flag = true ;

        do{
            System.out.println( "\nEnter Option" );
            System.out.println( "1. Book Tikect \t 2. Cancel Tiket " );
            System.out.println( "3. View Booked Seats \t  4. View Available Seats ");
            System.out.println( "5. View Canceled Tikects ");
            System.out.println( "6. Exit " );
            switch( reader.readLine() ){
                case "1" :
                    tikect.BookSeat(); 
                    break;
                case "2" :
                    tikect.cancelSeat() ;
                    break;
                case "3":
                    tikect.viewFilledSeats();
                    break; 
                case "4" :
                    tikect.viewAvailablity();
                    break;
                case "5" :
                    tikect.viewCanceledTikects();
                    break;
                case "6":
                    flag = false ;
                    break;
            }
            if( !flag ){
                System.out.println( "Sesion Experied" );
            }
        }while( flag );

    }

}