import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pessoa3 extends JFrame implements ActionListener {
    private JLabel l_num=new JLabel("Número:");
    private JTextField tf_num = new JTextField(20);
    private JLabel l_nome=new JLabel("Nome:");
    private JTextField tf_nome = new JTextField(20);

    private JLabel l_sexo=new JLabel("Sexo (M/F):");
    private JRadioButton rb_sexo_m = new JRadioButton("M");
    private JRadioButton rb_sexo_f = new JRadioButton("F");
    private ButtonGroup bg_sexo = new ButtonGroup(); 

    private JLabel l_idade=new JLabel("Idade:");
    private JTextField tf_idade = new JTextField(20);
    private JPanel p1=new JPanel(new GridLayout(4, 2));

    private JButton btn_ok = new JButton("OK");
    private JButton btn_limpar = new JButton("Limpar");
    private JButton btn_mostrar = new JButton("Mostrar");
    private JButton btn_sair = new JButton("Sair");
    private JPanel p2=new JPanel(new FlowLayout());

    private JPanel p3 = new JPanel(new GridLayout(1, 2));

    Pessoa UmaPessoa = new Pessoa();

    Pessoa3(String tit, int larg, int alt, int col, int lin) {
        super(tit);
        setSize(larg,alt);
        setLocation(col,lin);
        setLayout(new BorderLayout());

        tf_num.addActionListener(this);
        tf_num.setEditable(false);
        tf_nome.addActionListener(this);
        
        rb_sexo_m.addActionListener(this);
        rb_sexo_f.addActionListener(this);

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
        bg_sexo.add(rb_sexo_m);
        bg_sexo.add(rb_sexo_f);
        p3.add(rb_sexo_m);
        p3.add(rb_sexo_f);
        p1.add(p3);
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
            if (tf_nome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ERRO: Digite um nome.");
                tf_nome.requestFocus();
            } else {
                try {
                    if (rb_sexo_m.isSelected()) {
                        UmaPessoa.setSexo('M');
                        UmaPessoa.setIdade(Integer.parseInt(tf_idade.getText()));
                        UmaPessoa.setKp();
                        UmaPessoa.setNome(tf_nome.getText());
                        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso.");
                    } else if (rb_sexo_f.isSelected()) {
                        UmaPessoa.setSexo('F');
                        UmaPessoa.setIdade(Integer.parseInt(tf_idade.getText()));
                        UmaPessoa.setKp();
                        UmaPessoa.setNome(tf_nome.getText());
                        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso.");    
                    } else {
                        JOptionPane.showMessageDialog(this, "ERRO: Escolha um sexo.");
                    }
                } catch (NumberFormatException idade) {
                    JOptionPane.showMessageDialog(this, "ERRO: Digite um número inteiro para a idade.");
                    tf_idade.requestFocus();
                    tf_idade.setText("");
                }
            }
        }
        if (e.getSource() == btn_limpar) {
            tf_num.setText("");
            tf_nome.setText("");
            bg_sexo.clearSelection();
            tf_idade.setText("");
        }
        if (e.getSource() == btn_mostrar) {
            if (UmaPessoa.getNome() != "") {
                tf_num.setText("" + UmaPessoa.getKp());
                tf_nome.setText("" + UmaPessoa.getNome());
                switch (UmaPessoa.getSexo()) {
                    case 'M':
                        rb_sexo_m.setSelected(true);
                        break;
                    case 'F':
                        rb_sexo_f.setSelected(true);
                        break;
                }
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