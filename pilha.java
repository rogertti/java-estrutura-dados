package estrutura_dados; //precisa ser alterado para o nome do seu projeto
import java.util.Scanner;

class character {
    char letter;
    character next;
}

public class pilha {
    public static Scanner keyboard = new Scanner(System.in);

    static character addCharacter(character ftop, char fletter) {
        
        // verifica se fletter veio do menu ou se veio da função de inversão

        if(fletter == 0) {
            character input = new character();

            System.out.print("Informe o caracter que será adicionado: ");
            
            input.letter = keyboard.next().charAt(0);
            input.next = null;

                if(ftop == null) {
                    return input;
                } else {
                    input.next = ftop;
                    return input;
                }
        } else {
            character input = new character();
            
            input.letter = fletter;
            input.next = null;

                if(ftop == null) {
                    return input;
                } else {
                    input.next = ftop;
                    return input;
                }
        }
    }

    static void showTopToBottom(character ftop) {
        if(ftop == null) {
            System.out.println("Pilha de caracteres vazia");
            System.out.println();
        } else {
            character aux = ftop;
            int a = 1;

                while(aux != null) {
                    System.out.println("Caracter " + a + " > " + aux.letter);
                    aux = aux.next;
                    a++;
                }
        }
    }

    static void showBottomToUp(character ftop) {
        if (ftop == null) {
            System.out.println("Pilha de caracteres vazia");
            System.out.println();
        } else {
            character reverse = null;
            int a = 1;

                while(ftop != null) {
                    reverse = addCharacter(reverse, ftop.letter);
                    ftop = ftop.next;
                }
                
                while(reverse != null) {
                    System.out.println("Caracter " + a + " > " + reverse.letter);
                    reverse = reverse.next;
                    a++;
                }
        }
    }

    static void checkPalindrome(character ftop) {
        if(ftop == null) {
            System.out.println("Pilha de caracteres vazia");
            System.out.println();
        } else {
            character reverse = null;
            character aux = ftop;
            int b = 0;

                while(ftop != null) {
                    reverse = addCharacter(reverse, ftop.letter);
                    ftop = ftop.next;
                }
            
                while(aux != null && reverse != null) {
                    if (aux.letter != reverse.letter) {
                        b++;
                    }

                    aux = aux.next;
                    reverse = reverse.next;
                }

                if(b == 0) {
                    System.out.println("É um palíndromo");
                } else {
                    System.out.println("Não é um palíndromo");
                }
        }
    }

    static character removeCharacter(character ftop) {
        character aux = ftop;
        ftop = aux.next;
        System.out.println("Caracter removido");

        return ftop;
    }

    static void menu() {
        System.out.println();
        System.out.println("1 - Inserir caracter");
        System.out.println("2 - Mostrar pilha de cima para baixo");
        System.out.println("3 - Mostrar pilha de baixo para cima");
        System.out.println("4 - Verificar se forma um palíndromo");
        System.out.println("5 - Desempilhar caracteres");
        System.out.println("6 - Sair");
        System.out.println();
    }
    
    public static void main(String[] args) {
        character top = null;
        char letter = 0;
        int i = 0;

            while(true) {
                menu();

                i = keyboard.nextInt();

                    switch (i) {
                        case 1:
                            top = addCharacter(top, letter);
                            break;
                        case 2:
                            showTopToBottom(top);
                            break;
                        case 3:
                            showBottomToUp(top);
                            break;
                        case 4:
                            checkPalindrome(top);
                            break;
                        case 5:
                            top = removeCharacter(top);
                            break;
                        case 6:
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
