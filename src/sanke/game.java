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
    int hol;
    gui gui;
    public game(ArrayList<Integer> palya, gui gui) {
        this.palya = gui.palya;
        hol = gui.cel;
        this.gui = gui;
        for ( int a = 0; a < palya.size(); a++) {
            if ( palya.get(a) >= 4 ) {
                Snake.mySnake.get(palya.get(a)-4).x = a%13;
                Snake.mySnake.get(palya.get(a)-4).y = a/13;
            }
        }

    }
    
    /*game(game om) {
        super(om);
    }*/
    
    game(game om) {
        super(om);
        this.gui = om.gui ;
 
        this.Snake = new snake(om.Snake.mySnake);
        this.palya = om.palya;
        
        //Snake.move(x, y);
    }
    ArrayList<Integer> palya;
    snake Snake = new snake();
    
    public boolean isValidMove() {
        int valid = 1;
        
        //Snake.moveTest(hol, hol)
        
        if ( valid == 1 ) {
            return true;
        }
        
        return false;
        
    }
    
    public boolean isValidMove(int vy, int vx) {
        int valid = 1;
        
        valid = valid + Snake.moveTest(vx, vy) - 1;
        

        
        if ( valid == 1 ) {
            gui.updatePalya();
            gui.updateSnake(this);
            return true;
            
        }
        
        return false;
        
    }
    
    
    
    public class snake {
        
        ArrayList<gameObject> mySnake;

        public snake() {
            
            mySnake = new ArrayList<>();
            for ( int a = 0; a < 4; a++ ) {
                mySnake.add(new gameObject());
            }
            
        }

        public snake(ArrayList<gameObject> mySnake) {
            this.mySnake = new ArrayList<>();
            for ( int a = 0; a < mySnake.size(); a++) 
                
            
            this.mySnake.add(new gameObject(mySnake.get(a).x, mySnake.get(a).y));
        }
        
        public void move(int x, int y) {
            //0 a fej
            int HEAD = 0;
            mySnake.get(HEAD).move(mySnake.get(HEAD).x+x, mySnake.get(HEAD).y+y );
            for ( int a = 1; a < mySnake.size(); a++ ) {
                mySnake.get(a).move(mySnake.get(a-1).prevX, mySnake.get(a-1).prevY);
            }
        }
        
        public int moveTest(int x, int y) {
            int HEAD = 0;
            mySnake.get(HEAD).move(mySnake.get(HEAD).x+x, mySnake.get(HEAD).y+y );
            
            if ( mySnake.get(HEAD).y < 0 || mySnake.get(HEAD).x > 12 || mySnake.get(HEAD).x < 0 || mySnake.get(HEAD).y > 12 ) {
                return 0;
            }
            
            for ( int a = 1; a < mySnake.size(); a++ ) {
                if ( mySnake.get(HEAD).y == mySnake.get(a).y && mySnake.get(HEAD).x == mySnake.get(a).x ) {
                    return 0;
                }
            }
            
            if ( palya.get(mySnake.get(0).x + mySnake.get(0).y * 13) == 1 ) {
                return 0;
            }
            
            for ( int a = 1; a < mySnake.size(); a++ ) {
                mySnake.get(a).move(mySnake.get(a-1).prevX, mySnake.get(a-1).prevY);
            }
            return 1;
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
            return Snake.equals(((game)obj).Snake);
        }
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getDistance() {
        return super.getDistance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getHeuristic() {
        
        return Math.abs(((Snake.mySnake.get(0).x-(hol%13)) + Snake.mySnake.get(0).y-(hol/13)));//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getParent() {
        return super.getParent(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        Set<State> move;
        move = new HashSet<State>();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        game state = new game(this);
        if ( state.isValidMove(1, 0) ) {
            move.add(state);
        }
        state = new game(this);
        if ( state.isValidMove(-1, 0) ) {
            move.add(state);
        }
        state = new game(this);
        if ( state.isValidMove(0, 1) ) {
            move.add(state);
        }
        state = new game(this );
        if ( state.isValidMove(0,  -1) ) {
            move.add(state);
        }
        
        return move;
    }

    @Override
    public boolean isSolution() {
        
        if ( palya.get(Snake.mySnake.get(0).x+Snake.mySnake.get(0).y*13) > 1 && palya.get(Snake.mySnake.get(0).x+Snake.mySnake.get(0).y*13) < 3 ) {
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
