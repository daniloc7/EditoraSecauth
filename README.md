# EditoraSecauth
Api Editora utilizando Spring Boot e Thymeleaf utilizando a autenticação do Amazon Cognito.

# Academicos: 
Danilo Carneito Christensen,

Fernando Sobutka,

Ricardo Harano Pinto

# Descrição da API

No ArtigoController, foi utilizado o ModelAndView para criar as páginas para colocar os métodos.

No método GET /listarartigos cria uma lista para imprimir os artigos.

No método POST /pesquisarartigo procura se tem algum artigo na lista de artigos com o texte que foi informado pelo usuário.

No método POST /salvarartigo salva o artigo que foi cadastrado.

No método PUT /updateartigo procura o artigo que quer modificar e deixa o usuário modificar.

No método DELETE /removerartigo remove o artigo que o usuário solicitar.

No método DELETE /removertudo remove os artigos que o usuário selecionar.
