# GoogleKeepTabajaraRedis

Versão simplificada do Google Keep, utilizando o padrão de projeto DAO (Data Access Object) para persistência de dados.

### 🛠️ Funcionalidades principais

* **Cadastro de anotações**: Permite criar novas anotações com título, data/hora, descrição, cor e foto.
* **Edição e exclusão**: Oferece a possibilidade de editar ou excluir anotações existentes.
* **Listagem e ordenação**: Exibe as anotações em uma lista, ordenadas por data/hora de criação.
* **Persistência de dados**: Utiliza o padrão DAO para persistir as anotações, facilitando a manutenção e escalabilidade do sistema.

### 🔧 Tecnologias utilizadas

* **Java**: Linguagem de programação principal do projeto.
* **DAO (Data Access Object)**: Padrão de projeto utilizado para abstrair o acesso aos dados.
* **Redis**: Banco de dados em memória utilizado para persistência das anotações.

### 📁 Estrutura do repositório

O repositório contém os seguintes arquivos principais:

* `README.md`: Documento que fornece informações sobre o projeto e instruções de uso.
* `GoogleKeepTabajara.java`: Classe principal que implementa a funcionalidade do Google Keep.
* `Anotacao.java`: Classe que representa uma anotação.
* `AnotacaoDAO.java`: Classe que implementa o padrão DAO para persistência das anotações.
* `RedisConnection.java`: Classe responsável pela conexão com o banco de dados Redis.

### 🚀 Como utilizar

1. Clone o repositório ou baixe os arquivos.
2. Configure o Redis em sua máquina ou utilize uma instância remota.
3. Compile e execute a classe `GoogleKeepTabajara.java`.
4. Interaja com o sistema através da interface de linha de comando.

### 📌 Observações

Este projeto foi desenvolvido como parte de uma atividade acadêmica e serve como exemplo de implementação do padrão DAO em Java, utilizando o Redis como sistema de persistência. É importante ressaltar que este projeto não possui uma interface gráfica avançada e é voltado para fins educacionais.
