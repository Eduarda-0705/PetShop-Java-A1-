package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class GerenciadorPets {

    private static final String ARQUIVO = "pets.txt";
    private  List<Pet> pets =  new ArrayList<>();


    // Adidiconar Pet
    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    // Listar Pet
    public List<Pet> listarPetCliente(String cpf) {
        List<Pet> resultado = new ArrayList<>();

        for (Pet p : pets) {

            if(p.getTutor() != null && p.getTutor().getCpf().equals(cpf))
            resultado.add(p);
            
        }
        return resultado;
    }


    // Buscar Pet pelo Nome
    public Pet buscarPetNome(String nome) {
        for (Pet p : pets) {

            if(p.getNome().equalsIgnoreCase(nome))
            return p;
            
        }
        return null;
    }


    // Remover Pet do Cliente
    public void removerPetCliente(String cpf) {
        pets.removeIf(p ->  p.getTutor()  != null && p.getTutor().getCpf().equals(cpf));
    }


    // Para o txt
    public void salvar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))){
            for (Pet p : pets) {
                pw.println(p.toText());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pets:" + e.getMessage());
            
        }
    }


    public void carregar(GerenciadorClientes ListaClientes) {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;
        pets.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pets.add(Pet.fromText(linha, ListaClientes));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar pets: " + e.getMessage());
        }
    }

}
