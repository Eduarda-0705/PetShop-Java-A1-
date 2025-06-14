package model;

public class Cliente {

    private String nome;
    private String telefone;
    private String cpf;
    

    public Cliente(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Para o txt
    public String toText() {
        return nome + ";" + cpf + ";" + telefone;
    }

    public static Cliente fromText(String texto) {
        String[] partes = texto.split(";");
        return new Cliente(partes[0], partes[1], partes[2]);
    }


    @Override
    public String toString() {
        return "\nNome:" + nome +
                "\nTelefone:" + telefone +
                "\nCPF:" + cpf;
    }



}
