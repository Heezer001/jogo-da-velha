package jogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiInicio extends JFrame {

    private static GuiInicio frame;

    private JTextField jogador1, jogador2;
    private JButton btJogar;

    public GuiInicio(){
        inicializarComponentes();
        definirEventos();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void inicializarComponentes(){

        setLayout(null);
        setBounds(0,0,1000,562);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("inicio.png")));
        background.setBounds(0,0,1000,562);

        jogador1 = new JTextField();
        jogador1.setBounds(380,205,430,35);

        jogador2 = new JTextField();
        jogador2.setBounds(380,305,430, 35);

        btJogar = new JButton("");
        btJogar.setBounds(370,420,300,90);
        btJogar.setContentAreaFilled(false);
        btJogar.setBorderPainted(false);

        add(jogador1);
        add(jogador2);

        add(btJogar);

        add(background);

    }

    private void definirEventos(){
        btJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GuiJogo g = new GuiJogo();
                g.criarJogo(jogador1.getText(), jogador2.getText());
            }
        });
    }

    public static void criarInicio(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new GuiInicio();
                frame.setVisible(true);
            }
        });
    }

}