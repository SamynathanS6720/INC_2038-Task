
import java.util.Scanner;
import datastructure.Stack;
import datastructure.LinkedList;

public class SystemDesign{

    enum Commends{
        GET, SET, UNSET, COUNT, UPDATE , ROLLBACK, BEGIN , COMMIT
    }

    public static void process() {
        
        Stack < String , String > dataList = new Stack< String , String >();
        Scanner reader = new Scanner(System.in);
        String value ;
        String variable ;
        do{
            String commend = reader.next();
            try{
                Commends func = Commends.valueOf( commend );
                switch ( func ) {
                    case GET:
                        variable = reader.next();
                        System.out.println( dataList.get( variable ) );
                        break;
                    case SET :
                        variable = reader.next();
                        value = reader.next(); 
                        System.out.println( dataList.set( variable , value )? "value set to variable" : ""  ) ;
                        break ;
                    case UNSET :
                        variable = reader.next();
                        System.out.println( dataList.unset( variable )? "Updated"  : ( "No variable named " + "\"" + variable + "\"" )  );
                        break ;
                    case COUNT :
                        value = reader.next(); 
                        System.out.println( dataList.count( value ) > 0 ? "Count " +   dataList.count( value )  : null );
                        break ;
                    case UPDATE :
                        variable = reader.next();
                        value = reader.next();
                        if( !dataList.update( variable , value ) ) {
                            System.out.println(" No variable named " + "\"" + variable + "\"" );
                        }else{
                            System.out.println("updated" );
                        }
                        // System.out.println( dataList.update( variable , value ) );
                        break ;
                    case BEGIN :
                        dataList.begin() ;
                        break ;
                    case COMMIT :
                        dataList.commit() ;
                        System.out.println( "\nRecent Transections are Saved" );
                        break ;
                    case ROLLBACK :
                        dataList.rollBack();
                        System.out.println( "\nRecent Transections are deleted" );
                        break ;
                }
            }catch( IllegalArgumentException ex ){
                System.out.println( "\nEnter valid commend");
                continue ;
            }
        }while( true );
   
    }

    public static void main( String[] args ){
        System.out.println( "Enter commend " );
        SystemDesign.process() ;
    }

}
