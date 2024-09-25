import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ComoJogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComoJogar extends World
{

    /**
     * Constructor for objects of class ComoJogar.
     * 
     */
    public ComoJogar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1); 
    }
    
    public void act()
    {
        //se o usuário apertar a tecla ESC, voltamos para tela inicial
        if(Greenfoot.isKeyDown("escape")){
           Greenfoot.playSound("entrar2.wav"); 
           
           StartScreen startScreen = new StartScreen();
           
           Greenfoot.setWorld(startScreen);
        }
    }
}
