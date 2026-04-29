package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Tabuleiro;

public class DialogoPosicaoController {

    @FXML private Label     labelTitulo;
    @FXML private Label     labelSubtitulo;
    @FXML private TextField campoX;
    @FXML private TextField campoY;
    @FXML private Label     labelErro;

    private int[] resultado = null;

    public void setTitulo(String titulo) {
        labelTitulo.setText(titulo.toUpperCase());
    }

    public void setSubtitulo(String subtitulo) {
        labelSubtitulo.setText(subtitulo);
    }

    @FXML
    public void onConfirmar() {
        try {
            int x = Integer.parseInt(campoX.getText().trim());
            int y = Integer.parseInt(campoY.getText().trim());

            if (!new Tabuleiro().posicaoValida(x, y)) {
                mostrarErro("Valores devem estar entre 0 e " + (Tabuleiro.TAMANHO - 1));
                return;
            }

            resultado = new int[]{ x, y };
            fechar();

        } catch (NumberFormatException e) {
            mostrarErro("Digite apenas números inteiros");
        }
    }

    @FXML
    public void onCancelar() {
        resultado = null; // garante que está null ao cancelar
        fechar();
    }

    public int[] getResultado() {
        return resultado;
    }

    private void mostrarErro(String mensagem) {
        labelErro.setText("⚠  " + mensagem);
        labelErro.setVisible(true);

        String estiloErro = "-fx-border-color: #EF5350 !important;";
        if (!campoX.getText().trim().matches("\\d+")) {
            campoX.setStyle(campoX.getStyle() + estiloErro);
        }
        if (!campoY.getText().trim().matches("\\d+")) {
            campoY.setStyle(campoY.getStyle() + estiloErro);
        }
    }

    private void fechar() {
        Stage stage = (Stage) campoX.getScene().getWindow();
        stage.close();
    }
}