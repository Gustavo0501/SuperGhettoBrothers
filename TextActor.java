import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextActor extends Actor
{
    public TextActor(String text) {
        GreenfootImage image = new GreenfootImage(text, 20, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
