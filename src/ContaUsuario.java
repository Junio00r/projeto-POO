import java.util.Random;

public class ContaUsuario extends Carrinho {
    private int id;
    private String endereço;
    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private Carrinho carrinho;
    private Random numero = new Random();

    public ContaUsuario(String email, String senha) {
        super(null, 0);
        this.email = email;
        this.senha = senha;
        id = numero.nextInt(2000, 4000);
    }

    public Carrinho criaCarrinho(Produto produto, int quantidade) {
        carrinho = new Carrinho(produto, quantidade);
        return carrinho;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        if (carrinho != null) {
            return String
                    .format("Produto:" + carrinho.toString() + "%nEndereço de entrega: " + endereço
                            + "%nNome do cliente: "
                            + nome
                            + "%nEmail: "
                            + email + "%nID da conta: " + id + "%n%n---------------------------------------------%n");
        }
        return String.format("%nNome: "
                + nome + "%nEmail: " + email + "%nID da conta: " + id + "%n%n");
    }
}