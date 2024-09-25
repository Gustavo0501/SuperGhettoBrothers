import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inimigo extends Actor
{
    private boolean estaVivo;
    private boolean morto;
    private int vidas;
    private int tempoRecargaTiro;
    private int tempoReviver;
    private String nomeImagem;
    private int tempoUltimoTiro;
    private int tempoEstaMorto;
  
    
    
     /**
     * Construtor da classe Inimigo.
     * Inicializa o número de vidas, define o inimigo como vivo e configura o tempo de recarga de tiro.
     */
    Inimigo(int vidas, int tempoRecargaTiro, String nomeImagem)
    {   
       estaVivo = true;
       morto = false;
       this.vidas = vidas;
       this.tempoRecargaTiro = tempoRecargaTiro;
       this.nomeImagem = nomeImagem;
       tempoReviver = 300;
       
       tempoUltimoTiro = tempoRecargaTiro;
       tempoEstaMorto = 0;
    }
    
    /**
     * Método "act" do inimigo.
     * Chama o método para realizar disparos de projéteis e atualiza o tempo desde o último disparo.
     */
    public void act(int posX, int posY, int velocidadeTiro)
    {
        if(obterEstaVivo()){
            if(atirarProjetil(tempoUltimoTiro, posX, posY, velocidadeTiro))
            {
                tempoUltimoTiro = 0;
            }
            tempoUltimoTiro++;
        }
        else{
            if(!(obterMorto())){
                Background background = (Background) getWorld();
                background.contabilizarMorteInimigo();    
            }
            setMorto(true);
            
            setImage("lapide.png");
            getImage().scale(100, 100);
            tempoEstaMorto++;
            
            if(getTempoReviver() <= tempoEstaMorto){
                setEstaVivo(true);
                setVidas(2);
                setMorto(false);
                setImage(getImagem());
                tempoEstaMorto = 0;
                
            }
        }
    }
    
    public boolean obterEstaVivo()
    {
        return estaVivo;
    }
    
    public void setEstaVivo(boolean setEstaVivo)
    {
        estaVivo = setEstaVivo;
    }
    
    public boolean obterMorto()
    {
        return morto;
    }
    
    public void setMorto(boolean setMorto)
    {
        morto = setMorto;
    }
    
    public int getTempoReviver()
    {
        return tempoReviver;
    }
    
    public String getImagem()
    {
        return nomeImagem;        
    }
    
    public int obterVida()
    {
        return vidas;
    }
    
    public void setVidas(int vida)
    {
        vidas = vida;
    }
    
    /**
     * Método para tratar o inimigo sendo atingido por um tiro.
    */
    public boolean tomarTiro() {
        if (estaVivo) {
            Greenfoot.playSound("danoInimigo.wav");
            vidas--; // Reduz o número de vidas do inimigo
            if (vidas <= 0) {
                estaVivo = false;
            }
            return true;
        }
        return false;
    }
    
    /**
     * Método para realizar disparos de projéteis.
    */
    public boolean atirarProjetil(int tempoUltimoTiro, int posX, int posY, int velocidadeTiro)
    {
        if(estaVivo && tempoUltimoTiro >= tempoRecargaTiro)
        {
            TiroInimigo tiroInimigo = new TiroInimigo(velocidadeTiro);
            
            getWorld().addObject(tiroInimigo, getX()+posX, getY()+posY); // Adiciona o projétil ao mundo

            Greenfoot.playSound("tiro.wav");
            
            
            // Verifica se o projétil está dentro dos limites do mundo
            if (getX() - 60 < 0 || getX() - 60 > getWorld().getWidth() || getY() < 0 || getY() > getWorld().getHeight()) 
            {
                return false;// Se estiver fora dos limites, não dispara o projétil
            }
            return true;
        }
        return false;
    }
}
