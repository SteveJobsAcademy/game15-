
import java.util.Random;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author archimede
 */
public class Game15 {
    private int dimension;
    private int[][] grid;
    private int[][] gridWin;
    private int[] blankSpot;
  
    
    public enum SwipeDirection{
        // Swipe direction toward the empty cell
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
    
    public Game15(int dimension){
       this.dimension = dimension;
       this.grid = new int [dimension][dimension];
       this.gridWin = new int [dimension][dimension];
       this.reset(grid);
       this.reset(gridWin);
       this.blankSpot = new int[2];
       this.blankSpot[0]=dimension-1;
       this.blankSpot[1]=dimension-1;
    }
    
    public void reset(int[][] gridToReset){
        
        int n = 1;
        
        for(int x = 0; x < this.dimension; x++){
             for(int y = 0; y < this.dimension; y++){
                 gridToReset[x][y] = n; 
                 n++;
             }
        }
        
        gridToReset[dimension-1][dimension-1]=0;
    }

    
    public boolean checkWin(){
        for(int x = 0; x < this.dimension; x++){
            for(int y = 0; y < this.dimension; y++){
                if(this.grid[x][y]!=this.gridWin[x][y])
                    return false;
            }
        }
        return true;
    }
    
    
    
    
    @Override
    public String toString() {
        String printGrid="";
        for(int i=0;i<this.dimension;i++){
            for(int j=0;j<this.dimension;j++){
                if(this.grid[i][j]<=9) printGrid+="| "+ this.grid[i][j] + "  |";
                else printGrid+= "| "+ this.grid[i][j] + " |";            
            }
            printGrid+="\n";
        }
        return printGrid;
    }
    
    private SwipeDirection random(){
        Random random= new Random();
        int n= random.nextInt(4);
        switch(n){
            case 0:
                return SwipeDirection.UP;
            case 1:
                return SwipeDirection.DOWN;
            case 2:
                return SwipeDirection.LEFT;
            case 3:
                return SwipeDirection.RIGHT;
        }
        return null;
    }
    
    public void shuffle(int times){
        for(int i=0; i< times; i++){
            try{
                SwipeDirection dir = this.random();
                this.swipe(dir);
            }catch(Exception ex){
                 continue;
            }
        }
    }
    
    public void swipe (SwipeDirection direction) throws Exception{
        int[] slotToSwipeCoords = new int[2];
        
        switch(direction){
            case UP: {
                slotToSwipeCoords[0] = this.blankSpot[0] + 1;
                slotToSwipeCoords[1] = this.blankSpot[1];
                if (slotToSwipeCoords[0] >= dimension) throw new Exception ("NO.");
                break;
            }
            case DOWN: {
                slotToSwipeCoords[0] = this.blankSpot[0] - 1;
                slotToSwipeCoords[1] = this.blankSpot[1];
                if (slotToSwipeCoords[0] < 0) throw new Exception ("NO.");
                break;
            }
            case LEFT: {
                slotToSwipeCoords[0] = this.blankSpot[0];
                slotToSwipeCoords[1] = this.blankSpot[1] + 1;
                if (slotToSwipeCoords[1] >= dimension) throw new Exception ("NO.");
                break;
            }
            case RIGHT: {
                slotToSwipeCoords[0] = this.blankSpot[0];
                slotToSwipeCoords[1] = this.blankSpot[1] - 1;
                if (slotToSwipeCoords[1] < 0) throw new Exception ("NO.");
                break;
            }
        }
        
        this.grid[blankSpot[0]][blankSpot[1]] = this.grid[slotToSwipeCoords[0]][slotToSwipeCoords[1]];
        this.grid[slotToSwipeCoords[0]][slotToSwipeCoords[1]] = 0;
        this.blankSpot[0] = slotToSwipeCoords[0];
        this.blankSpot[1] = slotToSwipeCoords[1];
    }
}
