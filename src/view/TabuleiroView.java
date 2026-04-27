package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Alimento;
import model.Bomba;
import model.Obstaculo;
import model.Robo;
import model.RoboInteligente;
import model.Tabuleiro;

public class TabuleiroView {
	private static final int TAMANHO_CELULA = 90;
	private static final int RAIO_ICONE = 28;

	private final GridPane grid;

	public TabuleiroView(GridPane grid){
		this.grid = grid;
		configurarGrid();
	}

	private void configurarGrid(){
		grid.setHgap(4);
		grid.setVgap(4);
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("fx-background-color: #1A1A2E; -fx-padding: 8;");
	}

	public void renderizar(Tabuleiro tabuleiro) {
		grid.getChildren().clear();
		desenharFundo(tabuleiro);
		desenharAlimento(tabuleiro);
		desenharObstaculos(tabuleiro);
		desenharRobos(tabuleiro);
	}

	private void desenharFundo(Tabuleiro tabuleiro) {
		for (int x = 0; x < Tabuleiro.TAMANHO; x++) {
			for (int y = 0; y < Tabuleiro.TAMANHO; y++) {
				StackPane celula = criarCelulaVazia(x, y);
				grid.add(celula, x, Tabuleiro.TAMANHO - 1 - y);
			}
		}
	}

	private StackPane criarCelulaVazia(int x, int y) {
		Rectangle fundo = new Rectangle(TAMANHO_CELULA, TAMANHO_CELULA);
		fundo.setArcWidth(10);
		fundo.setArcHeight(10);
		boolean par = (x + y) % 2 == 0;
		fundo.setFill(Color.web(par ? "#16213E" : "#0F3460"));

		Label coord = new Label(x + "," + y);
		coord.setFont(Font.font("Monospace", 9));
		coord.setTextFill(Color.web("#FFFFFF30"));
		StackPane.setAlignment(coord, Pos.BOTTOM_RIGHT);

		StackPane celula = new StackPane(fundo, coord);
		celula.setPrefSize(TAMANHO_CELULA, TAMANHO_CELULA);
		return celula;
	}

	private void desenharAlimento(Tabuleiro tabuleiro) {
		int ax = tabuleiro.getAlimentoX();
		int ay = tabuleiro.getAlimentoY();
		if (ax < 0 || ay < 0) return;

		StackPane icone = criarIcone("🍎", "#00FF87", "#00CC6A");
		grid.add(icone, ax, Tabuleiro.TAMANHO - 1 - ay);
	}

	private void desenharObstaculos(Tabuleiro tabuleiro) {
		for (Obstaculo obs : tabuleiro.getObstaculos()) {
			StackPane icone;
			if (obs instanceof Bomba) {
				icone = criarIcone("💣", "#FF4444", "#CC0000");
			} else {
				icone = criarIcone("🪨", "#8B7355", "#6B5335");
			}
			grid.add(icone, obs.getEixoX(), Tabuleiro.TAMANHO - 1 - obs.getEixoY());
		}
	}

	private void desenharRobos(Tabuleiro tabuleiro) {
		for (Robo robo : tabuleiro.getRobos()) {
			if (robo.getEixoX() == -1) continue;

			boolean inteligente = robo instanceof RoboInteligente;
			StackPane icone = criarIconeRobo(robo.getCor(), inteligente);
			grid.add(icone, robo.getEixoX(), Tabuleiro.TAMANHO - 1 - robo.getEixoY());
		}
	}

	private StackPane criarIcone(String emoji, String corFundo, String corBorda) {
		Circle circulo = new Circle(RAIO_ICONE);
		circulo.setFill(Color.web(corFundo + "33"));
		circulo.setStroke(Color.web(corBorda));
		circulo.setStrokeWidth(2);

		Label label = new Label(emoji);
		label.setFont(Font.font(22));

		StackPane pane = new StackPane(circulo, label);
		pane.setPrefSize(TAMANHO_CELULA, TAMANHO_CELULA);
		return pane;
	}

	private StackPane criarIconeRobo(String cor, boolean inteligente) {
		Circle circulo = new Circle(RAIO_ICONE);
		circulo.setFill(Color.web(cor + "55"));
		circulo.setStroke(inteligente ? Color.GOLD : Color.web(cor));
		circulo.setStrokeWidth(inteligente ? 3 : 2);

		Label emoji = new Label(inteligente ? "🤖" : "🦾");
		emoji.setFont(Font.font(22));

		Label inicial = new Label(cor.substring(0, 1).toUpperCase());
		inicial.setFont(Font.font("Monospace", FontWeight.BOLD, 10));
		inicial.setTextFill(Color.WHITE);
		StackPane.setAlignment(inicial, Pos.BOTTOM_CENTER);

		StackPane pane = new StackPane(circulo, emoji, inicial);
		pane.setPrefSize(TAMANHO_CELULA, TAMANHO_CELULA);
		return pane;
	}

}