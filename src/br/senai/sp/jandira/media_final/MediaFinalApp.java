package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class MediaFinalApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Determinando o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(600);

        // Determinar o título do Stage
        stage.setTitle("Média final");

        // Painel Raiz (root)
        BorderPane root = new BorderPane();

        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof.Vicente Amato\"");
        // Formatação do texto de Label
        labelTitulo.setStyle("-fx-text-fill: #005AFF; -fx-font-size: 32; -fx-font-weigth: bold;");
        labelTitulo.setPadding(new Insets(10, 0, 10, 10));
        //Painel de resultdos
        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets(0, 0, 10, 10));
        Label labelAluno = new Label("Nome do Aluno: ");
        Label labelMediaFinal = new Label("Média Final: ");
        Label labelSituação = new Label("Situação: ");
        painelResultado.getChildren().addAll(labelAluno, labelMediaFinal, labelSituação);

        // Painel
        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets(0, 10, 10, 0));
        painelDeBotoes.setSpacing(10);
        Button buttonCalcularMedia = new Button("Calcular média");
        buttonCalcularMedia.setPrefWidth(150);
        buttonCalcularMedia.setPrefHeight(50);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(150);
        buttonLimpar.setPrefHeight(40);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(150);
        buttonSair.setPrefHeight(40);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        // Painel
        VBox painelFormularios = new VBox();
        painelFormularios.setPadding(new Insets(0, 0, 10, 10));
        Label labelNomeAluno = new Label("Nome do aluno:");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();
        painelFormularios.getChildren().addAll(
                labelNomeAluno, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );


        root.setRight(painelDeBotoes);
        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setLeft(painelFormularios);

        Scene scene = new Scene(root);
        stage.setScene(scene);


        //  Mostrar o stage (tela)
        stage.show();

        // Eventos de cliques de botões
        buttonCalcularMedia.setOnAction(click -> {
            System.out.println("Botão criado");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //calcular a média
            //obter as notas
            // criar um vetor de notas
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            // Uso de loop while (enquanto)
            double mediaFinal = 0.0;
            int i = 0;
            while (i < notas.length){
                //mediaFinal = mediaFinal + notas[i];
                mediaFinal += notas[i];
                //i = i + 1;
                i++;
            }

            mediaFinal = mediaFinal / notas.length;


            String mediaFinalstr = getString(mediaFinal);

            System.out.println(mediaFinal);

            labelMediaFinal.setText("Média final: " + mediaFinalstr);

            // definir situação
            String situacao;

            if (mediaFinal < 4){
                situacao = ("Reprovado!!");
            } else if (mediaFinal >= 6) {
                situacao = ("Aprovado!!");
            }
            else {
                situacao = ("Recuperação!!");
            }

            labelSituação.setText("Situação: " + situacao);


        });
        buttonLimpar.setOnAction(click -> {
            textFieldNome.clear();
            textFieldNota1.clear();
            textFieldNota2.clear();
            textFieldNota3.clear();
            textFieldNota4.clear();
            labelAluno.setText("Nome do aluno: ");
            labelSituação.setText("Situação: ");
            labelMediaFinal.setText("Média final: ");
            textFieldNome.requestFocus();

        });
        buttonSair.setOnAction(click -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Confirma a saída? ",ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPrecionado = alerta.showAndWait();
            if (botaoPrecionado.get() == ButtonType.YES){
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "Até logo");
                alerta2.showAndWait();
                System.exit(0);

            }

            //System.exit(0);
        });

    }

    private static String getString(double mediaFinal) {
        return String.format("%.2f", mediaFinal);
    }
}