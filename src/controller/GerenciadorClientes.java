package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class GerenciadorClientes {

    private static final String ARQUIVO = "clientes.txt";
    private List<Cliente> clientes = new ArrayList<>();


    /// Adicionar Cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Buscar Cliente
    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente c : clientes) {
            if(c.getCpf().equals(cpf))
            return c;
            
        }
        return null;
    }

    // Remove Cliente
    public boolean removerCliente(String cpf) {
        Cliente cliente = buscarClientePorCPF(cpf);

        if(cliente != null) {
            clientes.remove(cliente);
            return true;
        }

        return false;
    }

    // Listar Cliente 
    public List<Cliente> listarClientes() {
        return clientes;
    }

    // Para o txt
    public void salvar() {
        try(PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
            for(Cliente c : clientes) {
                pw.println(c.toText());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes:" + e.getMessage());
        }
    }

    public void carregar() {
        File file = new File(ARQUIVO);
        if(!file.exists()) return;
        clientes.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while((linha = br.readLine()) != null) {
                clientes.add(Cliente.fromText(linha));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes:" + e.getMessage());
            
        }
    }

}
