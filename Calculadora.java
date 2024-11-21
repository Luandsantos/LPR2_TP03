import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame{
    private double memoria;
    private String operacao = "";
    private JTextField txt_operacao;
    private JTextField txt_resultado;

    public Calculadora() {
        setTitle("Exemplo de GridLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 210);
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

        txt_operacao = new JTextField(15);
        add(txt_operacao);

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            add(botao);
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String comando = e.getActionCommand();
                    
                    switch (comando) {
                        case "=":
                        try {
                            double valorAtual = Double.parseDouble(txt_resultado.getText());
                            switch (operacao) {
                                case "+": 
                                    memoria += valorAtual; 
                                    break;
                                case "-": 
                                    memoria -= valorAtual; 
                                    break;
                                case "*": 
                                    memoria *= valorAtual; 
                                    break;
                                case "/": 
                                    if (valorAtual != 0) {
                                        memoria /= valorAtual;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ERRO: Não é possível dividir por zero.");
                                        memoria = 0;
                                    }
                                    break;
                            }
                            txt_resultado.setText(String.valueOf(memoria));
                            operacao = "";
                            } catch (NumberFormatException ex) {
                                txt_resultado.setText("Erro");
                            }
                            break;
                        case "+": case "-": case "*": case "/":
                            try {
                                    memoria = Double.parseDouble(txt_resultado.getText());
                                    operacao = comando;
                                    txt_resultado.setText("");
                            } catch (NumberFormatException ex) {
                                    txt_resultado.setText("Erro");
                            }    
                            break; 
                        case "C":
                            memoria = 0;
                            operacao = "";
                            txt_resultado.setText("");    
                            break;
                        default: 
                            txt_resultado.setText(txt_resultado.getText() + comando);
                            break;
                    }
                }
            });
        }

        
        txt_resultado = new JTextField(10);   
        add(txt_resultado);    

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}

 