import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Placar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Placar extends Actor
{
    private int pontuacao;
    private int pontosPorEliminar = 50;
    private int tempoAumentarPontuacao = 20;
    
    public Placar(){
        setLocation(20,20);
        inicializar();
    }
    
    public void inicializar(){
        pontuacao = 0;
        setImage(new GreenfootImage("Placar: " + pontuacao, 20, Color.YELLOW, Color.BLACK ));
    }
    
    public int obterPontuacao()
    {
        return pontuacao;
    }
    
    public void contabilizarMortes(){
        pontuacao += pontosPorEliminar;
        setImage(new GreenfootImage("Placar: " + pontuacao, 20, Color.YELLOW, Color.BLACK));
    }
    
    /**
     * Act - do whatever the Placar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
