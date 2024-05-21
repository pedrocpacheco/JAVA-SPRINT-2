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