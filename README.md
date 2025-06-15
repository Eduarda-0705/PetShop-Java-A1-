=== Projeto Final ===
Tema: Pet Shop.

## Informações gerais do projeto.
O nosso projeto é um Sistema de Pet Shop, desenvolvido utilizando o padrão Model, View e Controller para organizar melhor as responsabilidades.
Nosso objetivo era permitir o cadastro de pets e clientes, além de possibilitar que o tutor escolhesse um serviço para o seu pet.

As principais funcionalidades implementadas foram:
- Cadastro e remoção de clientes (tutores);
- Cadastro e listagem de pets;
- Registro de serviços para os pets;
- Salvamento de dados em arquivos .txt.

## Informações sobre a Classe e suas relações.
O projeto foi dividido da seguinte forma: 
- Model: Contém as classes principais do sistema:
- Cliente: Representa o tutor. Contém nome, CPF e telefone.
- Pet: Representa o animal. Cada pet tem nome, raça, idade e um tutor (associação com Cliente).
- Servico: É uma classe abstrata que representa um serviço genérico. Ela tem um método abstract getDuracaoEstimada();.  As subclasses ServicoBanho e ServicoHigienico herdam dela e implementam a interface ServicoPet.
- ServicoPet (interface): Define os métodos getDescricao() e getPrecoServico(), utilizados para aplicar polimorfismo.

- Controller: Contém os gerenciadores responsáveis por controlar os dados
- GerenciadorClientes: Adiciona, remove, busca, lista e  salva clientes no arquivo clientes.txt.
- GerenciadorPets: Adiciona, remove, busca, lista e salva pets no arquivo pets.txt.

- View: É a classe Principal, responsável por interagir com o usuário via console, exibindo o menu e capturando as ações.

Relações utilizadas:
- Associação: Um Pet está associado a um Cliente como seu tutor.
- Composição: A relação entre Pet e Cliente também representa uma composição, já que um pet não existe no sistema sem estar vinculado a um cliente. Se o cliente for removido, os pets associados a ele também são removidos.
- Herança: ServicoBanho e ServicoHigienico herdam da classe abstrata Servico.
- Polimorfismo e Interface: Os serviços implementam a interface ServicoPet, permitindo trabalhar com diferentes tipos de serviço de forma genérica. Também usamos instanceof para verificar e aplicar comportamentos específicos.
- Agregação: As listas de Cliente e Pet nos gerenciadores (GerenciadorClientes e GerenciadorPets) representam agregações, já que os objetos podem existir independentemente fora dessas estruturas.

## Como executar o projeto.
- Para executar o projeto, basta abrir o diretório no VS Code com suporte a Java, compilar a classe Principal.java que está no pacote view e utilizar o menu via console.
  
- O sistema funciona por meio de um menu interativo e permite as seguintes operações:
- Primeiro, você deve cadastrar um cliente.
- Em seguida, é possível cadastrar um pet, que deve estar associado a um cliente já existente (ou seja, só é possível cadastrar um pet se o CPF do tutor já estiver cadastrado).
- Você pode listar todos os clientes cadastrados.
- Você pode também listar os pets relacionados a um cliente específico.
- É possível registrar um serviço para um pet, desde que o pet já esteja cadastrado.

- Os serviços disponíveis são:
1 - Banho com tosa completa
2 - Banho simples
3 - Tosa Higiênica
- Basta digitar o número correspondente ao tipo de serviço desejado.
- Também é possível remover um cliente. Ao remover um cliente, o pet associado a ele também será removido.
- Para encerrar o sistema, basta digitar 0 no menu principal.
- os dados de Clientes e Pets são salvos automaticamente em arquivos .txt, garantindo a persistência das informações entre as execuções do programa.

## Uso do ChatGpt
- O Chat foi utilizado para análise dos erros e códigos que não estávamos conseguindo aplicar corretamente, como por exemplo no case 5, de registrar o serviço para o pet, onde foi utilizado um laço de repetição para as escolhas do serviço.
- Ele nos auxiliou nisso e também em entender por que o .txt não estava funcionando. Utilizamos ele para compreender e identificar o que estávamos fazendo de errado, no caso do .txt estavamos chamando o métódo carregar() mas a gente esqueceu de colocar nos case apropriados o método salvar() junto com a lista que estavamos salvando.

## Referências e Recursos
- Utilizamos principalmente as aulas 23 e 24 como base para a construção do projeto, além da Atividade 3, que serviu como referência para organizar o código e aplicar os conceitos de orientação a objetos.
- A escolha do tema “Pet Shop” surgiu a partir do nosso projeto  apresentado na disciplina de Design de Software, onde trabalhamos com o design de um sistema de Pet Shop. Achamos interessante aproveitar essa ideia e aplicar os conceitos em Java. 

O trabalho foi deselvolvido em dupla
- Maria Eduarda Rosa da Costa
- Mauricio Martins de Castro Regnel
