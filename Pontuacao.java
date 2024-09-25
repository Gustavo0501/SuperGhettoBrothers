import greenfoot.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Write a description of class TabelaDePontuacao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pontuacao
{
    private int pontuacao;
    private int maiorPontuacao;
    private String pontuacaoRecorde;
    private long tempoDeInicio;
    private ArrayList<String> tabelaPontuacao;
    
    private Background background;
    private TextActor recorde;
    
    /**
     * Constructor for objects of class TabelaDePontuacao.
     * 
     */
    public Pontuacao()
    {    
        tabelaPontuacao = new ArrayList<>();
        maiorPontuacao = -1;
        zerarTempoDeInicio();
    }
    
    //zera o tempo para começar uma nova contagem
    public void zerarTempoDeInicio()
    {
        tempoDeInicio = System.currentTimeMillis();
    }
    
    public String getTempo() {
        long tempoAtual = System.currentTimeMillis();
        long diferenca = (tempoAtual - tempoDeInicio);

        long diferencaSeg = diferenca/1000;
        long diferencaMin = diferenca/60000;
        long diferencaHor = diferenca/3600000;

        if (diferencaSeg<60){
            //return  "voce jogou por "  + diferencaSeg + " segundos";
            return diferencaSeg + " segundos";
        }
        else if(diferencaMin<3600){
            diferencaSeg = diferencaSeg%60;
            //return "voce jogou por "  + diferencaMin + " minutos e " + diferencaSeg + " segundos" ;
            return diferencaMin + " minutos e " + diferencaSeg + " segundos";
        }
        else{
            diferencaMin= diferencaMin%60;
            diferencaSeg= diferencaSeg%60;
            //return "voce jogou por "  + diferencaHor + " horas " + diferencaMin + " minutos e " + diferencaSeg + " segundos" ;
            return diferencaHor + " horas, " + diferencaMin + " minutos e " + diferencaSeg + " segundos";
        }
    }
    
    public String receberNomeJogador()
    {
        String nomeJogador;
        
        nomeJogador = Greenfoot.ask("Digite seu nome: ");
        
        return nomeJogador;
    }
    
    public void registrarPontuacao(String tempoDeJogo, int pontuacao, String nomeJogador)
    {
        tabelaPontuacao.add(nomeJogador + "                  " + pontuacao + "                    " + tempoDeJogo + "\n");
        if(pontuacao > maiorPontuacao)
        {
            pontuacaoRecorde = "RECORDE:   " + nomeJogador + "                  " + pontuacao + "                  " + tempoDeJogo + "\n";
            maiorPontuacao = pontuacao;
        }
    }
    
    public String obterPontuacaoRecorde()
    {
        return pontuacaoRecorde;
    }
    
    public ArrayList<String> obterTabelaPontuacao()
    {
        return tabelaPontuacao;
    }
    
    public void act(){
        
    }
}
