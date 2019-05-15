
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author archimede
 */
public class Main {
    
    public static void main(String[] args){
        int choise;
        Game15 a = new Game15(4);
        a.shuffle(100);
        System.out.println(a);
        Scanner s= new Scanner(System.in);
        do{
            System.out.println("0. Exit \n1. Swipe \n2. Print grid");
            System.out.println("\nInsert choice: ");
            choise= s.nextInt();
            
            try{
                switch(choise){
                case 0:
                    return;
                case 2:
                    a.swipe(Game15.SwipeDirection.DOWN);
                    break;
                case 8:
                    a.swipe(Game15.SwipeDirection.UP);
                    break;
                case 4:
                    a.swipe(Game15.SwipeDirection.LEFT);
                    break;
                case 6:
                    a.swipe(Game15.SwipeDirection.RIGHT);
                    break;
                default:
                    System.out.println("Unexpected choise");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
            System.out.println(a);
            System.out.println("You win: " + a.checkWin());
        }while(choise!=0);
        
        
        /*try{
            a.swipe(Game15.SwipeDirection.DOWN);
            a.swipe(Game15.SwipeDirection.DOWN);
        } catch (Exception ex){
            System.out.println(ex);
        }
        
        System.out.println(a);*/
    }
}
