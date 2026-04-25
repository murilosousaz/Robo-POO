package model;

public class Alimento {
    private final int eixoX;
    private final int eixoY;

    public Alimento(int eixoX, int eixoY) {
        if(eixoX < 0 || eixoY < 0){
            throw new IllegalArgumentException(
                    "Posição do alimento não pode ser negativa: (" + eixoX + ", " + eixoY + ")"
            );
        }
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    public boolean foiEncontradoPor(Robo robo){
        if (robo.getEixoX() == -1 && robo.getEixoY() == -1){
            return false;
        }
        return robo.getEixoX() == this.eixoX && robo.getEixoY() == this.eixoY;
    }

    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    @Override
    public String toString(){
        return "Alimento(" + eixoX + ", " + eixoY + ")";
    }
}
