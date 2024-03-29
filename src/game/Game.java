package game;
import player.Player;

import java.util.Scanner;

import board.Board;

public class Game {
    
    Player [] player;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameover;
   
    String zero;
    String cross;

public Game(Player[] player,Board board){
    this.player=player;
    this.board=board;
    this.turn=0;
    this.noOfMoves=0;
    this.gameover=false;

    StringBuilder z=new StringBuilder();
    StringBuilder c=new StringBuilder();

    for(int i=0;i<board.size;i++){
        z.append('0');
        c.append('x');
    }
    this.zero=z.toString();
    this.cross=c.toString();
}
public void printBoardconfig(){
    int sz=this.board.size;
    for(int i=0;i<sz;i++){
        for(int j=0;j<sz;j++){
            System.out.print(board.matrix[i][j]+" ");
        }
        System.out.println();
    }
}
public void play(){
    printBoardconfig();
    int sz=board.size;
    while(!gameover){
    noOfMoves++;
    int ind=getIndex();
    int row=ind/sz;
    int col=ind%sz;
    board.matrix[row][col]=player[turn].getPlayerSymbol();

    if(noOfMoves>=sz*sz){
        System.out.println("draw");
        return;
    }
    if(noOfMoves>=2 && checkCombinations()==true){
        gameover=true;
        printBoardconfig();
        System.out.println("winner is:"+player[turn].Playername());
        return;
    }
    turn =(turn+1)%2;
    printBoardconfig();
    }
}
public int getIndex(){
    while(true){
        System.out.println("player:"+player[turn].Playername() +" give one position");
        Scanner sn=new Scanner(System.in);
        int pos=sn.nextInt()-1;

        int sz = board.size;

        int row=pos/sz;
        int col=pos%sz;

        if(row<0 || row>=sz ||col<0 ||col>=sz){
            System.out.println("invalid position");
            continue;
        }
        if(board.matrix[row][col]!='-'){
            System.out.println("position is already occupied");
            continue;
        }

        return pos;

    }

}
public boolean checkCombinations(){
    int sz=board.size;

    for(int i=0;i<sz;i++){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<sz;j++){
            sb.append(board.matrix[i][j]);
        }
        String pattern=sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross)){
            return true;
        }
    }

    for(int i=0;i<sz;i++){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<sz;j++){
            sb.append(board.matrix[j][i]);
        }
        String pattern=sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross)){
            return true;
        }
    }
    int i=0,j=0;
    StringBuilder sb=new StringBuilder();
    while(i<sz){
        sb.append(board.matrix[i][j]);
        i++;
        j++;
    }
    String pattern=sb.toString();
    if(pattern.equals(zero)||pattern.equals(cross)){
        return true;
    }
    i=0;
    j=sz-1;
    sb=new StringBuilder();
    while(i<sz){
        sb.append(board.matrix[i][j]);
        i++;
        j--;
    }
    pattern=sb.toString();
    if(pattern.equals(zero)||pattern.equals(cross)){
        return true;
    }
    return false;

}
}