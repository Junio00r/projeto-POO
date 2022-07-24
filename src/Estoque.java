import java.util.List;
import java.util.ArrayList;

public class Estoque {
    private static List<Produto> estoque = new ArrayList<>();

    // Construtor
    public Estoque() {
        // Produtos criados manualmente para testes
        estoque.add(new Produto("XBOX ONE", 2000, 45));
        estoque.add(new Produto("CAMISAS DOS POWER RANGERS", 67.90, 38));
        estoque.add(new Produto("PS5", 10000, 4));
        estoque.add(new Produto("MONITOR DELL", 3100, 17));
        estoque.add(new Produto("PROCESSADOR i9", 3690, 54));
    }

    // Verifica se já existe um produto com essas especificações, caso haja
    // a quantidade é incrementada. E se não tiver é adicionado
    // um produto no estoque
    public boolean addProduto(Produto produto) {
        for (Produto e : estoque) {
            if (e.equals(produto) && e.getValor() == produto.getValor()) {
                e.setQuantidade(e.getQuant() + produto.getQuant());
                return false;
            }
        }

        estoque.add(produto);
        return true;
    }

    // Remove um produto do estoque
    public boolean rmEstoque(String nome, double valor) {
        try {
            for (Produto e : estoque) {
                if (e.getNome().equalsIgnoreCase(nome) && e.getValor() == valor) {
                    estoque.remove(e);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Este produto não existe no estoque! Tente novamente%n");
        }
        return false;
    }

    public Produto dispProdutos(String produto) {
        // Procura o produto no estoque
        for (Produto e : estoque) {
            if (e.getNome().equalsIgnoreCase(produto)) {
                return e;
            }
        }
        return null;
    }

    public String toString() {

        System.out.printf("Produtos disponíveis no estoque: %n%n");

        for (Produto e : estoque) {
            System.out.println(e);
        }

        return "";
    }

}