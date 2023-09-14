import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    public void desenharLinha(String texto,int tamanho, int opcao){
        String espaco = "";
        int numLetra = texto.length();
        int numEspaco = tamanho - numLetra;
        for (int i=0; i < numEspaco; i++){
            espaco = espaco + " ";
        }
        System.out.println("#    "+ opcao + " - " + texto + espaco + "#" );
    }
    public void desenharMargem(int tamanho){
        String margem = "##########";
        for (int i=0; i < tamanho; i++) {
            margem = margem + "#";
        }
        System.out.println(margem);
    }

    public void escreverOpcoes(List<String> textoOpcoes, int tamanho){
        int numLinhas = textoOpcoes.size();
        int opcao = 0;
        for (String texto : textoOpcoes){
            opcao += 1;
            desenharLinha(texto, tamanho, opcao);
        }
    }
    public int criarMenu(List<String> textoOpcoes){
        int tamanhoLateral = 40;
        int opcaoEscolhida;

        desenharMargem(tamanhoLateral);
        escreverOpcoes(textoOpcoes, tamanhoLateral);
        desenharMargem(tamanhoLateral);
        System.out.println();
        opcaoEscolhida = criarInput();

        return opcaoEscolhida;
    }

    public int criarInput(){
        int opcaoEscolhida;

        System.out.println("Escolha uma opção:");
        Scanner scan = new Scanner(System.in);
        opcaoEscolhida = scan.nextInt();
        return opcaoEscolhida;

    }

}
