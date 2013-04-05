/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Leland
 */
public abstract class PrimaryWeapon {
    
    
    public void shoot(double angle, double x, double y) throws SlickException{   
    }
    
    public void update(GameContainer gc){
        
    }
    
    public void draw() {
    }
    
    public boolean canShoot(){
        return true;
    }
    
    public void reload(){
    }
    
}
