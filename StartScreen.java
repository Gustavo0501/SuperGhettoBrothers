import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
    }
    
    public void act(){
        //se o usuário aperta a tecla "entrer", o jogo começa
        if(Greenfoot.isKeyDown("enter")){
           Greenfoot.playSound("entrar2.wav"); 
           
           World background = new Background();
           
           Greenfoot.setWorld(background);
        }
        
        //se o usuário aperta a tecla "tab", entramos na tela de como jogar
        else if(Greenfoot.isKeyDown("tab")){
           Greenfoot.playSound("entrar2.wav"); 
           
           ComoJogar comoJogar = new ComoJogar();
           
           Greenfoot.setWorld(comoJogar);
        }
    }
}
