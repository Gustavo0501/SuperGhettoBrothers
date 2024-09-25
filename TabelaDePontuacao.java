import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class TabelaDePontuacao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TabelaDePontuacao extends World
{
    private Background background;
    private Pontuacao pontuacao;
    private TextActor recorde;
    
    /**
     * Constructor for objects of class TabelaDePontuacao.
     * 
     */
    public TabelaDePontuacao(Background background)
    {    
        super(1024, 600, 1);
        this.background = background;
        inicializar();
    }
    
    public void inicializar()
    {
        mostrarTabela();
    }
    
    public void mostrarTabela()
    {
        pontuacao = background.obterClassePontuacao();
        
        //adiciona um cabeçalho
        addObject(new TextActor("NOME           PONTUACAO           TEMPO  "), getWidth() / 2, 100);
        
        //adicona a pontuacao recorde
        recorde = new TextActor(pontuacao.obterPontuacaoRecorde());
        addObject(recorde, (getWidth() / 2) - 50, 135);

        
        int i = 7;
        
        ArrayList<String> tabelaPontuacao = pontuacao.obterTabelaPontuacao();
        
        //adiciona todas as pontuações        
        for(String pontuacao : tabelaPontuacao)
        {
            addObject(new TextActor(pontuacao), getWidth() / 2, 21 * (i + 1));
            i++;
        }
    }
    
    public void act(){
        //se o jogador aperta a tecla "esc", voltamos para tela de gameover ou vitoria
        if(Greenfoot.isKeyDown("escape")){
            Placar placar = background.obterPlacar();
            
            Greenfoot.playSound("entrar2.wav");
            
            //se o jogador não tiver atingido a pontuação suficiente para ter passado as 3 fases, 
            //significa que ele morreu e está na tela gameover
            if(placar.obterPontuacao() < 600)
            {
                World gameover = new GameOver(background);
                Greenfoot.setWorld(gameover); // aparece a tela de game over
            }
            else{
                TelaVitoria telaVitoria = new TelaVitoria(background);
                Greenfoot.setWorld(telaVitoria);
            }
        }
    }
}
