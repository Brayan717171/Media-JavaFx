package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
            System.out.println("Botão cliado");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //calcular a média
            //obter as notas
            double nota1 = Double.parseDouble(textFieldNota1.getText());

            String nota2str = textFieldNota2.getText();
            double nota2 = Double.parseDouble(nota2str);

            String nota3str = textFieldNota3.getText();
            double nota3 = Double.parseDouble(nota3str);

            String nota4str = textFieldNota4.getText();
            double nota4 = Double.parseDouble(nota4str);

            double mediaFinal = (nota1 + nota2 + nota3 + nota4) / 4;
            String mediaFinalstr = String.format("%.2f", mediaFinal);

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

    }
}