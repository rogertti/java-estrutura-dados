package estrutura_dados; //precisa ser alterado para o seu projeto
import java.util.Scanner;

class product {
    String descricao;
    int quantidade;
    product prev;
    product next;
}

public class lista_dupla { //lista_dupla é o nome do arquivo java, deve ser alterado para o nome do seu arquivo
    public static Scanner keyboard = new Scanner(System.in);

    static product addProductEnd(product finicio) {
        product input = new product();

        System.out.println("Informe a descrição do produto:");
        input.descricao = keyboard.nextLine();
        input.descricao = keyboard.nextLine();
        System.out.println("Informe a quantidade:");
        input.quantidade = keyboard.nextInt();
        input.next = null;
        input.prev = null;

            if(finicio == null) {
                return input;
            } else {
                product aux = finicio;
                while (aux.next != null) {
                    aux = aux.next;
                }
                aux.next = input;
                input.prev = aux;
                return finicio;
            }
    }

    static void showProducts(product finicio) {
        if(finicio == null) {
            System.out.println("Lista de compras vazia.");
        } else {
            product aux = finicio;
            int c = 1;

                while(aux != null) {
                    System.out.println(c + " > " + aux.descricao + " | quantidade: " + aux.quantidade);
                    aux = aux.next;
                    c++;
                }
        }
    }

    static product deleteProduct(product finicio) {
        product input = new product();

        System.out.println("Qual produto deseja remover?");
        //String descricao = keyboard.nextLine();
        input.descricao = keyboard.nextLine();
        input.descricao = keyboard.nextLine();
        
            if (finicio == null) {
                System.out.println("Lista de compras vazia.");
            } else {
                product aux = finicio;

                    while(aux != null) {
                        if(aux.descricao.equalsIgnoreCase(input.descricao)) {
                            if(aux.prev != null && aux.next != null){ // se o item está no meio de dois itens
                                System.out.println("--> Produto " + input.descricao + " removido do meio da lista!");
                                
                                product prev = aux.prev;
                                product posterior = aux.next;
                                
                                prev.next = posterior;
                                posterior.prev = prev; 
                                aux.prev = null;
                                aux.next = null;
                                
                                return finicio;
                            } else if(aux.prev == null && aux.next == null) { //se o item é o unico da lista
                                System.out.println("> Produto " + input.descricao + " removido, a lista agora está vazia.");
                                
                                return null;
                            } else if(aux.prev == null && aux.next != null) { // se o item é o primeiro da lista
                                System.out.println("> Produto " + input.descricao + " removido do inicio da lista.");
                                product posterior = aux.next;
                                
                                posterior.prev = null;
                                aux.next = null;
                                
                                return posterior;
                            } else { // se o item está no final da lista
                                System.out.println("> Produto " + input.descricao + " removido do fim da lista.");
                                
                                product prev = aux.prev;
                                
                                prev.next = null;
                                aux.prev = null;
                                
                                return finicio;
                            }
                        }

                        aux = aux.next;
                    }
            }
        return finicio;
    }

    static void menu() {
        System.out.println();
        System.out.println("1 - Adicionar produto na lista");
        System.out.println("2 - Exibir lista de produtos");
        System.out.println("3 - Remover produto da lista");
        System.out.println("4 - Sair");
        System.out.println();
    }
  
    public static void main(String[] args) {
        product inicio = null;
        int i = 0;

            while (true) {
                menu();

                i = keyboard.nextInt();
                
                    switch (i) {
                        case 1:
                            inicio = addProductEnd(inicio);
                            break;
                        case 2:
                            showProducts(inicio);
                            break;
                        case 3:
                            inicio = deleteProduct(inicio);
                            break;
                        case 4:
                            System.out.println("Saiu do Sistema");
                            keyboard.close();
                            return;
                        default:
                            System.out.println("Saiu do Sistema");
                            keyboard.close();
                            return;

                    }
            }
    }
}
