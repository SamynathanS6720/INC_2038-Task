package tikectbooking ;

import tikectbooking.Tikect;
import tikectbooking.Passenger;
import tikectbooking.RACList;

import java.io.BufferedReader ;
import java.io.InputStreamReader ;
import java.util.LinkedHashMap;
import java.util.Map; 
import java.io.IOException ;
import datastructure.LinkedList ;
 
public class BookingMethods {

    private static Tikect confermedTikects ; // = new CreateTiketsList( 60 , 6 );
    private static Tikect racTikects ; //= new RACList( 18 );
    private static Tikect waitingList ; //= new WaitingList( 10 );
    private static Map< String , Passenger > BookedTikets = new LinkedHashMap< String , Passenger>();
    private static LinkedList< Passenger > canceledTikets = new LinkedList< Passenger >();
    private int pnrNumber = 1 ;
    BufferedReader reader = new BufferedReader( new InputStreamReader ( System.in ) );


    public BookingMethods(){
        confermedTikects = new CreateTiketsList( 4 , 2 );
        racTikects = new RACList( 3 );
        waitingList = new WaitingList( 2 );     
    }


    private Passenger getPassengerDetils( Tikect tikect ) throws IOException{
        Passenger passenger ;
        String name ; 
        int age ;
        char gender ;
        boolean flag = false ;
            System.out.println( "\n Enter Name : " ); 
            name = reader.readLine();
        do{
            System.out.println( "\n Enter Age : " );
            try{
                age = Integer.parseInt( reader.readLine() ) ;
                flag = false ;  
            }catch( Exception ex ){
                System.out.println( "\n Enter Age in Numbers " );
                flag = true ;
                age = 0 ;
            }
        }while( flag );
        do{
            System.out.println( "\n Select Gender : \n 1. Male \t  2.Female  ");
            switch( reader.readLine() ){
                case "1" :
                    gender = 'M' ;
                    flag = false ;
                    break ;
                case "2" : 
                    gender = 'F' ;
                    flag = false ;
                    break ;
                default :
                    flag = true ;
                    gender = '0' ;
                    System.out.println("Enter Correct Option");
                    break; 
            }
        }while( flag );
        passenger = new Passenger( name , age , gender );
        passenger.setTiketType( tikect );
        return passenger ;
    }

    public boolean BookSeat ( ) throws IOException {
            Passenger passenger ;
            if( !waitingList.isEmpty() || racTikects.getAvailableCount() == 0  ){
                passenger = getPassengerDetils( waitingList );
                waitingList.allotBerth( passenger , ("PNR"+this.pnrNumber ) );
                BookedTikets.put(("PNR"+this.pnrNumber ) , passenger   );
                System.out.println("Booked : PNR number : " + "PNR"+this.pnrNumber );
                this.pnrNumber++ ;
                return true; 
            }
            else if( !racTikects.isEmpty() || confermedTikects.getAvailableCount() == 0 ){
                passenger = getPassengerDetils( racTikects );
                racTikects.allotBerth( passenger , ("PNR"+this.pnrNumber ) );
                BookedTikets.put( ("PNR"+this.pnrNumber ) , passenger  );
                System.out.println("Booked : PNR number : " + "PNR"+this.pnrNumber );
                this.pnrNumber++ ;
                return true ;
            }
            else if( confermedTikects.getAvailableCount() > 0 ){
                passenger = getPassengerDetils( confermedTikects );
                confermedTikects.allotBerth( passenger , ("PNR"+this.pnrNumber ) );
                BookedTikets.put( ("PNR"+this.pnrNumber ) , passenger  );
                System.out.println("Booked : PNR number : " + "PNR"+this.pnrNumber  + "\t" + passenger.getBerthType() + "\tSeatNo  " + passenger.getSeatNo() );
                this.pnrNumber++ ;
                return true ;
            }
            System.out.println( "\n Seats Filled " );
        return false ;
    }

    public boolean cancelSeat() throws IOException{
        System.out.println( "Enter pnrNumber : ") ;
        String pnrNumber = reader.readLine() ;
        if( BookedTikets.containsKey( pnrNumber ) ){
            int seatNo = BookedTikets.get( pnrNumber ).getSeatNo() ;
            Tikect tikectToCancel = BookedTikets.get( pnrNumber ).getTikectType() ;
            if ( tikectToCancel.cancelBerth( seatNo - 1  ) ){
                canceledTikets.addNode( BookedTikets.get( pnrNumber ) ) ;
                BookedTikets.remove( pnrNumber );
                System.out.println( "\nTikect Canceled " );
                if( !racTikects.isEmpty() ){
                   Passenger passenger = racTikects.remove();
                   passenger.setSeatNo( seatNo-1 );
                   passenger.setTiketType( confermedTikects );
                   confermedTikects.allotBerth( passenger , passenger.getPNRnumber() ); 
                }
                if( !waitingList.isEmpty() ){
                    Passenger passenger = waitingList.remove();
                    passenger.setSeatNo( racTikects.gertListTotalCount() - 1   );
                    passenger.setTiketType( racTikects );
                    racTikects.allotBerth( passenger , passenger.getPNRnumber() );  
                }
            }
            else{
                System.out.println( "\nTikect Cancelation Failed , RAC tikect cannot able to Cancel");
            }
        }
        else{
            System.out.println( "\nEnter Valid PNR Number \n" ) ;
        }

        return false; 
    }

    public static void viewFilledSeats( ){
        if( !confermedTikects.isEmpty() )
            confermedTikects.viewBookedSeatsDetials();
        if( !racTikects.isEmpty() )
            racTikects.viewBookedSeatsDetials();
        if( !waitingList.isEmpty() )
            waitingList.viewBookedSeatsDetials();
        if( confermedTikects.isEmpty() && racTikects.isEmpty() && waitingList.isEmpty() ){
            System.out.println( "No Seats are filled" );
        }
    }

    public static void viewAvailablity(){
        // if( confermedTikects.isEmpty() )
            confermedTikects.viewAvailableSeatsDetials();
        if( racTikects.isEmpty() )
            racTikects.viewAvailableSeatsDetials();
        if( waitingList.isEmpty() )
            waitingList.viewAvailableSeatsDetials();        
    }

    public static void viewCanceledTikects(){
        if( canceledTikets.isEmpty() ){
            System.out.println("No Tikects are Canceled" ); 
        }
        for( int i = 0 ; i < canceledTikets.size() ; i++ ){
            canceledTikets.get( i ).display();
        }
    }

}