/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanke;

import java.util.ArrayList;
import search.AbstractState;
import search.State;

/**
 *
 * @author SPL
 */
public class game extends AbstractState {

    public game() {
        
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
        
        
        
        
        public class gameObject {
            int x;
            int y;

            public gameObject() {
                
            }
            
            

            public gameObject(int x, int y) {
                this.x = x;
                this.y = y;
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
            
            
            
            
            
        }
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if ( obj.getClass() == game.class && obj != null ) {
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
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
