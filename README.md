## API - tracknme-backend

Api que simula o gerenciamente dos funcionários de uma empres. 

### Projeto criado utilizando:

API desenvolvinda utilizando os padrão REST e MVC.

- Java 11.
- Spring Boot.
- Spring Data.
- Jsoup

### Documentação API

- #### Classes

  - CepBo: Classe criada com padrão Bo(Usado para encapsular a lógica de negócio para um objeto). Classe usada para consumir o webservice Viacep.
  - FuncionarioModel: Classe entidade, usada para mapear os atributos do funcionário.
  - FuncionarioController: Classe controller, usadas para mapear os endpoints necessários para fazer GET, PUT, POST, DELETE.
  - FuncionarioService: Classe de serviço, usada para fazer a regra ne negócio da aplicação.

- #### Inteface

  - FuncionarioRepository: Interface usada para fazer o CRUD da aplicação e buscas especificas.

- #### Test

  - FuncionarioControllerTest: Classe de teste criada para testar os endpoit da classe controller.

