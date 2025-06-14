package model;

import controller.GerenciadorClientes;

public  class Pet {

    private String nome;
    private int idade;
    private String raca;
    private Cliente tutor;

    public Pet(String nome, int idade, String raca,  Cliente tutor) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.tutor = tutor;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getTutor() {
        return tutor;
    }

    public void setTutor(Cliente tutor) {
        this.tutor = tutor;
    }

    // Para o txt
    public String toText() {
        return nome + ";" + raca + ";" + idade + ";" + tutor.getCpf();
    }

    public static Pet fromText(String texto, GerenciadorClientes ListaClientes){
        String[] partes = texto.split(";");
        String nome = partes[0];
        String raca = partes[1];
        int idade = Integer.parseInt(partes[2]);
        Cliente tutor = ListaClientes.buscarClientePorCPF(partes[3]);
        return new Pet(nome, idade, raca, tutor);
        
    }
    @Override
    public String toString() {
        return "\nNome:" + nome +
                "\nIdade:" + idade +
                "\nRaça:" + raca +
                "\nTutor:" + tutor.getNome();
    }
    



}
