import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    /**
     *  Verifica se o jogador tomou um tiro, se sim, um coraçao é removido da tela  
    */
    public void removerVida()
    {
        Jogador jogador = new Jogador();
        
        if(jogador.tomarTiro())
        {
            getWorld().removeObject(this);
        }
    }
}
