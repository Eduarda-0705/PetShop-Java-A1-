package view;

import controller.GerenciadorClientes;
import controller.GerenciadorPets;
import model.Cliente;
import model.Pet;
import model.ServicoBanho;
import model.ServicoHigienico;
import model.ServicoPet;

public class Principal {

    public static void main(String[] args) {

        String nome,raca, telefone;
        String cpf;
        int op;
        int idade;

        GerenciadorClientes ListaClientes =  new GerenciadorClientes();
        GerenciadorPets ListaPets = new GerenciadorPets();

        ListaClientes.carregar();
        ListaPets.carregar(ListaClientes);

        do {

            System.out.println("\n===== MENU PETSHOP ====");
            System.out.println("1) Cadastrar Cliente");
            System.out.println("2) Cadastrar Pet");
            System.out.println("3) Listar Clientes");
            System.out.println("4) Listar Pet de um Cliente");
            System.out.println("5) Registrar Serviço para um Pet");
            System.out.println("6) Remover Cliente(junto com o seu Pet)");
            System.out.println("0) Sair");
            System.out.println("Informe uma opção:");
            op = Console.lerInt();

            switch (op) {

                //Cadastrar o Cliente
                case 1: System.out.println("=== Cadastro de Cliente ===");
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Telefone:");
                telefone = Console.lerString();
                System.out.print("CPF:");
                cpf = Console.lerString();

                Cliente cliente = new Cliente(nome, telefone, cpf);
                ListaClientes.adicionarCliente(cliente);
                ListaClientes.salvar();


                System.out.println("\nCliente cadastrado com sucesso!");

                break;


                //Cadastrar o Pet 
                case 2: System.out.println("=== Cadastro de Pet ===");
                
                // Se tiver um Cliente cadastro podemos cadastrar um Pet, se não restorna que o tutor não existe
                System.out.print("CPF do Tutor:");
                cpf = Console.lerString();
                Cliente tutor = ListaClientes.buscarClientePorCPF(cpf);

                if(tutor != null) {
                    
                System.out.print("Nome do Pet: ");
                nome = Console.lerString();
                System.out.print("Idade:");
                idade = Console.lerInt();
                System.out.print("Raça:");
                raca = Console.lerString();

                Pet pet = new Pet(nome, idade, raca, tutor);
                ListaPets.adicionarPet(pet);
                ListaPets.salvar();

                System.out.println("\nPet cadastrado com sucesso!");
                }
                else{
                    System.out.println("Tutor não encontrado.");
                }

                break;

                //Lintando os Clientes
                case 3:
                System.out.println("\n=== Lista dos Clientes ===");
                for(Cliente c : ListaClientes.listarClientes())
                System.out.println(c);
                break;

                // Listar os Pets que pertencem a um Cliente
                case 4:
                System.out.println("Informe o CPF do tutor:");
                cpf = Console.lerString();
                System.out.println("\n=== Lista dos Pets ===");

                for (Pet p : ListaPets.listarPetCliente(cpf)) {
                    System.out.println(p);
                    
                }
                break;

                // REGISTRAR SERVIÇO PARA O PET
                case 5: 
                System.out.print("Nome do Pet: ");
                nome = Console.lerString();
                Pet pet = ListaPets.buscarPetNome(nome);

                if (pet != null) {
                    System.out.println("Pet encontrado: " + pet.getNome());
                    System.out.println("\n=== Serviços disponíveis: ===");

                    ServicoPet[] opcoes = {
                    new ServicoBanho(false, pet),
                    new ServicoBanho(true, pet),
                    new ServicoHigienico(pet)
                };

                for (int i = 0; i < opcoes.length; i++) {
                    System.out.println((i + 1) + " ) " + opcoes[i].getDescricao() + " =  Preço: R$" + opcoes[i].getPrecoServico());
                }

                    System.out.print("Informe a opção desejada (1, 2 ou 3): ");
                    int tipo = Console.lerInt();

                if (tipo >= 1 && tipo <= 3) {
                    ServicoPet servico = opcoes[tipo - 1];

                if (servico instanceof ServicoPet) {
                       System.out.println("\nServiço registrado para " + pet.getNome() + ": ");
                        System.out.println("Descrição: " + servico.getDescricao());
                        System.out.println("Preço: R$" + servico.getPrecoServico());
                }


             } else {
                System.out.println("Opção inválida! Digite novamente."); }
            } else {
                 System.out.println("Pet não encontrado.");}
             break;


                // Remover Cliente (junto remove o Pet dele também)
                case 6: 
                System.out.print("CPF do Cliente: ");
                cpf = Console.lerString();

                if(ListaClientes.removerCliente(cpf)){
                    ListaPets.removerPetCliente(cpf);
                    System.out.println("Cliente e seu Pet removidos com sucesso!");

                    // Isso é para atualizar o nosso .txt quando removemos um Cliente e seu Pet
                    ListaClientes.salvar();
                    ListaPets.salvar();


                }else{
                    System.out.println("Cliente não encontrado.");
                }
                break;

                // Acabou a execução
                case 0:
                System.out.println("Programa Finalizado.");
                break;

                //Opção inválida
                default:
                System.out.println("Opção Inválida. Digite novamente!");

               
            }
            
        } while (op != 0);
        
    }

}
