public class Produto {
    private String nome;
    private double valor;
    private int quantidade;
    private int id;

    public Produto(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;

        // id do produto
        for (int i = 0; i <= 9999;) {
            this.id = i;
            break;
        }
    }

    // Métodos SETers
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quant) {
        this.quantidade = quant;
    }

    // Métodos GETers
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuant() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format(
                nome + "%nValor: " + valor + "%nQuantidade disponível: " + quantidade + "%n");
    }
}