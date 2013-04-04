/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supersumo;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Leland
 */
public class Pistol extends Weapon{
    
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    int clipSize = 6;
    int bulletsInClip = 0;
    int reloadTime = 180;
    boolean reloading = false;
    int elapseReloadTime;
    
    public boolean canShoot(){
        if(bulletsInClip <= clipSize && reloading == false){
            return true;
        }
        else return false;
    }
    
    public void update(){
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).update();
        }
        if(reloading == true){
            elapseReloadTime ++;
            if(elapseReloadTime > reloadTime){
                elapseReloadTime = 0;
                reloading = false;
            }
        }
    }
    
    public void shoot(double angle, double x, double y) throws SlickException{
        bullets.add(new Bullet((float)x, (float)y, (float)angle));
        this.bulletsInClip++;
    }
    
    public void reload(){
        reloading = true;
        bulletsInClip = 0;
    }
    
    public void draw() {
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).draw();
        }
    }
    
}
