package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;

import java.util.List;
import java.util.Optional;

public class EntradaDados {
	private EntradaDados(){}

	public static int lerInteiro(String titulo, String mensagem) {
		while (true) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle(titulo);
			dialog.setHeaderText(null);
			dialog.setContentText(mensagem);

			Optional<String> resultado = dialog.showAndWait();

			if (!resultado.isPresent()) {
				return -1;
			}
			try {
				return Integer.parseInt(resultado.get().trim());
			} catch (NumberFormatException e) {
				mostrarErro("Entrada inválida", "Digite apenas números inteiros.");
				}
			}
		}

	public static int[] lerCoordenada(String titulo) {
		int x = lerInteiro(titulo, "Posição X (0 a " + (model.Tabuleiro.TAMANHO - 1) + "):");
		if (x == -1) return null;

		int y = lerInteiro(titulo, "Posição Y (0 a " + (model.Tabuleiro.TAMANHO - 1) + "):");
		if (y == -1) return null;

		return new int[]{ x, y };
	}

	public static String lerDirecao() {
		List<String> opcoes = List.of("up", "down", "right", "left");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("up", opcoes);
		dialog.setTitle("Movimento do Robô");
		dialog.setHeaderText(null);
		dialog.setContentText("Escolha a direção:");

		Optional<String> resultado = dialog.showAndWait();

		return resultado.orElse(null);
	}

	public static String lerString(String titulo, String mensagem) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle(titulo);
		dialog.setHeaderText(null);
		dialog.setContentText(mensagem);

		Optional<String> resultado = dialog.showAndWait();
		return resultado.orElse(null);
	}

	public static void mostrarErro(String titulo, String mensagem) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();
	}

	public static void mostrarInfo(String titulo, String mensagem) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);
		alert.showAndWait();
	}

	public static boolean confirmar(String titulo, String mensagem) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensagem);

		Optional<ButtonType> result = alert.showAndWait();
		return result.orElse(ButtonType.CANCEL) == ButtonType.OK;
	}

}