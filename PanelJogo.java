package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJogo extends JPanel {

    private static JButton[][] botoes;
    private char atual = 'X';

    private int scoreX = 0, scoreO = 0;

    private ImageIcon vitoriaX = new ImageIcon(getClass().getResource("xdancing.gif"));
    private ImageIcon vitoriaO = new ImageIcon(getClass().getResource("odancing.gif"));

    public PanelJogo() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new GridLayout(3, 3));
        setBounds(0, 0, 600, 500);

        botoes = new JButton[3][3];
        adicionarBotoes();
    }

    private void definirEventos() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                botoes[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (botoes[finalI][finalJ].getText().equals("")) {
                            botoes[finalI][finalJ].setText(String.valueOf(atual));
                            if (atual == 'X') atual = 'O';
                            else atual = 'X';
                            verificarVitoria();
                        } else {
                            JOptionPane.showMessageDialog(null, "Esta área já foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
            }
        }
    }

    private void adicionarBotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton("");
                botoes[i][j].setBackground(Color.WHITE);
                botoes[i][j].setFont(new Font("Arial", Font.BOLD, 50));
                add(botoes[i][j]);
            }
        }
    }

    private void verificarVitoria() {

        // horizontal
        if (botoes[0][0].getText().equals("O") && botoes[0][1].getText().equals("O") && botoes[0][2].getText().equals("O") ||
                botoes[1][0].getText().equals("O") && botoes[1][1].getText().equals("O") && botoes[1][2].getText().equals("O") ||
                botoes[2][0].getText().equals("O") && botoes[2][1].getText().equals("O") && botoes[2][2].getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Vítória para o O. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaO);
            PanelAcoes.atualizarScoreO(1);
            redefinirBotoes();
        }

        if (botoes[0][0].getText().equals("X") && botoes[0][1].getText().equals("X") && botoes[0][2].getText().equals("X") ||
                botoes[1][0].getText().equals("X") && botoes[1][1].getText().equals("X") && botoes[1][2].getText().equals("X") ||
                botoes[2][0].getText().equals("X") && botoes[2][1].getText().equals("X") && botoes[2][2].getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Vítória para o X. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaX);
            PanelAcoes.atualizarScoreX(1);
            redefinirBotoes();
        }

        // vertical
        if (botoes[0][0].getText().equals("O") && botoes[1][0].getText().equals("O") && botoes[2][0].getText().equals("O") ||
                botoes[0][1].getText().equals("O") && botoes[1][1].getText().equals("O") && botoes[2][1].getText().equals("O") ||
                botoes[0][2].getText().equals("O") && botoes[1][2].getText().equals("O") && botoes[2][2].getText().equals("O")) {
            JOptionPane.showMessageDialog(null, "Vítória para o O. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaO);
            PanelAcoes.atualizarScoreO(1);
            redefinirBotoes();
        }

        if (botoes[0][0].getText().equals("X") && botoes[1][0].getText().equals("X") && botoes[2][0].getText().equals("X") ||
                botoes[0][1].getText().equals("X") && botoes[1][1].getText().equals("X") && botoes[2][1].getText().equals("X") ||
                botoes[0][2].getText().equals("X") && botoes[1][2].getText().equals("X") && botoes[2][2].getText().equals("X")) {
            JOptionPane.showMessageDialog(null, "Vítória para o X. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaX);
            PanelAcoes.atualizarScoreX(1);
            redefinirBotoes();
        }

        // diagonal principal
        if (botoes[0][0].getText().equals("O") && botoes[1][1].getText().equals("O") && botoes[2][2].getText().equals("O")){
            JOptionPane.showMessageDialog(null,"Vitória para o O. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaO);
            PanelAcoes.atualizarScoreO(1);
            redefinirBotoes();
        }
        if (botoes[0][0].getText().equals("X") && botoes[1][1].getText().equals("X") && botoes[2][2].getText().equals("X")){
            JOptionPane.showMessageDialog(null,"Vitória para o X. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaX);
            PanelAcoes.atualizarScoreX(1);
            redefinirBotoes();
        }

        // diagonal secundária
        if (botoes[0][2].getText().equals("O") && botoes[1][1].getText().equals("O") && botoes[2][0].getText().equals("O")){
            JOptionPane.showMessageDialog(null,"Vitória para o O. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaO);
            PanelAcoes.atualizarScoreO(1);
            redefinirBotoes();
        }
        if (botoes[0][2].getText().equals("X") && botoes[1][1].getText().equals("X") && botoes[2][0].getText().equals("X")){
            JOptionPane.showMessageDialog(null,"Vitória para o X. Parabéns!!!","Vitória",JOptionPane.INFORMATION_MESSAGE,vitoriaX);
            PanelAcoes.atualizarScoreX(1);
            redefinirBotoes();
        }

        // empate
        if (!botoes[0][0].getText().isEmpty() && !botoes[0][1].getText().isEmpty() && !botoes[0][2].getText().isEmpty()
        && !botoes[1][0].getText().isEmpty() && !botoes[1][1].getText().isEmpty() && !botoes[2][1].getText().isEmpty()
        && !botoes[2][0].getText().isEmpty() && !botoes[2][1].getText().isEmpty() && !botoes[2][2].getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Infelizmente o jogo empatou! Não houveram vencedores.");
            PanelAcoes.atualizarEmpate(1);
            redefinirBotoes();
        }

    }

    public static void redefinirBotoes(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                botoes[i][j].setText("");
            }
        }
    }

}