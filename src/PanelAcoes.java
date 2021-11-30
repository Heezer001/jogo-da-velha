package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAcoes extends JPanel {

    private static JLabel scoreX, scoreO, tempoJogado, empates;
    private JButton btReiniciar, btSair;

    private static String jogador1, jogador2;

    private static int scoreXValor=0, scoreOValor=0, empatesValor=0;

    public PanelAcoes (String jogador1, String jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        setLayout(null);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("gradientblue.jpeg")));
        background.setBounds(0,0,400,520);

        scoreX = new JLabel("Vitórias "+jogador1+": "+String.valueOf(scoreXValor));
        scoreX.setBounds(30,100,400,30);
        scoreX.setFont(new Font("Arial",Font.BOLD,26));
        scoreX.setForeground(Color.WHITE);

        scoreO = new JLabel("Vitórias "+jogador2+": "+String.valueOf(scoreOValor));
        scoreO.setBounds(30,150,400,30);
        scoreO.setFont(new Font("Arial", Font.BOLD,26));
        scoreO.setForeground(Color.WHITE);

        empates = new JLabel("Empates: "+String.valueOf(empatesValor));
        empates.setBounds(30,200,400,30);
        empates.setFont(new Font("Arial",Font.BOLD,26));
        empates.setForeground(Color.WHITE);

        tempoJogado = new JLabel("0:00");

        btReiniciar = new JButton("Reiniciar");
        btReiniciar.setBounds(100,345,200,42);
        btReiniciar.setBackground(Color.WHITE);

        btSair = new JButton("Sair");
        btSair.setBounds(100,400,200,42);
        btSair.setBackground(Color.WHITE);

        add(scoreX);
        add(scoreO);
        add(empates);
        add(tempoJogado);

        add(btReiniciar);
        add(btSair);

        add(background);
    }

    private void definirEventos(){
        btReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelJogo.redefinirBotoes();
            }
        });
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Obrigado por jogar. Até a próxima.");
                System.exit(0);
            }
        });
    }

    public static void atualizarScoreX(int score){
        scoreXValor+=score;
        scoreX.setText("Vitórias "+jogador1+": "+String.valueOf(scoreXValor));
    }
    public static void atualizarScoreO(int score){
        scoreOValor+=score;
        scoreO.setText("Vitórias "+jogador2+": "+String.valueOf(scoreOValor));
    }
    public static void atualizarEmpate(int empate){
        empatesValor+=empate;
        empates.setText("Empates: "+String.valueOf(empatesValor));
    }

}