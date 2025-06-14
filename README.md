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
- Servico: É uma classe abstrata que representa um serviço genérico. As subclasses ServicoBanho e ServicoHigienico herdam dela e implementam a interface ServicoPet.
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
- Para executar o projeto, basta abrir o diretório no VS Code com suporte a Java, compilar a classe Principal.java no pacote view e utilizar o menu via console.
- O sistema permite cadastrar clientes, cadastrar pets associados ao cliente, listar os dados, registrar um serviço e remover um cliente que junto remove o pet associado a um cliente. Você só pode cadastrar um Pet se tiver um CPF de um tutor válido, e ao encolher um serviço o seu Pet tem que estar cadastrado. 
Os dados do Pet e Cliente são salvos em arquivos .txt

## Uso do ChatGpt
- O Chat foi utilizado para análise dos erros e códigos que não estávamos conseguindo aplicar corretamente, como por exemplo no case 5, de registrar o serviço para o pet, onde foi utilizado um laço de repetição para as escolhas do serviço.
- Ele nos auxiliou nisso e também em entender por que o .txt não estava funcionando. Utilizamos ele para compreender e identificar o que estávamos fazendo de errado, no caso do .txt estavamos chamando o métódo carregar() mas a gente esqueceu de colocar nos case apropriados o método salvar() junto com a lista que estavamos salvando.

## Referências e Recursos
- Utilizamos principalmente as aulas 23 e 24 como base para a construção do projeto, além da Atividade 3, que serviu como referência para organizar o código e aplicar os conceitos de orientação a objetos.
- A escolha do tema “Pet Shop” surgiu a partir do nosso projeto  apresentado na disciplina de Design de Software, onde trabalhamos com o design de um sistema de Pet Shop. Achamos interessante aproveitar essa ideia e aplicar os conceitos em Java. 

O trabalho foi deselvolvido em dupla
- Maria Eduarda Rosa da Costa
- Maurico Martins de Castro Regnel
