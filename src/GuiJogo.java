package jogo;

import javax.swing.*;
import java.awt.*;

public class GuiJogo extends JFrame {

    private static GuiJogo frame;
    public static Container container;

    public static String jogador1, jogador2;

    public GuiJogo(){
        inicializarComponentes();
        definirEventos();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void inicializarComponentes(){

        setLayout(null);

        setBounds(0,0,1000,520);
        container = getContentPane();

        JPanel panelJogo = new PanelJogo();
        panelJogo.setBounds(0,0,600,500);
        panelJogo.setBackground(Color.BLACK);

        JPanel panelAcoes = new PanelAcoes(jogador1, jogador2);
        panelAcoes.setBounds(600,0,400,500);

        container.removeAll();
        container.add(panelJogo);
        container.validate();
        container.add(panelAcoes);
        container.validate();

    }

    private void definirEventos(){

    }

    public void criarJogo(String jogador1, String jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new GuiJogo();
                frame.setVisible(true);
            }
        });
    }

}