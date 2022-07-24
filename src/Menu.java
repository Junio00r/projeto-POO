import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private static Estoque estoque = new Estoque();
    private static String escolha;
    private static Carrinho carrinho;
    private static int quantidadeP;
    public ContaUsuario conta;

    // Menu do controlador do estoque/produtos disponíveis.
    // O controlador pode adicionar ou remover produtos do estoque.

    public static void menuControlador() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("%n%n---------------------------------------------%n");
            System.out.printf("%nEscolha uma das opções: %n%n" +
                    "[ 1 ] - Adicionar um produto no estoque%n" +
                    "[ 2 ] - Remover um produto do estoque%n" +
                    "[ 3 ] - Sair%n%n");
            System.out.printf("---------------------------------------------%n%n");
            sc.nextLine();

            // Scanner sc = new Scanner(System.in);
            String esc = sc.nextLine();

            if (esc.equals("1")) {
                try {
                    System.out.print("Digite o nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o valor do produto: ");
                    double valor = sc.nextDouble();

                    System.out.print("Digite a quantidade de produtos que quer adciconar: ");
                    int quantidade = sc.nextInt();

                    estoque.addProduto(new Produto(nome, valor, quantidade));
                    System.out.printf("%nProduto adicionado com sucesso! %n");

                    // Ler a quebra de linha (Irrelevante/Gambiarra)
                    sc.nextLine();

                } catch (ExceptionInInitializerError | InputMismatchException e) {
                    System.out.println("Erro: Erro ao adicionar%n");
                }
            } else if (esc.equals("2")) {
                String line = sc.next();
                String valor = sc.nextLine();

                if (estoque.rmEstoque(line, Double.parseDouble(valor))) {
                    System.out.printf("%n%nPRODUTO REMOVIDO COM SUCESSO!%n");
                }
                break;
            } else if (esc.equals("3")) {
                break;
            } else {
                System.out.printf("Comando inválido!%n%n");
            }
        }
    }

    // Menu do usuario. O menu do usuário não permite insirir produtos no estoque ou
    // mudar em teoria, ele só poderar comprar os produtos e inserir no carrinho.
    public static void menuUsuario(ContaUsuario conta) {

        Scanner input = new Scanner(System.in);

        if (conta.getCpf() == null || conta.getCpf() == " " || conta.getCpf() == "") {
            // Caso o usuário seja novo, ele não tem os dados importantes (CPF e NOME), pois
            // sua conta foi cadastrada agora, então é preciso ler esses dados.

            while (true) {
                System.out.printf("%nDigite o seu nome: ");

                // Lendo Nome do usuário
                String nome = input.nextLine();
                if (nome.equals(" ") || nome.equals("")) {
                    System.out.println("Nome Iválido");
                } else {
                    conta.setNome(nome);
                    break;
                }
            }

            // Lendo CPF
            while (true) {
                System.out.printf("Digite o seu CPF: ");
                String cpf = input.nextLine();

                if (Menu.verificaCPF(cpf) == false) {
                    System.out.println("CPF inválido");
                } else {
                    conta.setCPF(cpf);

                    System.out.printf("%n%nCONTA SALVA COM SUCESSO%n");
                    break;
                }
            }
        }

        while (true) {

            // Menu do usuário
            System.out.printf("%n%n--------------------------------------%n%n%n");
            System.out.printf("Escolha alguma das opções: %n%n" +
                    "[ 1 ] - Adicionar um produto no carrinho%n" +
                    "[ 2 ] - Remover um produto do carrinho%n" +
                    "[ 3 ] - Visualizar seus pedidos%n" +
                    "[ 4 ] - Finalizar pedido%n" +
                    "[ 5 } - Sair%n%n");
            System.out.printf("----------------------------------------%n%n");

            String opcao = input.next();

            if (opcao.equals("1")) {

                System.out.println("----------------------------------------");

                System.out.printf("%nEscolha um produto e insira o seu nome para adiciona-lo ao carrinho: %n%n");

                System.out.println(estoque.toString());

                System.out.printf("----------------------------------------%n");
                input.nextLine();

                while (true) {
                    escolha = input.next();

                    // Verifica se o usuário inseriu uma entrada inválida
                    if ((escolha.equals(" ") || escolha.equals(""))
                            && estoque.dispProdutos(escolha).equals(null)) {
                        System.out.println("Erro: Produto não existe no estoque!");

                    } else {
                        // Quantidade do produto selecionado a ser adicionado no carrinho
                        System.out.println("Insira a quantidade para adicionar: ");

                        while (true) {
                            try {
                                quantidadeP = input.nextInt();

                                if (quantidadeP > estoque.dispProdutos(escolha).getQuant()) {
                                    System.out.println("Quantidade indisponível!");

                                } else if (quantidadeP <= estoque.dispProdutos(escolha).getQuant()) {
                                    // Decrementando a quantidade desse no produto no estoque
                                    estoque.dispProdutos(escolha)
                                            .setQuantidade(estoque.dispProdutos(escolha).getQuant() - quantidadeP);

                                    // Instanciando a conta --> carrinho
                                    carrinho = conta.criaCarrinho(estoque.dispProdutos(escolha), quantidadeP);

                                    System.out.printf("%nPRODUTO INSERIDO COM SUCESSO!%n");
                                    break;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Quantidade inválida");
                            }
                            break;
                        }
                        break;
                    }
                }
                // Removendo produto do carrinho
            } else if (opcao.equals("2")) {
                while (true) {
                    try {
                        System.out.printf("Insira o nome e o valor do produto: %n");

                        String line = input.next();
                        String valor = input.nextLine();

                        if (conta.removeProduto(line, Double.parseDouble(valor))) {
                            System.out.printf("%n%nPRODUTO REMOVIDO COM SUCESSO!%n");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        // Caso o usuario digite apenas uma string lança essa esseção
                        System.out.println("Tente novmente!");
                    }
                }
            } else if (opcao.equals("3")) {
                // Mostra os pedidos
                if (carrinho.getProdutos() == null) {
                    System.out.println("Não há nenhum pedido feito");
                } else {
                    System.out.println(carrinho.toString());
                }
            } else if (opcao.equals("4")) {

                // Verifica se há produtos no carrinho, caso contrário, é finalizada essa seção
                if (carrinho.getProdutos() == null) {
                    System.out.println("Voce deve inserir um produto no carinho para finalizar um compra!");
                    break;
                } else {
                    System.out.printf("Digite o seu endereço completo: %n");

                    while (true) {
                        // Ler a quebra de linha (Irrelevante/Gambiarra)
                        input.nextLine();

                        String end = input.nextLine();

                        // Verifica se a entrada é válida
                        if (end.equals("") || end.equals(" ")) {
                            System.out.println("Endereço inválido!");

                            // Ler a quebra de linha (Irrelevante/Gambiarra)
                            input.nextLine();

                        } else {
                            conta.setEndereço(end);

                            // Formas de pagamento
                            System.out.printf("%n----------------------------------------%n%n");

                            System.out.printf("%nEscolha a forma de pagamento: %n" +
                                    "Cartao - 1 %n" +
                                    "À vista - 2%n%n");
                            System.out.printf("%n----------------------------------------%n");

                            // Caso a entrada seja válida, ler a forma de pagamento
                            while (true) {
                                String pag = input.next();

                                // Se a forma de pagamento for no cartao, então irei ler a quantidade de vezes
                                // em que será pago
                                if (pag.equals("1")) {
                                    System.out.printf("%nEm quantas vezes: ");

                                    // vezes
                                    int vezes = input.nextInt();

                                    // Total a pagar no cartao
                                    System.out.printf("%nTotal a pagar: %d de %.2f%n%n", vezes,
                                            carrinho.valorPagamento(escolha, pag, quantidadeP) / vezes);

                                    // Mostro os pedidos
                                    System.out.println(conta.toString());

                                    break;
                                } else if (pag.equalsIgnoreCase("2")) {

                                    System.out.printf("----------------------------------------%n%n");

                                    // Total a pagar a vista
                                    System.out.printf("Total a pagar: %.2f á vista%n%n",
                                            carrinho.valorPagamento(escolha, pag, quantidadeP));

                                    // Atribuo a variavel para salvar
                                    String arq = conta.toString();

                                    // Mostro os pedidos
                                    System.out.println(arq);

                                    Dadospermamentes.Write("pedidos.txt", arq);

                                    break;
                                } else if (pag.equalsIgnoreCase("END")) {
                                    break;
                                } else {
                                    System.out.printf("Forma de pagamento inválida!%n");
                                    input.nextLine();
                                }
                            }
                        }
                        break;
                    }
                }
            } else if (opcao.equals("5")) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    // Método para verificar se na entradas do CPF são números mesmo
    // Isso não torna o CPF válido, mas não quis me aprofundar nisso
    public static boolean verificaCPF(String cpf) {
        if (cpf.length() == 11) {
            for (int i = 0; i < 11; i++) {
                // Conforme a tabela ASCII
                if (cpf.charAt(i) < 48 || cpf.charAt(i) > 57) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
