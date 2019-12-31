/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author W
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for (int x = 0; x < super.getWidth(); x++) {
            for (int y = 0; y < super.getHeight(); y++) {
                if (new Random().nextDouble() < probabilityForEachCell) {
                    turnToLiving(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (insideTheBoard(x, y) && super.getBoard()[x][y] == true) {
            return true;
        }

        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (insideTheBoard(x, y)) {
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (insideTheBoard(x, y)) {
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
       
           int num = 0;
        
        //Top left corner
        if(x == 0 && y == 0){
            if(this.isAlive(x+1, y)){
                num++;
            }
            if(this.isAlive(x, y+1)){
                num++;
            }
            if(this.isAlive(x+1, y+1)){
                num++;
            }
        } 
        //Top right corner
        else if (x == super.getWidth()-1 && y == 0){
            if(this.isAlive(x-1, y)){
                num++;
            }
            if(this.isAlive(x-1, y+1)){
                num++;
            }
            if(this.isAlive(x, y+1)){
                num++;
            }
        }
        // Bottom Left Corner
        else if (x == 0 && y == super.getHeight() -1){
            if(this.isAlive(x, y-1)){
                num++;
            }
            if(this.isAlive(x+1, y-1)){
                num++;
            }
            if(this.isAlive(x+1, y)){
                num++;
            }
        }
        //Bottom Right Corner
        else if (x == super.getWidth()-1 && y == super.getHeight()-1){
            if(this.isAlive(x, y-1)){
                num++;
            }
            if(this.isAlive(x-1, y-1)){
                num++;
            }
            if(this.isAlive(x-1, y)){
                num++;
            }
        }
        // Left Side
        
        else if( x == 0 && y != 0 && y != super.getHeight()-1){
            if(this.isAlive(x, y-1)){
                num++;
            }
            if(this.isAlive(x+1, y-1)){
                num++;
            }
            if(this.isAlive(x+1, y)){
                num++;
            }
            if(this.isAlive(x, y+1)){
                num++;
            }
            if(this.isAlive(x+1, y+1)){
                num++;
            }
        }
        // Right Side
        
        else if( x == super.getWidth()-1 && y != 0 && y != super.getHeight()-1){
            if(this.isAlive(x, y-1)){
                num++;
            }
            if(this.isAlive(x-1, y-1)){
                num++;
            }
            if(this.isAlive(x-1, y)){
                num++;
            }
            if(this.isAlive(x-1, y+1)){
                num++;
            }
            if(this.isAlive(x+1, y+1)){
                num++;
            }
        }
        else {
            if(this.isAlive(x-1, y-1)){
                num++;
            }
            if(this.isAlive(x, y-1)){
                num++;
            }
            if(this.isAlive(x+1, y-1)){
                num++;
            }
            if(this.isAlive(x-1, y)){
                num++;
            }
            if(this.isAlive(x+1, y)){
                num++;
            }
            if(this.isAlive(x-1, y+1)){
                num++;
            }
            if(this.isAlive(x, y+1)){
                num++;
            }
            if(this.isAlive(x+1, y+1)){
                num++;
            }
        }
        return num;
        
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        } else if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }
    
    public boolean insideTheBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()) { 
            return false;
        }
        
        return true;
    }
}
