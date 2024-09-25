import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiro extends Actor 
{
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int velocidadeTiro;

    /**
     * Construtor da classe Fire.
     * Inicializa a velocidade do projétil e define a imagem com base no tipo de projétil.
     */
    Tiro(int velocidadeTiro)
    {
        this.velocidadeTiro = velocidadeTiro;
    }
    
    /**
     * Método "act" do projétil.
     * Verifica colisões com outros objetos e move o projétil.
    */
    public void act(boolean doInimigo){
        tiroColidiu(doInimigo);
        moverTiro();
    }
    
    private void moverTiro()
    {
        move(velocidadeTiro);
    }
    
    public boolean tiroColidiu(boolean doInimigo){
        if (isAtEdge()) {
            getWorld().removeObject(this); // Remove o projétil se atingir a borda do mundo
        }
        else if(doInimigo){
            Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
            if (jogador != null){
                jogador.tomarTiro();// Chama o método para tratar o jogador sendo atingido
                getWorld().removeObject(this);// Remove o projétil
                return true;
            }
            
        }
        else{
            Inimigo inimigo = (Inimigo) getOneIntersectingObject(Inimigo.class);
            if(inimigo != null){
                inimigo.tomarTiro();// Chama o método para tratar o inimigo sendo atingido
                getWorld().removeObject(this);// Remove o projétil
                return true;
            }
        }
        return false; // Retorna false indicando que não houve colisão com objetos nem atingiu a borda.
    }
}