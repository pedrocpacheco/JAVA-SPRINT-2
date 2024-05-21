# Anallyzer 📈
Bem-vindo ao repositório do Anallyzer, um projeto focado em análise de e-mail marketing na área de ecommerce. 

<h1 id="autores">🤝 Integrantes</h2>
<table>
  <tr>
    <td align="center">
      <p>Mobile</p>
      <a href="https://github.com/nichol6s">
        <img src="https://avatars.githubusercontent.com/u/105325313?v=4" width="115px;" alt="Foto do Nicholas no GitHub"/><br>
        <sub>
          <strong>Nicholas Santos</strong>
        </sub>
      </a>
    </td>
    <td align="center">
      <p>IA</p>
      <a href="https://github.com/VitorKubica">
        <img src="https://avatars.githubusercontent.com/u/107961081?v=4" width="115px;" alt="Foto do Vitor no GitHub"/><br>
        <sub>
          <strong>Vitor Kubica</strong>
        </sub>
      </a>
    </td>
    <td align="center">
      <p>Database & C#</p>
      <a href="https://github.com/DuduViolante">
        <img src="https://avatars.githubusercontent.com/u/126472870?v=4" width="115px;" alt="Foto do Violante no GitHub"/><br>
        <sub>
          <strong>Eduardo Violante</strong>
        </sub>
      </a>
    </td>
    <td align="center">
      <p>Java</p>
      <a href="https://github.com/pedrocpacheco">
        <img src="https://avatars.githubusercontent.com/u/112909829?v=4" width="115px;" alt="Foto do Pedro no github"/><br>
        <sub>
          <strong>Pedro</strong>
        </sub>
      </a>
    </td>
    <td align="center">
        <p>DevOps & Compliance</p>
        <a href="https://github.com/biasvestka">
        <img src="https://avatars.githubusercontent.com/u/126726456?v=4" width="115px;" alt="Foto da Beatriz GitHub"/><br>
        <sub>
            <strong>Beatriz Svestka</strong>
        </sub>
      </a>
    </td>
  </tr>
</table>

## 🚀 Iniciando o projeto
```sh
#Clone o repositorio
$ git clone https://github.com/k-alm/Challenge-Java

#Clique com o botão direito na classe ApiAnallyzerApplication
#Run as -> Java Application
```
## 📊 Diagrama de Classes
![alt img](Documentação/Imagens/Diagrama.jpg)
## 🛢️ Modelo de Banco de Dados
![alt img](Documentação/Imagens/Modelo_Database.jpg)
## 🔗 Link do pitch:
- https://youtu.be/73gU17oIHiY

## Documentação da API
### Entidade Empresa
#### Endpoint: Criar Empresa
- Método: POST
- Rota: /empresas
- Descrição: Cria uma nova empresa.
- Corpo da Requisição:
  ```json
  {
    //ID Região de 1 à 5
    "idRegiao": 1,
    "nome": "Plusoft fake",
    "cnpj": "8158165831",
    "contato": "1515123131"
  }
#### Endpoint: Recuperar Empresa
- Método: GET
- Rota: /empresas/{id}
- Descrição: Recupera empresa com o ID especifico.
- Resposta da Requisição: /anallyzer/empresas/1
  ```json
  {
    "id": 2,
    "empresa": {
        "idRegiao": 2,
        "nome": "Plusoft fake",
        "cnpj": "8158165831",
        "contato": "1515123131"
    },
    "regiao": {
        "id": 2,
        "nome": "Sul",
        "cidade": {
            "id": 3,
            "nome": "Houston"
        },
        "campanhas": [],
        "empresas": [
            {
                "id": 1,
                "nome": "Plusoft fake",
                "cnpj": "8158165821",
                "contato": "1515123131"
            },
            {
                "id": 2,
                "nome": "Plusoft fake",
                "cnpj": "8158165831",
                "contato": "1515123131"
            }
        ]
     }
  }
### Entidade Cliente 
#### Endpoint: Criar Cliente
- Método: POST
- Rota: /clientes
- Descrição: Cria um novo cliente.
- Corpo da Requisição:
  ```json
  {
    "nome": "Lucas marques do voce sabia",
    "email": "lucas.marques@gmail.com",
    "dtNascimento": "2002-02-02",
      "idCampanha": 1,
      // Ids genero: 1,2 [F/M]
      "idGenero": 1,
      "idEscolaridade": 7,
      "idEstadoCivil": 1
  }	
#### Endpoint: Recuperar Cliente
- Método: GET
- Rota: /clientes/{id}
- Descrição: Recupera empresa com o ID especifico.
- Resposta da Requisição: /anallyzer/clientes/1
  ```json
  {
    "id": 1,
    "nome": "Lucas Marques",
    "email": "lucas.marques@gmail.com",
    "dtNascimento": "2002-02-02",
    "campanha": {
        "id": 1,
        "titulo": "Rogerio Ceni",
        "descricao": "Campanha do Rogerio Ceni",
        "dtCampanha": "2024-05-20",
        "empresa": {
            "id": 2,
            "nome": "Plusoft fake",
            "cnpj": "8158165831",
            "contato": "1515123131"
        }
    }
  }
### Entidade Campanha
#### Endpoint: Criar Campanha
- Método: POST
- Rota: /campanha
- Descrição: Cria um novo campanha.
- Corpo da Requisição:
  ```json
  {
    "idEmpresa": 2,
    // Ids regiao: 1 - 5
    "idRegiao": 1,
    "titulo": "Rogerio Ceni",
    "descricao": "Campanha do Rogerio Ceni"
  }		
#### Endpoint: Recuperar Campanha
- Método: GET
- Rota: /camapanha/{id}
- Descrição: Recupera campanha com o ID especifico.
- Resposta da Requisição: /anallyzer/campanha/1
  ```json
  {
    "id": 1,
    "campanha": {
        "idEmpresa": 2,
        "idRegiao": 1,
        "titulo": "Rogerio Ceni",
        "descricao": "Campanha do Rogerio Ceni"
    },
    "empresa": {
        "id": 2,
        "nome": "Plusoft fake",
        "cnpj": "8158165831",
        "contato": "1515123131"
    },
    "regiao": {
        "id": 1,
        "nome": "Oeste",
        "cidade": {
            "id": 1,
            "nome": "Los Angeles"
        },
        "campanhas": [
            {
                "id": 1,
                "titulo": "Rogerio Ceni",
                "descricao": "Campanha do Rogerio Ceni",
                "dtCampanha": "2024-05-20",
                "empresa": {
                    "id": 2,
                    "nome": "Plusoft fake",
                    "cnpj": "8158165831",
                    "contato": "1515123131"
                }
            }
        ],
        "empresas": []
    }
  }