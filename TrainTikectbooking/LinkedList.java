package datastructure ;


public class LinkedList < T >{    
        
    class Node < T >{    
        private T data;    
        private Node< T > next;    
            
        public Node( T data) {    
            this.data = data;    
            this.next = null;    
        }    

        public void setData( T data ){
            this.data = data ; 
        }

        public void setNextNode( Node < T > next ){
            this.next = next ;
        }

        public T getData(){
            return this.data ;
        }

        public Node< T > getNextNode(){
            return this.next ;
        }
    }    
     
    private Node< T > head = null;    
    private Node< T > tail = null; 
    private int size = -1 ;
        
    public void addNode(T data) {    
        Node< T > newNode = new Node < T >(data);    
            
        if(this.head == null) {    
            this.head = newNode;    
            this.tail = newNode;    
            this.size++;
        }    
        else {    
            this.tail.setNextNode( newNode );    
            this.tail = newNode;   
            this.size++; 
        }    
    }    

    public void addNodefirst(T data) {    
        Node< T > newNode = new Node < T >(data);    
            
        if(head == null) {    
            this.head = newNode;    
            this.tail = newNode;  
            this.size++;  
        }    
        else {    
            newNode.setNextNode( this.head );
            this.head = newNode;  
            this.size++;  
        }    
    }   

    public void removefirst() {  
  
        if( this.head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        else {  
            if(this.head != this.tail) {  
                this.head = this.head.getNextNode(); 
                this.size--; 
            }  
            else {  
                this.head = this.tail = null;  
                this.size--;
            }  
        }  
    }  

    public T remove( int index ){
        Node< T > newNode = head;  

        for( int i = 0 ; i <= this.size ; i++ ){
            if( i == index - 1  ){
                T tem = newNode.getNextNode().getData() ;
                newNode.setNextNode( newNode.getNextNode().getNextNode() );
                return tem ;
            }
            newNode = newNode.getNextNode() ;
        }
        return null ;
    }

    public T replace( int index , T data ){
        Node< T > newNode = head;  

        for( int i = 0 ; i <= this.size ; i++ ){
            if( i == index ){
                T tem = newNode.getData() ;
                newNode.setData( data );
                return tem ;
            }
            newNode = newNode.getNextNode() ;
        }
        return null ;

    }
   
        
    public int size() { 
        return this.size+1 ;       
    }    
            
    public T get( int index ){
        Node< T > newNode = head;  

        for( int i = 0 ; i <= this.size ; i++ ){
            if( i == index ){
                return newNode.getData() ;
            }
            newNode = newNode.getNextNode() ;
        }
        return null ;
    }
          
    public boolean isEmpty(){
        if( this.size == 0 ){
            return true ;
        }
        return false ;
    }
} 