import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiroJogador extends Tiro
{
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage tiroPersonagem; 

    /**
     * Construtor da classe Fire.
     * Inicializa a velocidade do projétil e define a imagem com base no tipo de projétil.
     */
    TiroJogador(int velocidadeTiro)
    {
        super(velocidadeTiro);
        
        setImage(new GreenfootImage("ParticulaTiro.png"));
    }
    
    /**
     * Método "act" do projétil.
     * Verifica colisões com outros objetos e move o projétil.
    */
    public void act(){
        super.act(false);
    }
}
    
