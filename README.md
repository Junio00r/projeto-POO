# E-commerce
Sistema de e-commerce de uma loja.
  
Este foi o meu projeto proposto na matéria de POO na faculdade que se baseia num ecommerce. Ademais, não há interface gráfica e há alguns problemas que não foram testados, além disso, não foram atentido todas as "funções" estabelecidas pelo professor. 
  
## Algumas das Implementações

### Login

Para o usuário iniciar, ele deve inserir um email e uma senha, caso seja um novo usuário é criado uma conta para o mesmo. Tem dois possíveis logs, onde o seu acesso dá ao determinado funcionalidades. O *login* do controlodar do estoque deve ter uma email que contenha *"e-EMPRESA@gmail.com"* e sua senha deve ser *adminadmin*. Já o login do usuário, o email deve conter *"hotmail.com"* ou *"gmail.com"*, caso seja novo, é lido o seu nome e CPF. Se for um usuário já existente, mostra sua conta.

### Menu

*Antes de mostrar os seus respectivos menus, é mostrado o estoque e os produtos contidos neles...*
  
* Usuário - *(No menu do usuário há 5 opções)*

  * 1 - Adicionar um produto no carrinho de compras 
  * 2 - Remover um produto do carrinho
  * 3 - Visualizar seus pedidos
  * 4 - Finalizar pedido
  * 5 - Sair

  1 - __Para adicionar um produto no carrinho, o usuário terá que inserir o nome dele e quantidade que quer inserir, caso o nome esteja errado ou não tenha             quantidade que ele quer adicionar de produtos disponível, o usuário terá que tentar novamente;
  2 - Para remover um produto do carrinho o usuário deve inserir o nome e valor do produto. Caso não haja produto, é retornado uma mensagem;
  3 - Se houver algum produto no seu carrinho, é mostrado como pedido (Isso não é de fato um pedido, mas eu não tinha tanto tempo para entregar, então não o fiz bem feito, uma gambiarra em outras palavras);
  4 - Para finalizar um pedido, deve conter pelo menos um produto no carrinho. Se houver, então é lido o seu endereço completo e a forma de pagamento (À vista ou     Cartão) e no final é mostrado um pequeno recibo da compra.;
  5 - Volta para a página de login;
  
  
  * Controlador do Estoque - *(No menu do controlador tem 3 oções)*
    * 1 - Adicionar um produto no estoque
    * 2- Remover um produto do estoque
    * 3 - Sair
   
    

  
