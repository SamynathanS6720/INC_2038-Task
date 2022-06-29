package datastructure ;

import datastructure.LinkedList;


public class Stack < K , V > {

    class Node < K , V >{    
        K key ;
        V value ;    
        Node< K , V > next;
        Node< K , V > privous ;    
            
        public Node( K key , V value ) {    
            this.key = key ;
            this.value = value ;    
            this.next = null;  
            this.privous = null ;  
        }    
    
    }   

    private Node < K ,V > top = null ;
    private LinkedList< Node< K , V > > savedTransection = new LinkedList< Node< K , V > >();
    
    private int size = 0 ;

    private Node< K , V  > getKeyIfAvailable( Node< K , V > transection ,  K key ){
        Node< K , V > temNode = transection ;
        if( transection == null ){
            return null;
        }
        do{
            if( temNode.key.equals( key )  ){
                return temNode ;
            }
            temNode = temNode.next ;
        }while( temNode != null );
        return null ;
    }

    public boolean set( K key , V value ){
 
            if( this.top == null ){
                this.top = new Node < K , V >( key , value ) ;
            }
            else{
                Node< K , V > temNode = new Node < K , V > ( key , value ) ;
                temNode.next = this.top ;    
                this.top.privous = temNode ;
                this.top = temNode;  
                this.size++;
            }
        return true ;
    }

    public V get( K key ) {

        Node< K , V > temNode =  this.getKeyIfAvailable( this.top , key );
        if( temNode != null ){
            return temNode.value ;
        }
        else{
            int i = -1 ;
            while( i < this.savedTransection.size() ){

                temNode = this.getKeyIfAvailable( this.savedTransection.get(i) , key );
                if( temNode != null ){
                    return temNode.value ;
                }
                i++ ;
            }
        }
        return null ;
    }

    public boolean unset( K key ){
        if( this.get( key ) == null ) {
            return false ;
        }
        if( this.savedTransection.size() > 0 ){
                this.set( key , null );
                return true ;
        }
        Node< K , V > temNode = this.getKeyIfAvailable( this.top , key );
        if( this.size == 1 || this.top == temNode ) {
            this.top = null ; 
            this.size--;
            return true ;
        }
        else if ( temNode == null ){
            return false ;
        }
        else{
            V value = temNode.value ;
            temNode.privous.next = temNode.next ;
            temNode.next.privous = temNode.privous ;
            this.size--;
            return true ;
        }

        // return false ;
    }

    public int count( V value ){
        Node< K , V > temNode = this.top;
        LinkedList< K > duplicateKey = new LinkedList < K >() ;
        int count = 0 ;
        while( temNode != null ){
            if( temNode.value != null && temNode.value.equals( value )  ){
                if( !duplicateKey.contains( temNode.key ) ){
                    count++ ;
                }
            }
            duplicateKey.addNode( temNode.key );/////////////
            temNode = temNode.next ;
        }

        int i = 0 ;

        while( i < this.savedTransection.size() ){
            temNode =this.savedTransection.get(i) ;
            while( temNode != null ){
                if( temNode.value != null && temNode.value.equals( value )  ){
                    if( !duplicateKey.contains( temNode.key ) ){
                        count++ ;
                        duplicateKey.addNode( temNode.key );
                    }
                }
                duplicateKey.addNode( temNode.key );/////////////
                temNode = temNode.next ;
            }
            i++ ;
        }

        return count ;
    }

    public boolean update( K key , V value ){
        Node< K , V > temNode =  this.getKeyIfAvailable( this.top , key );
        if( temNode != null ){
            this.set( key , value );
            return true ;
        }
        else{
            int i = 0 ;
            boolean flag = false ;
            while( i < this.savedTransection.size() ){

                temNode = this.getKeyIfAvailable( this.savedTransection.get(i) , key );
                if( temNode != null ){
                    flag = true ;
                    break ;
                }
                i++ ;
            }
            if( flag ){
                this.set( key , value );
                return true ;
            }

        }
        return false;
    }

    public boolean begin(){
        this.savedTransection.addNodefirst( this.top );
        this.top = null ;
        return true ;
    }

    public boolean rollBack(){
        
        this.top = null ;
        if( this.savedTransection.size() > 0 ){
            this.top = this.savedTransection.removefirst() ;
        }
        return true ; 
    }

    public boolean commit(){
        if( this.savedTransection.size() > 0  ){
            int frontNode = 0 ;
            Node< K , V > privousTransection = this.savedTransection.get( frontNode );
            if( this.top == null ){
                this.top = this.savedTransection.removefirst() ;
                return true ;
            }
            Node< K , V > currentTransection = this.top ;
            if( privousTransection == null ){
                this.savedTransection.removefirst();
                return true ;
            }

            while( currentTransection.next != null ){
                Node< K , V > temNode = this.getKeyIfAvailable( privousTransection , currentTransection.key );
                if( temNode != null ){
                    temNode.value = currentTransection.value ;
                    
                    currentTransection.privous.next = currentTransection.next ;
                    currentTransection.next.privous = currentTransection.privous ;
                }
                currentTransection = currentTransection.next ;
            }

            privousTransection = this.savedTransection.removefirst() ;
            currentTransection.next = privousTransection ;
            privousTransection.privous = currentTransection ;

            Node< K , V > temNode = this.getKeyIfAvailable( privousTransection , currentTransection.key );
            if( temNode != null ) {
                temNode.value = currentTransection.value ;
                currentTransection = currentTransection.privous ;

            }
            return true ;
        }
        else{
            return false ;
        }
        
    }
    

} 
