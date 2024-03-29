import board.Board;
import player.Player;
import game.Game;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("first project->ticyactoe");
        Board b=new Board(3);
        b.setDefault('-');
        b.printBoardconfig();
        Scanner scn=new Scanner(System.in);
        System.out.println("please enter name");
        String name=scn.next();
        System.out.println("please enter address");
        String address=scn.next();
        System.out.println("please enter age");
        int age=scn.nextInt();
        System.out.println("please enter contact");

        String contactNumber=scn.next();
        System.out.println("please enter email");
        String email=scn.next();
        System.out.println("please enter symbol");
        char symbol=scn.next().charAt(0);
        
        
        Player p1= new Player(name,age,address,contactNumber,email,symbol);
        p1.Playername();
        p1.getData();
        Player p2=new Player("raju",20,"vijayawada","9949515979","raju@gmail.com",'0');
        p2.Playername();
        p2.getData();

        Game g=new Game(new Player[]{p1,p2}, b);
        g.play();

    } 

}
