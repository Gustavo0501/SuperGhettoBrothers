import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaVitoria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaVitoria extends World
{
    private Background background1;
    private Pontuacao pontuacao;
    
    /**
     * Constructor for objects of class TelaVitoria.
     * 
     */
    public TelaVitoria(Background background1)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        this.background1 = background1;
    }
    
    public void act(){
        //se o jogador aperta "enter", o jogo recomeça
        if(Greenfoot.isKeyDown("enter")){
           Greenfoot.playSound("entrar2.wav"); 
           
           Background background = new Background(background1.obterClassePontuacao());
           
           Greenfoot.setWorld(background);
        }
        
        //se o jogador aperta "tab", vai para tela da tabela de pontuacoes
        if(Greenfoot.isKeyDown("tab")){
           Greenfoot.playSound("entrar2.wav"); 
           
           TabelaDePontuacao tabelaDePontuacao = new TabelaDePontuacao(background1);
           Greenfoot.setWorld(tabelaDePontuacao);
        }
    }
}
