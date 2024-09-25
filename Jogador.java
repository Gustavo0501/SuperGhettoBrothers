import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogador extends Actor {
    private int frame = 1;
    private int contadorAnimacao;
    
    //imagens do persongaem à direita 
    GreenfootImage pwalkR1 = new GreenfootImage("viradoDireita.png");
    GreenfootImage pwalkR2 = new GreenfootImage("viradoDireitaCorrendo.png");
    GreenfootImage pwalkR3 = new GreenfootImage("viradoDireita2.png");
    GreenfootImage pwalkR4 = new GreenfootImage("viradoDireitaCorrendo2.png");
    
    //imagens do personagem à esquerda 
    GreenfootImage pwalkL1 = new GreenfootImage("viradoEsquerda.png");
    GreenfootImage pwalkL2 = new GreenfootImage("viradoEsquerdaCorrendo.png");
    GreenfootImage pwalkL3 = new GreenfootImage("viradoEsquerda2.png");
    GreenfootImage pwalkL4 = new GreenfootImage("viradoEsquerdaCorrendo2.png");
    
    private int velocidadeVertical = 0;
    private final int GRAVIDADE = 1;
    private boolean estaVivo;
    private int velocidadeMovimento = 3;
    private boolean pulando;
    private int alturaPulo = 15;
    private GreenfootSound musica;
    
    private int tempoUltimoTiro;
    private int tempoRecargaTiro;
    private boolean estaViradoParaDireita;
    
    private int vidas;
    
    private int pontosParaProximaFase;
    private int fase;
    
    
    /**
     * construtor da classe jogador 
     */
    public Jogador()
    {
        inicializar();
        musica = new GreenfootSound("deliriojogo.wav"); //musica de fundo do game
        musica.playLoop();
        
        tempoRecargaTiro = 60; //tempo necessario para que o jogador possa atirar novamente 
        tempoUltimoTiro = tempoRecargaTiro;
        pontosParaProximaFase = 200;
        fase = 1;
    }
    
    public void inicializar()
    {
        estaVivo = true;
        estaViradoParaDireita = true;
        vidas = 3;
    }
    
    public boolean estaVivo()
    {
        return estaVivo;
    }
    
    /**
     *  
     */
    public boolean tomarTiro()
    {
        if (estaVivo) //só entra nesse if se o personagem ainda estiver vivo
        {
            vidas--; //se o personagem tomou tiro logo ele perde uma vida 
            
            Background background = (Background) getWorld();
            Greenfoot.playSound("danoJogador.wav");
            background.removerVida();//remove um dos coraçoes da tela 
            
            if(vidas <= 0)// se a vida for menor ou igual a 0, significa que o personagem morreu, portanto estaVivo passar a ser false
            {
                estaVivo = false;
            }
        }
        return true;
    }
     
    /**
     * Aqui estao todas as possiveis açoes dentro do jogo (andar, pular, atirar)
     */
    public void act()
    {
        tempoUltimoTiro++;// a cada frame o tempo do ultimo tiro aumenta uma unidade
        
        checarSeEstaCaindo(); // Verifica se o personagem está caindo
        moverPersonagem(); // Move o personagem
        
        atirarProjetil();
        
        // Realiza um disparo de projétil
        
        Background background = (Background) getWorld();
        Placar placar = background.obterPlacar();
        Pontuacao pontuacao = background.obterClassePontuacao();
        
        if(estaVivo && placar.obterPontuacao() >= pontosParaProximaFase)
        {
            pontosParaProximaFase += 200;
            TelaCarregamento telaCarregamento = new TelaCarregamento(background);
            Greenfoot.setWorld(telaCarregamento);
            fase++;
            
            musica.stop();
            
            if(fase == 2)
            {
                musica = new GreenfootSound("velho_oeste_som.mp3"); //musica de fundo do game
                musica.playLoop();
            }
            
            else if(fase == 3)
            {
                musica = new GreenfootSound("musica_chinesa.mp3"); //musica de fundo do game
                musica.playLoop();
            }
            
            else if(fase == 4)
            {
                pontuacao.registrarPontuacao(pontuacao.getTempo(), placar.obterPontuacao(), pontuacao.receberNomeJogador());
                pontuacao.zerarTempoDeInicio();
            }
            
            
            background.trocarFase(fase);
        }
        
        
        if (!estaVivo) {
            pontuacao.registrarPontuacao(pontuacao.getTempo(), placar.obterPontuacao(), pontuacao.receberNomeJogador());
            pontuacao.zerarTempoDeInicio();
            
            // Parar a reprodução da música
            musica.stop();
            
            World gameover = new GameOver(background);
            getWorld().removeObject(this);
            Greenfoot.setWorld(gameover); // aparece a tela de game over
            
        }
    }
    
    /**
     * dentro desse metodo esta toda a movimentaçao do jogador  
     */
    public void moverPersonagem()
    {
        contadorAnimacao++;
        
        //faz o personagem mover para a direita 
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX() + velocidadeMovimento, getY());
            if(contadorAnimacao % 6 == 0)
            {
                animarDireita();
            }
            estaViradoParaDireita = true;
        }
        
        //faz o personagem mover para a esquerda
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - velocidadeMovimento, getY());
            if(contadorAnimacao % 6 == 0)
            {
                animarEsquerda();
            }
            estaViradoParaDireita = false;
        }
        
        //faz o personagem mover para pular
        if((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up")) && pulando == false)
        {
            velocidadeVertical = velocidadeVertical - alturaPulo;
            pulando = true;
            Greenfoot.playSound("puloBaixo.wav");
            cair();
        }
        
    }
    
    /**
     * esse metodo age como a gravidade do jogo
     */
    public void cair()
    {
        setLocation(getX(), getY() + velocidadeVertical); // Move o personagem verticalmente com base na velocidade vertical
        
        if(velocidadeVertical <= 12) // Verifica se a velocidade vertical está dentro do limite máximo
        {
            velocidadeVertical = velocidadeVertical + GRAVIDADE; // Atualiza a velocidade vertical com a força da gravidade
        }
        
        pulando = true;
    }
    
    /**
     * esse metodo confere se o personagem está no ar ou no chao
     */
    public void checarSeEstaCaindo()
    {
        if(estaNoChao() == true)
        {
            velocidadeVertical = 0; // se o persongem está no chao, a velocidade vertical dele é igual a 0
        }
        else
        {
            cair(); // se nao estiver encostado, é chamado o método "cair" que faz ele cair 
        }
    }
    
    /**
     * Verifica se o personagem está em contato com o chão.
     */
    public boolean estaNoChao()
    {
        int alturaPersonagem = getImage().getHeight(); 
        int procurarPeloChao = alturaPersonagem / 2; // Define a posição a partir da qual procurar o chão (metade da altura do personagem)
        
        Actor ground = getOneObjectAtOffset(0, procurarPeloChao, Ground.class); // Verifica se há um objeto "Ground" abaixo do personagem
        
        if(ground == null)
        {
            pulando = true;
            return false;
        }
        else
        {
            moverParaChao(ground);
            return true;
        }
    }
    
    /**
     * Move o personagem para a posição do chão após a detecção de colisão com o chão.
 
     */
    public void moverParaChao(Actor ground)
    {
        int alturaChao = ground.getImage().getHeight();// Obtém a altura do objeto "Ground"
        int novoY = ground.getY() - (alturaChao + getImage().getHeight()) / 2; // Calcula a nova posição vertical do personagem para alinhar com o chão
        
        setLocation(getX(), novoY);
        pulando = false;
    }

    /**
     * Anima o personagem virado para a direita.
     * Controla a troca de imagens para criar uma animação.
    */
    public void animarDireita()
    {
        if(frame == 1)
        {
            setImage(pwalkR1);
            frame = 2;
        }
        else if(frame == 2)
        {
            setImage(pwalkR2);
           frame = 3;
        }
        else if(frame == 3)
        {
            setImage(pwalkR3);
            frame = 4;
        }
        else
        {
            setImage(pwalkR4);
            frame = 1;
        }
    }
    
    /**
     * Anima o personagem virado para a esquerda.
     * Controla a troca de imagens para criar uma animação.
    */
    public void animarEsquerda()
    {
        if(frame == 1)
        {
            setImage(pwalkL1);
            frame = 2;
        }
        else if(frame == 2)
        {
            setImage(pwalkL2);
           frame = 3;
        }
        else if(frame == 3)
        {
            setImage(pwalkL3);
            frame = 4;
        }
        else
        {
            setImage(pwalkL4);
            frame = 1;
        }
    }
    
    /**
     * Realiza um disparo de projétil quando o botão do mouse é pressionado e o tempo de recarga é respeitado.
     * Determina a direção do disparo com base na posição do mouse em relação ao personagem.
    */
    public void atirarProjetil()
    {
        if(Greenfoot.mousePressed(null) && tempoUltimoTiro >= tempoRecargaTiro)
        {
            TiroJogador tiroJogador = new TiroJogador(4);
            
            if(estaViradoParaDireita)// Determina a direção do disparo com base na posição do mouse em relação ao personagem
            {
                if(!(Greenfoot.getMouseInfo().getX() >= getX()))
                {
                    setImage(pwalkL1);// Altera a imagem do personagem se o mouse estiver à esquerda
                    getWorld().addObject(tiroJogador, getX()-23, getY()+11); 
                    estaViradoParaDireita = false;
                }
                else{
                    getWorld().addObject(tiroJogador, getX()+23, getY()+11);
                }
            }
            if(!estaViradoParaDireita)
            {
                if(!(Greenfoot.getMouseInfo().getX() <= getX()))
                {
                    setImage(pwalkR1);// Altera a imagem do personagem se o mouse estiver à direita
                    getWorld().addObject(tiroJogador, getX()+23, getY()+11);
                    estaViradoParaDireita = true;
                }
                else{
                    getWorld().addObject(tiroJogador, getX()-23, getY()+11);
                }
                
            }
            tiroJogador.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());  // Define a rotação do projétil em direção à posição do mouse
            Greenfoot.playSound("tiro.wav");
            
            tempoUltimoTiro = 0;
        }
    }
    
    
}
