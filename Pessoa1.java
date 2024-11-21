import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pessoa1 extends JFrame implements ActionListener {
    private JLabel l_num=new JLabel("Número:");
    private JTextField tf_num = new JTextField(20);
    private JLabel l_nome=new JLabel("Nome:");
    private JTextField tf_nome = new JTextField(20);
    private JLabel l_sexo=new JLabel("Sexo (M/F):");
    private JTextField tf_sexo = new JTextField(20);
    private JLabel l_idade=new JLabel("Idade:");
    private JTextField tf_idade = new JTextField(20);
    private JPanel p1=new JPanel(new GridLayout(4, 2));

    private JButton btn_ok = new JButton("OK");
    private JButton btn_limpar = new JButton("Limpar");
    private JButton btn_mostrar = new JButton("Mostrar");
    private JButton btn_sair = new JButton("Sair");
    private JPanel p2=new JPanel(new FlowLayout());

    Pessoa UmaPessoa = new Pessoa();

    Pessoa1(String tit, int larg, int alt, int col, int lin) {
        super(tit);
        setSize(larg,alt);
        setLocation(col,lin);
        setLayout(new BorderLayout());

        tf_num.addActionListener(this);
        tf_num.setEditable(false);
        tf_nome.addActionListener(this);
        tf_sexo.addActionListener(this);
        tf_idade.addActionListener(this);

        btn_ok.addActionListener(this);
        btn_limpar.addActionListener(this);
        btn_mostrar.addActionListener(this);
        btn_sair.addActionListener(this);

        p1.add(l_num);
        p1.add(tf_num);
        p1.add(l_nome);
        p1.add(tf_nome);
        p1.add(l_sexo);
        p1.add(tf_sexo);
        p1.add(l_idade);
        p1.add(tf_idade);

        p2.add(btn_ok);
        p2.add(btn_limpar);
        p2.add(btn_mostrar);
        p2.add(btn_sair);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_ok) {
            String sexoInput = tf_sexo.getText().toUpperCase();
            if (!sexoInput.equals("M") && !sexoInput.equals("F")) {
                JOptionPane.showMessageDialog(this, "ERRO: Digite somente 'M' ou 'F' para o sexo.");
                tf_sexo.requestFocus();
                tf_sexo.setText("");
            } else {
                    if (tf_nome.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "ERRO: Digite um nome.");
                        tf_nome.requestFocus();
                    } else {
                        try {
                            UmaPessoa.setIdade(Integer.parseInt(tf_idade.getText()));
                            UmaPessoa.setKp();
                            UmaPessoa.setNome(tf_nome.getText());
                            UmaPessoa.setSexo(tf_sexo.getText().charAt(0));
                            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso.");
                        } catch (NumberFormatException idade) {
                            JOptionPane.showMessageDialog(this, "ERRO: Digite um número inteiro para a idade.");
                            tf_idade.requestFocus();
                            tf_idade.setText("");
                        }
                    }
            }
        }
        if (e.getSource() == btn_limpar) {
            tf_num.setText("");
            tf_nome.setText("");
            tf_sexo.setText("");
            tf_idade.setText("");
        }
        if (e.getSource() == btn_mostrar) {
            if (UmaPessoa.getNome() != "") {
                tf_num.setText("" + UmaPessoa.getKp());
                tf_nome.setText("" + UmaPessoa.getNome());
                tf_sexo.setText("" + UmaPessoa.getSexo());
                tf_idade.setText("" + UmaPessoa.getIdade());
            } else {
                JOptionPane.showMessageDialog(this, "ERRO: Primeiro digite os dados de uma pessoa.");
            }
        }
        if (e.getSource() == btn_sair) {
            System.exit(0);
        }
    }

}
