/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Leland Lopez
 */
public class Ring {

    Image ringTexture = null;

    public Ring()
            throws SlickException {
        this.ringTexture = new Image("content/ring.bmp");
    }
    
    public void draw()
    {
        this.ringTexture.draw(0,0);
    }
}
