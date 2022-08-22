/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snake;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tiegancozzie
 */
public class Snake {
    
    int score=0;
    int Sx=10;
    int Sy=10;
    Random rand=new Random();
    String[][] board= new String[20][20];
    int foodx = rand.nextInt(0,20);
    int foody = rand.nextInt(0,20);

    
    public void generateBoard(){
        for(var y=0;y<board.length;y++){
            for(var x=0;x<board.length;x++){
                if(board[y][x]!="O"){
                board[y][x]=".";
                }
            }
        }
        board[Sy][Sx]="S";
        board[foody][foodx]="X";
        for(var y=0;y<board.length;y++){
          for(var x=0;x<board.length;x++){
              System.out.print(board[y][x]);
          }
          System.out.println();
        }      

        System.out.println("Score: "+score+"    Direction: ");
        
        
    }
    
    public void up(){
        board[Sy][Sx]="O";
        Sy-=1;
        if(legalMove()==true){
          foodCheck();
          play();  
        } 
    }
    
    public void left(){
        board[Sy][Sx]="O";
        Sx-=1;
        if(legalMove()==true){
          foodCheck();
          play();  
        }
    }
    
    public void down(){
        board[Sy][Sx]="O";
        Sy+=1;
        if(legalMove()==true){
          foodCheck();
          play();  
        }
    }
    
    public void right(){
        board[Sy][Sx]="O";
        Sx+=1;
        if(legalMove()==true){
          foodCheck();
          play();  
        }
    }
    
    public boolean legalMove(){
        if(Sy<0 || Sy>19 || Sx<0 || Sx>19){
            System.out.println("YOU HIT THE WALL, GAME OVER");
            return false;
        }else if(board[Sy][Sx]=="O"){
            System.out.println("YOU HIT YOURSELF, GAME OVER");
            return false;
        }else{
            return true;
        }
        
    }
    
    public void foodCheck(){
        if(board[Sy][Sx]==board[foody][foodx]){
            score+=1;
            while(board[Sy][Sx]==board[foody][foodx] || board[foody][foodx]=="O"){
                foodx=rand.nextInt(0,20);
                foody=rand.nextInt(0,20);
            }
        }
    }
    
    public void play(){
        Scanner move=new Scanner(System.in);
        generateBoard();
        
        String temp=move.nextLine();
        char input=temp.charAt(0);
        switch (input){
            case 'w':
                  up();  
                break;
            case 'a':
                  left();               
                break;
            case 's':
                  down();  
                break;
            case 'd':
                  right();  
                break;               
        }
        
    }
    
    public static void main(String[] args) {
        Snake game=new Snake();
        game.play();
    }
    
}
