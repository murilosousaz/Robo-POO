package controller.modos;

import model.Robo;
import model.Tabuleiro;
import view.EntradaDados;

public class ModoCompetitivoController {

    public boolean configurar(Tabuleiro tabuleiro) {
        int[] pos = EntradaDados.lerCoordenada("Posição do Alimento");
        if (pos == null) return false;

        tabuleiro.definirAlimento(pos[0], pos[1]);

        tabuleiro.adicionarRobo(new Robo("blue"));
        tabuleiro.adicionarRobo(new Robo("red"));
        return true;
    }

    public String getNome()      { return "Modo: Competitivo"; }
    public String getDescricao() { return "Dois robôs buscam o alimento. Quem chega primeiro vence!"; }
    public boolean isModoManual() { return false; }
    public int getIntervaloMs()   { return 700; }
}