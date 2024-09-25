import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inimigo1 extends Inimigo
{
    /**
     * Act - do whatever the Inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

     /**
     * Construtor da classe Inimigo.
     * Inicializa o número de vidas, define o inimigo como vivo e configura o tempo de recarga de tiro.
     */
    Inimigo1(int vidas, int tempoRecargaTiro, String nomeImagem)
    {
        super(vidas, tempoRecargaTiro, nomeImagem);
        
        setImage(nomeImagem);
    }
    
    /**
     * Método "act" do inimigo.
     * Chama o método para realizar disparos de projéteis e atualiza o tempo desde o último disparo.
     */
    public void act()
    {
        super.act(-60, 0, -3);
    }
}
