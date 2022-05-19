package tikectbooking ;

import tikectbooking.Tikect ;

public class Passenger{ 
    private String name ;
    private int age ;
    private char gender ;
    private String berthType ;
    private int seatNo ;
    private String pnrNumber ;
    private Tikect tikect ; //Object indicates ticket confirmation

    public Passenger( String name , int age , char gender  ){ // , _____  ______ ){
        this.name = name ;
        this.age = age ;
        this.gender = gender ;
    }

    public void setPNRnumber( String pnrNumber ){
        this.pnrNumber = pnrNumber ;
    }

    public String getPNRnumber(){
        return this.pnrNumber ;
    }

    public void setSeatNo( int seatNo ){
        this.seatNo = seatNo ;
    }

    public int getAge(){
        return this.age ;
    }

    public void setBerthType( String berthType ){
        this.berthType = berthType ;
    }

    public String  getBerthType(){
        return this.berthType ;
    }

    public void setTiketType( Tikect tikect ){
        this.tikect = tikect ;
    }
    public Tikect getTikectType(){
        return this.tikect ;
    }

    public char getgender(){
        return this.gender;
    }  

    public int getSeatNo(){
        return this.seatNo ;
    }
    
    public void display(){
        System.out.println();
        System.out.print( this.pnrNumber + "\t" + this.name + "\t" + this.age + "\t" + this.gender + "\t" );
        System.out.print(this.berthType + " : " + (this.seatNo ) );
    }


}