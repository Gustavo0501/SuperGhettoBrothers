import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaCarregamento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaCarregamento extends World
{
    private Background background;
    
    /**
     * Constructor for objects of class TelaCarregamento.
     * 
     */
    public TelaCarregamento(Background background)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        this.background = background;
    }
    
    public void act()
    {
        Greenfoot.delay(100);
        Greenfoot.setWorld(background);
    }
}
