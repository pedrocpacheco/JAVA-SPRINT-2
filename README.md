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
      <a href="https://github.com/k-alm">
        <img src="https://avatars.githubusercontent.com/u/126576641?v=4" width="115px;" alt="Foto do Kauan no github"/><br>
        <sub>
          <strong>Kauan de Almeida</strong>
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

## 🛑 Listagem dos endpoints: 
Lembrando que a rota padrão começa com <b>"/anallyzer"</b>

| Endpoints         | Método | Ação                                                    |
|-------------------|--------|---------------------------------------------------------|
| /campanha{id}     | GET    | Retorna a campanha selecionada pelo o {id}              |
| /clientes/{id}    | GET    | Retorna o cliente selecionado pelo o id {id}            |
| /empresas/{id}    | GET    | Retorna a empresa selecionada pelo o {id}               |
| /campanha         | POST   | Cria uma nova campanha                                  |
| /clientes         | POST   | Cria um novo cliente                                    |
| /empresas         | POST   | Cria uma nova empresa                                   |
| /campanha/{id}    | PATCH  | Altera nome e descrição da campanha                     |
| /campanha/{id}    | DELETE | Deleta uma campanha                                     |
