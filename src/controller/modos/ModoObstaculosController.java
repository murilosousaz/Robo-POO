package controller.modos;

import model.Bomba;
import model.Robo;
import model.Rocha;
import model.Tabuleiro;
import view.EntradaDados;

public class ModoObstaculosController {

    public boolean configurar(Tabuleiro tabuleiro) {

        boolean adicionouAlgumObstaculo = false;

        if (EntradaDados.confirmar("Obstáculos", "Deseja adicionar uma Bomba?")) {
            int[] pos = EntradaDados.lerCoordenada("Posição da Bomba 💣");
            if (pos != null) {
                tabuleiro.adicionarObstaculo(new Bomba(1, pos[0], pos[1]));
                adicionouAlgumObstaculo = true;
            }
        }

        if (EntradaDados.confirmar("Obstáculos", "Deseja adicionar uma Rocha?")) {
            int[] pos = EntradaDados.lerCoordenada("Posição da Rocha 🪨");
            if (pos != null) {
                tabuleiro.adicionarObstaculo(new Rocha(2, pos[0], pos[1]));
                adicionouAlgumObstaculo = true;
            }
        }

        int[] posAlimento = EntradaDados.lerCoordenada("Posição do Alimento 🍎");
        if (posAlimento == null) return false;

        tabuleiro.definirAlimento(posAlimento[0], posAlimento[1]);
        tabuleiro.adicionarRobo(new Robo("blue"));
        return true;
    }

    public String getNome()      { return "Modo: Obstáculos"; }
    public String getDescricao() { return "Desvie das bombas e rochas para chegar ao alimento!"; }
    public boolean isModoManual() { return false; }
    public int getIntervaloMs()   { return 700; }
}