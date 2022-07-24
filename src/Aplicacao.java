import java.util.Scanner;

class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%n----------------------------------%n");
            System.out
                    .printf("Suas Opções:%n" +
                            "%n%nComando de login - LOG" +
                            "%nComando para encerrar o programa - END%n");
            System.out.printf("----------------------------------%n%n");

            String line = scanner.nextLine();
            String ui[] = line.split(" ");

            if (ui[0].equalsIgnoreCase("END")) {
                break;
            } else if (ui[0].equalsIgnoreCase("LOG")) {
                Login login = new Login();

                while (true) {
                    try {
                        login.acessoLogin(ui[1], ui[2]);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Login inválido!");
                    }
                    break;
                }

            } else {
                System.out.printf("%nComando inválido!");
            }
        }
        scanner.close();
    }
}
