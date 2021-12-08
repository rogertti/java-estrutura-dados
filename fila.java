package estrutura_dados; //precisa ser alterado para o seu projeto
import java.util.Scanner;

class pessoa {
    String nome;
    String cpf;
    String desc_atendimento;
    pessoa next;
}


public class fila { //fila é o nome do arquivo java, deve ser alterado para o nome do seu arquivo
    public static Scanner keyboard = new Scanner(System.in);
    
    static pessoa addClient(pessoa finicio) {
        pessoa input = new pessoa();

        System.out.println("Informe o nome do cliente: ");
        input.nome = keyboard.nextLine(); //bug do compilador ter
        input.nome = keyboard.nextLine(); //que repetir 2x a mesma linha.
        System.out.println("Informe o cpf do cliente: ");
        input.cpf = keyboard.nextLine();
        System.out.println("Informe o descrição do atendimento: ");
        input.desc_atendimento = keyboard.nextLine();
        input.next = null;

            if(finicio == null) {
                return input;
            } else {
                pessoa aux = finicio;

                    while(aux.next != null) {
                        aux = aux.next;
                    }

                aux.next = input;

                return finicio;
            }
    }

    static void showClient(pessoa finicio) {
        if(finicio == null) {
            System.out.print("Fila vazia");
        } else {
            int a = 1;

                while (finicio != null) {
                    System.out.println("Cliente " + a + " -> " + finicio.nome);
                    finicio = finicio.next;
                    a++;
                }
        }
    }

    static void searchClient(pessoa finicio) {
        String cpf;
        System.out.print("Entre com o cpf do cliente: ");
        cpf = keyboard.nextLine();
        cpf = keyboard.nextLine();

            if(finicio == null) {
                System.out.println("Cliente não encontrado.");
            } else {
                //pessoa aux = finicio;
                int c = 1;
                boolean found = false;

                    while(finicio != null) {
                        if(cpf.equals(finicio.cpf)) {
                            System.out.println("Cliente " + finicio.nome + " na posição " + c);
                            found = true;
                        }
                        
                        finicio = finicio.next;
                        c++;
                    }

                    if(!found) {
                        System.out.println("Cliente não encontrado");
                    }
        }
    }

    static pessoa deleteClient(pessoa finicio) {
        if(finicio == null) {
            System.out.print("Fila vazia");
            return finicio;
        } else {
            //method 1

            System.out.print("Cliente " + finicio.nome + " removido");
            finicio = finicio.next;

            // method 2

            //pessoa aux = finicio.next;

            //System.out.print("Cliente " + finicio.nome + " removido");
            
            //finicio.desc_atendimento = "";
            //finicio.next = null;
            //finicio = aux;
            
            return finicio;
        }
    }
    
    static void menu() {
        System.out.println();
        System.out.println("1 - Adicionar cliente");
        System.out.println("2 - Exibir fila");
        System.out.println("3 - Ver a posição pelo cpf");
        System.out.println("4 - Remover da fila");
        System.out.println("5 - Sair");
        System.out.println();
    }
    
    public static void main(String[] args) {
        pessoa inicio = null;
        //char letter = 0;
        int i = 0;

            while (true) {
                menu();

                i = keyboard.nextInt();

                    switch(i) {
                        case 1:
                            inicio = addClient(inicio);
                            break;
                        case 2:
                            showClient(inicio);
                            break;
                        case 3:
                            searchClient(inicio);
                            break;
                        case 4:
                            inicio = deleteClient(inicio);
                            break;
                        case 5:
                            System.out.println("Saiu do sistema");
                            keyboard.close();
                            return;
                        default:
                            System.out.println("Saiu do sistema");
                            keyboard.close();
                            return;
                    }
            }
    }
}
