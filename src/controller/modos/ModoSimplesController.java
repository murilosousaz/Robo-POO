package controller.modos;

import model.Robo;
import model.Tabuleiro;
import view.EntradaDados;

public class ModoSimplesController {

    public boolean configurar(Tabuleiro tabuleiro) {
        int[] pos = EntradaDados.lerCoordenada("Posição do Alimento");
        if (pos == null) return false; // usuário cancelou

        tabuleiro.definirAlimento(pos[0], pos[1]);
        tabuleiro.adicionarRobo(new Robo("blue"));
        return true;
    }

    public String getNome()      { return "Modo: Simples"; }
    public String getDescricao() { return "Use os botões para mover o robô."; }

    public boolean isModoManual() { return true; }
}