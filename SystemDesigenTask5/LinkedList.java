package datastructure ;


public class LinkedList < T >{    
        
    class Node < T >{    
        T data;    
        Node< T > next;    
            
        public Node( T data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    public Node< T > head = null;    
    public Node< T > tail = null; 
    private int size = -1 ;
        
    public void addNode(T data) {    
        Node< T > newNode = new Node < T >(data);    
            
        if( this.head == null) {    
            this.head = newNode;    
            this.tail = newNode;    
            this.size++;
        }    
        else {    
            this.tail.next = newNode;    
            this.tail = newNode;   
            this.size++; 
        }    
    }    

    public void addNodefirst(T data) {    
        Node< T > newNode = new Node < T >(data);    
            
        if( this.head == null) {    
            this.head = newNode;    
            this.tail = newNode;  
            this.size++;  
        }    
        else {    
            newNode.next = this.head;    
            this.head = newNode;  
            this.size++;  
        }    
    }   

    public T removefirst() {  
  
        if( this.head == null) {  
            return null ;  
        }  
        else {  
            T removedData = this.head.data ;
            if( this.head != this.tail) {  
                this.head = this.head.next; 
                this.size--; 
            }  
            else {  
                this.head = tail = null;  
                this.size--;
            }  
            return removedData ;
        }  
    }  
  
        
    public int size() { 
        return this.size+1 ;       
    }    
            
    public T get( int index ){
        Node< T > newNode = head;  
        if( this.head == null ){
            return null ;
        }
        for( int i = 0 ; i <= this.size ; i++ ){
            if( i == index ){
                return newNode.data ;
            }
            newNode = newNode.next ;
        }
        return null ;
    }

    public boolean contains( T data ){
        Node< T > newNode = head;  
        if( this.head == null ){
            return false ;
        }
        for( int i = 0 ; i <= this.size ; i++ ){
            if( newNode.data.equals( data ) ){
                return true ;
            }
            newNode = newNode.next ;
        }
        return false ;

    }
          
} 