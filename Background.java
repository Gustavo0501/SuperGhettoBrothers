import greenfoot.*;
import java.util.List;

  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World 
{    
    private Placar placar;
    private Pontuacao pontuacao;
    private Inimigo1 inimigo1;
    private Inimigo2 inimigo2;
    
    /**
     * Constructor for objects of class Background.
     * 
     */
    
    //construtor que inicializa o background pela primeira vez
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        pontuacao = new Pontuacao();
        
        inicializar();
    }
    
    //construtor para inicializar o background outras vezes
    public Background(Pontuacao pontuacao)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        this.pontuacao =  pontuacao;
        
        inicializar();
    }
    
    //método para inicializar o cenário, criar o jogador, chão, inimigos, vidas e placar
    public void inicializar()
    {
        addObject(new Jogador(), 60, 530);
        addObject(new Ground(), 400, 800);
        addObject(new Ground(), 1200, 800);
        
        addObject(new Vida(), 20, 30);
        addObject(new Vida(), 60, 30);
        addObject(new Vida(), 100, 30);
        
        placar = new Placar();
        addObject(placar, 500,20);
        
        Background background = this; // Referência ao Background atual
        
        adicionarInimigo1(970, 535, 70);
    }
    
    private void removerInimigo1()
    {
        removeObject(inimigo1);
    }
    
    private void removerInimigo2()
    {
        removeObject(inimigo2);
    }
    
    private void adicionarInimigo1(int posX, int posY, int tempoRecargaTiro)
    {
        inimigo1 = new Inimigo1(2, tempoRecargaTiro, "soldadoJogo.png");
        addObject(inimigo1, posX, posY);
    }
    
    private void adicionarInimigo2(int posX, int posY, int tempoRecargaTiro)
    {
        inimigo2 = new Inimigo2(2, tempoRecargaTiro, "Inimigo2O.png");
        addObject(inimigo2, posX, posY);
    }
    
    //muda a imagem de fundo do cenário da fase 2
    private void setBackgroundFase2()
    {
        setBackground("Velho oeste1.png");
    }
    
    //muda a imagem de fundo do cenário da fase 3
    private void setBackgroundFase3()
    {
        setBackground("cenarioNinja2f.png");
    }
    
    //método que contém a lógica para trocar os cenários e inimigos ao passar de fase
    public void trocarFase(int fase)
    {
        if(fase == 2)
            {
                removerTiros();
                setBackgroundFase2();
                removerInimigo1();
                adicionarInimigo2(70, 525, 55);
            }
            else if (fase == 3)
            {
                removerTiros();
                setBackgroundFase3();
                removerInimigo2();
                adicionarInimigo1(970, 535, 160);
                adicionarInimigo2(70, 525, 160);
            }
            else if (fase == 4)
            {
                TelaVitoria telaVitoria = new TelaVitoria(this);
                Greenfoot.setWorld(telaVitoria);
            }
    }
    
    //método para remover as vidas do cenário quando o jogador toma dano
    public void removerVida()
    {
        // Obtém uma lista de objetos Vida no mundo
        List<Vida> vidas = getObjects(Vida.class);
        
        // Verifica se há vidas no mundo
        if (!vidas.isEmpty()) {
            // Remove a primeira Vida da lista (ou seja, a mais à direita)
            removeObject(vidas.get(vidas.size()-1));
        }
    }
    
    //método para remover os tiros do cenário quando a fase é trocada
    private void removerTiros() {
        //obtém uma lista de objetos tiro no mundo
        List<Tiro> tiros = getObjects(Tiro.class);
        
        //Percorre a lista e remove todos os objetos tiro
        for (Tiro tiro : tiros) {
            removeObject(tiro);
        }
    }
    
    public Placar obterPlacar() {
        return placar;
    }
    
    public Pontuacao obterClassePontuacao()
    {
        return pontuacao;
    }
    
    //método para contabiliar os pontos no placar ao matar um inimigo
    public void contabilizarMorteInimigo() {
        placar.contabilizarMortes();
    }
}
