public class Pessoa {
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    Pessoa() {
        nome = "";
        sexo = '\0';
        idade = 0;
    }

    Pessoa(String nome, char sexo, int idade) {
        kp++;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public void setKp() {
        kp++;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }
}
