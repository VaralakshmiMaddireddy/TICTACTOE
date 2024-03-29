package player;

public class Player {
    String name,address,email;
    int age;
    String contactNumber;
    char symbol;
    public Player(String name,int age,String address,String contactNumber,String email,char symbol){
        this.name=name;
        this.age=age;
        this.address=address;
        this.contactNumber=contactNumber;
        this.email=email;
        this.symbol=symbol;
    }
    public String Playername(){
        return this.name;
    }
    public char getPlayerSymbol(){
        return this.symbol;    }
    public void getData(){
        System.out.println("Name:"+this.name);
        System.out.println("age:"+this.age);
        System.out.println("address:"+this.address);
        System.out.println("contact number:"+this.contactNumber);
        System.out.println("email id:"+this.email);
        System.out.println("symbol:"+this.symbol);
    }
}
