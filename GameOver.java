import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private Background background;
    private Pontuacao pontuacao;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(Background background)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        this.background = background;
    }
    
    public void playMusic(){
        Greenfoot.playSound("gameOver.wav");
    }
    
    public void act(){
        //se o usuário apertar a tecla "enter", o jogo recomeça
        if(Greenfoot.isKeyDown("enter")){
           Greenfoot.playSound("entrar2.wav"); 
           
           pontuacao = background.obterClassePontuacao();
           
           //aqui estamos criando um novo background, porém salvando a pontuacao
           Background newBackground = new Background(pontuacao);
           Greenfoot.setWorld(newBackground);
        }
        
        //se o usuário apertar a tecla "tab", entramos na tela da tabela de pontuacao
        else if(Greenfoot.isKeyDown("tab")){
           Greenfoot.playSound("entrar2.wav"); 
           //Greenfoot.setWorld(background.getTabela());
           TabelaDePontuacao tabelaDePontuacao = new TabelaDePontuacao(background);
           Greenfoot.setWorld(tabelaDePontuacao);
        }
    }
}
