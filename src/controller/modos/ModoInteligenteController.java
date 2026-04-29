package controller.modos;

import model.Robo;
import model.RoboInteligente;
import model.Tabuleiro;
import view.EntradaDados;

import java.util.Random;

public class ModoInteligenteController {

    private final Random random = new Random();

    public boolean configurar(Tabuleiro tabuleiro) {
        int[] pos = EntradaDados.lerCoordenada("Posição do Alimento");
        if (pos == null) return false;

        tabuleiro.definirAlimento(pos[0], pos[1]);
        tabuleiro.adicionarRobo(new Robo("blue"));

        tabuleiro.adicionarRobo(new RoboInteligente("gold", random));
        return true;
    }

    public Random getRandom()    { return random; }
    public String getNome()      { return "Modo: Inteligente"; }
    public String getDescricao() { return "Robô normal vs Robô Inteligente. Quem chega primeiro?"; }
    public boolean isModoManual() { return false; }
    public int getIntervaloMs()   { return 800; }
}