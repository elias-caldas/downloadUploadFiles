
Projeto direcionado ao aprendizado de SpringBoot - Upload e Download de Arquivo

# Gerenciador de Upload e Download de Arquivos

Este é um projeto Java que oferece funcionalidades para fazer upload e download de arquivos. Ele foi desenvolvido usando o Spring Boot e permite que os usuários carreguem arquivos para um local específico e também baixem esses arquivos quando necessário.

## Funcionalidades Principais

- **Upload de Arquivos**: Os usuários podem fazer upload de arquivos para o servidor. Os arquivos são armazenados em um local configurado.

- **Download de Arquivos**: Os usuários podem baixar arquivos previamente enviados por nome.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java Development Kit (JDK)
- Apache Maven


## Configuração

1. Clone este repositório para sua máquina local.

2. Configure o banco de dados PostgreSQL no arquivo `application.properties` com as informações da sua instância de banco de dados.

3. Execute o aplicativo Spring Boot usando Maven:

   ```bash
   mvn spring-boot:run
   ```

4. O aplicativo estará acessível em `http://localhost:8080`.

## Como Usar

- Para fazer upload de um arquivo, faça uma solicitação POST para `/upload` com o arquivo como parte do formulário HTTP.

- Para baixar um arquivo, acesse `/downloadarquivo/{nomeArquivo}` no navegador, onde `{nomeArquivo}` é o nome do arquivo que você deseja baixar.

## Configuração de Armazenamento de Arquivos

Os arquivos enviados pelos usuários são armazenados em um local configurado no arquivo `application.properties`. Certifique-se de que esse diretório exista e tenha permissões de escrita.

## Personalização

Este projeto pode ser personalizado e expandido para atender às suas necessidades. Você pode adicionar recursos como autenticação de usuário, validação de arquivos ou restrições de tamanho de arquivo.

## Licença

Este projeto é distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para obter detalhes.

---

Este README fornece uma visão geral básica do projeto. Sinta-se à vontade para adicionar informações adicionais, como documentação mais detalhada ou requisitos de sistema, conforme necessário.
