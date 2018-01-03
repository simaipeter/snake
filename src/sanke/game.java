/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import search.AbstractState;
import search.State;

/**
 *
 * @author SPL
 */
public class game extends AbstractState {

    game() {
        
    }

    public game(ArrayList<Integer> palya) {
        this.palya = palya;
    }
    
    game(game om) {
        super(om);
    }
    
    game(game om, int x, int y) {
        super(om);
        Snake.move(x, y);
    }
    ArrayList<Integer> palya;
    snake Snake = new snake();
    
    public boolean isValidMove() {
        int valid = 1;
        if ( palya.get(Snake.mySnake.get(0).x+Snake.mySnake.get(0).y*13) != 1 ) {
            valid++;
        }
        for ( int a = 1; a < Snake.mySnake.size(); a++) {
            if ( Snake.mySnake.get(0).x == Snake.mySnake.get(a).x && Snake.mySnake.get(0).y == Snake.mySnake.get(a).y ) {
                valid++;
            }
        }
        if ( valid == 1 ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    public class snake {
        
        ArrayList<gameObject> mySnake;

        public snake() {
            
            mySnake = new ArrayList<>();
            
        }

        public snake(ArrayList<gameObject> mySnake) {
            this.mySnake = new ArrayList<>();
            for ( int a = 0; a < mySnake.size(); a++) 
                
            
            this.mySnake.add(new gameObject(mySnake.get(a).x, mySnake.get(a).y));
        }
        
        public void move(int x, int y) {
            //0 a fej
            int HEAD = 0;
            mySnake.get(HEAD).move(x, y);
            for ( int a = 1; a < mySnake.size(); a++ ) {
                mySnake.get(a).move(mySnake.get(a-1).x, mySnake.get(a-1).y);
            }
        }
        
        
        public class gameObject {
            int x;
            int y;
            int prevX;
            int prevY;

            public gameObject() {
                
            }
            
            

            public gameObject(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getPrevX() {
                return prevX;
            }

            public int getPrevY() {
                return prevY;
            }

            public void move(int x, int y) {
                prevX = this.x;
                prevY = this.y;
                this.y = y ;
                this.x = x;
            }
            
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean equals(Object obj) {
                if ( obj.getClass() == gameObject.class && obj != null ) {
                    gameObject m = (gameObject)obj;
                    if ( x == m.x && y == m.y ) {
                        return true;
                    }
                }
                return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int hashCode() {
                return new String(mySnake.toString()).hashCode();
                 //return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
            }
            
            
            
            
            
        }
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if ( obj.getClass() == game.class && obj != null ) {
            //return obj.hashCode() == hashCode();
        }
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDistance() {
        return super.getDistance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getHeuristic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getParent() {
        return super.getParent(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        Set<State> move;
        move = new HashSet<State>();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        game state = new game(this, 1, 0);
        if ( state.isValidMove() ) {
            move.add(state);
        }
        state = new game(this, -1, 0);
        if ( state.isValidMove() ) {
            move.add(state);
        }
        state = new game(this, 0, 1);
        if ( state.isValidMove() ) {
            move.add(state);
        }
        state = new game(this, 0, -1);
        if ( state.isValidMove() ) {
            move.add(state);
        }
        
        return move;
    }

    @Override
    public boolean isSolution() {
        if ( palya.get(Snake.mySnake.get(0).x+Snake.mySnake.get(0).y*13) != 1 ) {
            return true;
        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new String(Snake.toString()).hashCode();
        /*return super.hashCode(); //To change body of generated methods, choose Tools | Templates.*/
    }
    
    

    /**
     * @param args the command line arguments
     */ /*
    public static void main(String[] args) {
        // TODO code application logic here
        gui gui = new gui();
        gui.main(args);
    }*/
    
    
    
}
