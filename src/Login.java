import java.util.List;
import java.util.ArrayList;

public class Login {
    private List<ControladorEstoque> logsControlador;
    private List<ContaUsuario> logsUsuarios;
    private ContaUsuario conta;

    public Login() {
        logsControlador = new ArrayList<>();
        logsUsuarios = new ArrayList<>();
    }

    // Login do usuário
    public void acessoLogin(String email, String senha) {
        while (true) {

            // Verificando se o log é dos controladores
            if (email.contains("e-EMPRESA@gmail.com") && senha.equals("adminadmin")) {

                for (ControladorEstoque e : logsControlador) {
                    if (e.getEmail().equals(email) && e.getSenha().equals(senha)) {
                        Menu.menuControlador();
                    } else if (e.getEmail().equals(email) && !e.getSenha().equals(senha)) {
                        System.out.println("Email ou Senha incorretos!");
                    }
                }
                logsControlador.add(new ControladorEstoque(email, senha));

                Menu.menuControlador();
                break;

                // Verificando se os login é dos usuários
            } else if (email.contains("gmail.com") || email.contains("hotmail.com")) {

                // Se houver um email e senha no Array das Contas De Usuário, então
                // basta mostrar o menu de usuario. Caso não haja, crio um novo usuário com seu
                // email e senha cadastrado e retorno.
                if (logsUsuarios.isEmpty()) {
                    conta = new ContaUsuario(email, senha);
                    logsUsuarios.add(conta);

                    Menu.menuUsuario(conta);
                } else {
                    for (ContaUsuario e : logsUsuarios) {
                        if (e.getEmail().equals(email) && e.getSenha().equals(senha)) {

                            Menu.menuUsuario(e);
                            break;

                        } else if (e.getEmail().equals(email) && !e.getSenha().equals(senha)) {
                            System.out.println("Email ou Senha incorreto!");
                            break;
                        } else if (!e.getEmail().equals(email) && !e.getSenha().equals(senha)) {

                            conta = new ContaUsuario(email, senha);
                            logsUsuarios.add(conta);

                            Menu.menuUsuario(conta);
                            break;
                        }
                    }
                }
                break;

            } else {
                System.out.println("Login inválido!");
                break;
            }
        }
    }
}