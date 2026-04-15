import java.util.Scanner;

public class cafe {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int codigo; 
        float cesta = 0;
        String continuar;
        String nome;
        int qtdCookie = 0;
        float desconto = 0;
        float descontoMenor;
        char doar;
        float doacao=0;
        float tota=0;
        float qtdpedidos= 0;
        int qtdCapuccino=0;
        float totalDoacao = 0;

        System.out.println("================== PRODUTOS DA LOJA ==================");
        System.out.println("CODIGO  =====   PRODUTO   =====    VALOR");
        System.out.println("  1     ===== CAFÉ EXPRESSO === R$ 6,00   ");
        System.out.println("  2     ===== CAPUCCINO     === R$ 9,00");
        System.out.println("  3     ===== PÃO DE QUEIJO === R$ 5,00   ");
        System.out.println("  4     ===== COOKIE CHOCOLATE === R$ 12,00");
        System.out.println("  0     ==========================  sair");
        
        System.out.println("Digite seu nome: ");
        nome = ler.nextLine();

        do {
            System.out.println("Digite o codigo: ");
            codigo = ler.nextInt();

            if(codigo >= 5 || codigo < 0){
                System.out.println("Código inválido! Tente novamente");
            } else if (codigo == 1) {
                System.out.println("Café expresso escolhido");
                cesta += 6;
            } else if (codigo == 2) {
                System.out.println("Capuccino escolhido");
                cesta += 9;
                qtdCapuccino++;
            } else if (codigo == 3) {
                System.out.println("Pão de queijo escolhido");
                cesta += 5;
            } else if (codigo == 4) {
                System.out.println("Cookie de chocolate escolhido");
                qtdCookie++; 
            } else if (codigo == 0) {

                
                if (qtdCookie > 3) {
                    cesta += qtdCookie * 10;
                } else {
                    cesta += qtdCookie * 12;
                }
                if (cesta >150) {
                    System.out.println("desconto aplicado!");
                    desconto = cesta/10;
                    cesta = cesta - desconto;
                }
                if (cesta < 150 & cesta >50){
                    descontoMenor = cesta*0.05f;
                    cesta = cesta - descontoMenor;                    
                }

                System.out.println("Operação encerrada!");
                System.out.println("Cliente: " + nome);
                System.out.println("Total a pagar: " + cesta);

               System.out.println("Deseja doar 2% do valor total?");
               doar = ler.next().charAt(0);

               
                if (doar == 'S') {
                doacao = cesta *0.02f;
                totalDoacao+=doacao;
                System.out.println("Valor doado é: "+doacao);
                System.out.println("Total a pagar: "+(cesta+doacao));
                }
                 System.out.println("Deseja fazer outro pedido? (S/N)");
                continuar = ler.next();

                    tota+=cesta;  
                    qtdpedidos++;

                if (!continuar.equalsIgnoreCase("S"))  {
               
             
                    System.out.println("Valor total dos pedidos: "+tota);
                    System.out.println("Quantidade total dos pedidos: "+qtdpedidos);
                    System.out.println("Quantidade de capuccinos pedidos: "+qtdCapuccino);
                    System.out.println("Valor medio arrecadado por doação"+(totalDoacao/qtdpedidos));
                }

                if (continuar.equals("S")) {
                    cesta = 0;
                    qtdCookie = 0;
                    System.out.println("Digite seu nome: ");
                    nome = ler.next();
                } else {
                    break;
                }
            }

        } while (true);

        ler.close();
    }
}