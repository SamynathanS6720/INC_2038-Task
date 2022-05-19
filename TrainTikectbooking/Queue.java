package datastructure ; 

import java.lang.IllegalStateException;
import datastructure.LinkedList;
// import java.util.List;

public class Queue< T > {

    private int size ;
    private int front = -1 ;
    private int rear = -1 ;
    private LinkedList< T > QueueArray ;
    
    public Queue(){
        new Exception(" Need to declare the stack size ").printStackTrace() ;
    }

    public Queue( int size ){
        this.size = size ;
        this.QueueArray = new LinkedList< T >( );
    }

    public boolean add( T element ){
        if( this.offer( element ) ) {
            return true;
        }
        else{
            new IllegalStateException("Queue full ").printStackTrace() ;
            return false;
        }
        
    }

    public boolean offer( T element ){
        if( this.rear + 1 >= this.size){
            return false ;
        }
        else{
            this.QueueArray.addNode( element );
            this.front = 0 ; 
            this.rear = this.rear + 1 ;
            return true ;
        }
    }
    
    public T get( int index ){
        return this.QueueArray.get( index );
    }

    public T element(){
        if( this.peek() == null ){
            new IllegalStateException().printStackTrace();
            return null ;
        }
        else{
            return this.peek();
        }
    }

    public T peek(){
        if( this.front == -1 ){
            return null ;
        }
        else{
            return this.QueueArray.get( this.front ) ;
        }      
    }

    public T poll(){
        T dequeue = this.peek();
        if( dequeue != null ){
            this.QueueArray.removefirst( );
            if( this.front == this.rear ){
                this.front = -1;
                this.rear = -1 ;
            }
            else{
                this.rear = this.rear - 1 ;
            }
            return dequeue ;
        }
        return dequeue ;
    }

    public T replace( int index , T data ){
        T tem = QueueArray.get( index ) ;
        QueueArray.replace(index, data );
        return tem ;
    }

    public T remove(){
        T dequeue = this.poll();
        if( dequeue == null ){
            new IllegalStateException().printStackTrace();
            return null ;
        }
        else{
            return dequeue ;
        }
    }

    public int size(){
        return this.rear ;
    }

}
