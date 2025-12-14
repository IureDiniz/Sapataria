package TerminalTest;

import dao.SapatoDAO;
import java.util.HashSet;
import java.util.Scanner;
import models.Sapato;

public class TerminalTest {
    public static void menu(){
        try{
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        
        do{
            System.out.print("Menu Principal\n"
                    + "1 - Sapatos\n"
                    + "2 - Pedidos\n"
                    + "3 - Sair\n"
                    + "Sua escolha: ");
            int escolha = leitor.nextInt();

            switch(escolha){
                case 1:
                    menuSapato();
                    break;
                case 2:
                    menuPedido();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha invalida");
            }
        }while(continuar);
        
        System.out.println("Programa encerrado");
        }catch(Exception e){
            System.out.println("Ocorreu um erro: " + e);
        }
    }
    
    public static void menuSapato(){
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        
        do{
            System.out.print("Menu Sapatos\n"
                    + "1 - Inserir sapato\n"
                    + "2 - Consultar sapato\n"
                    + "3 - Modificar sapato\n"
                    + "4 - Deletar sapato\n"
                    + "5 - Listar sapatos\n"
                    + "6 - Voltar\n"
                    + "Sua escolha: ");
            int escolha = leitor.nextInt();
            
            switch(escolha){
                case 1:
                    inserirSapato();
                    break;
                case 2:
                    consultarSapato();
                    break;
                case 3:
                    modificarSapato();
                    break;
                case 4:
                    deletarSapato();
                    break;
                case 5:
                    listarSapato();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha invalida");
            }
            
        }while(continuar);
    }
    
    public static void menuPedido(){
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        
        do{
            System.out.print("Menu Pedidos\n"
                    + "1 - Inserir Pedido\n"
                    + "2 - Consultar Pedido\n"
                    + "3 - Modificar Pedido\n"
                    + "4 - Deletar Pedido\n"
                    + "5 - Listar Pedidos\n"
                    + "6 - Voltar\n"
                    + "Sua escolha: ");
            int escolha = leitor.nextInt();
            
            switch(escolha){
                case 1:
                    inserirPedido();
                    break;
                case 2:
                    consultarPedido();
                    break;
                case 3:
                    modificarPedido();
                    break;
                case 4:
                    deletarPedido();
                    break;
                case 5:
                    listarPedido();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha invalida");
            }
        }while(continuar);
    }
    
    private static void inserirSapato(){
        Scanner leitor = new Scanner(System.in);
        Sapato s = new Sapato();
        
        System.out.print("Digite o nome do sapato: ");
        s.setSAP_NOME(leitor.nextLine());
        
        System.out.print("Digite o fornecedor do sapato: ");
        s.setSAP_FORNECEDOR(leitor.nextLine());
        
        System.out.print("Digite o preço de compra do sapato: ");
        s.setSAP_PRECO_COMPRA(leitor.nextDouble());
        
        System.out.print("Digite o preço de venda do sapato: ");
        s.setSAP_PRECO_VENDA(leitor.nextDouble());
        
        System.out.print("Digite a quantidade do sapato: ");
        s.setSAP_QUANTIDADE(leitor.nextInt());
        
        SapatoDAO.saveSapato(s);
    }
    
    private static void modificarSapato(){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o código do sapato: ");
        int codigo = leitor. nextInt();
        
        Sapato s = new Sapato();
        
        System.out.print("Digite o novo nome do sapato: ");
        s.setSAP_NOME(leitor.nextLine());
        
        System.out.print("Digite o novo fornecedor do sapato: ");
        s.setSAP_FORNECEDOR(leitor.nextLine());
        
        System.out.print("Digite o novo preço de compra do sapato: ");
        s.setSAP_PRECO_COMPRA(leitor.nextDouble());
        
        System.out.print("Digite o novo preço de venda do sapato: ");
        s.setSAP_PRECO_VENDA(leitor.nextDouble());
        
        System.out.print("Digite a nova quantidade do sapato: ");
        s.setSAP_QUANTIDADE(leitor.nextInt());
        
        SapatoDAO.updateSapato(s);
    }
    
    private static void deletarSapato(){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o código do sapato: ");
        int codigo = leitor. nextInt();
        
        Sapato s = new Sapato();
        s.setSAP_CODIGO(codigo);
        
        SapatoDAO.deleteSapato(s);
    }
    
    private static void consultarSapato(){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o código do sapato: ");
        int codigo = leitor. nextInt();
        
        Sapato s = SapatoDAO.getSapato(codigo);
        
        System.out.println("Nome: " + s.getSAP_NOME() + "\n"
                + "Fornecedor: " + s.getSAP_FORNECEDOR() + "\n"
                + "Preço de compra: R$" + s.getSAP_PRECO_COMPRA() + "\n"
                + "Preço de venda: R$" + s.getSAP_PRECO_VENDA() + "\n"
                + "Quantidade: " + s.getSAP_QUANTIDADE());
    }
    
    private static void listarSapato(){
        Scanner leitor = new Scanner(System.in);
        
        for(Sapato s : SapatoDAO.listSapato()){
            System.out.println("Codigo: " + s.getSAP_CODIGO() + "\n"
                +"Nome: " + s.getSAP_NOME() + "\n"
                + "Fornecedor: " + s.getSAP_FORNECEDOR() + "\n"
                + "Preço de compra: R$" + s.getSAP_PRECO_COMPRA() + "\n"
                + "Preço de venda: R$" + s.getSAP_PRECO_VENDA() + "\n"
                + "Quantidade: " + s.getSAP_QUANTIDADE() + "\n");
        }
    }
    
    private static void inserirPedido(){
        Scanner leitor = new Scanner(System.in);
    }
    
    private static void modificarPedido(){
        Scanner leitor = new Scanner(System.in);
    }
    
    private static void deletarPedido(){
        Scanner leitor = new Scanner(System.in);
    }
    
    private static void consultarPedido(){
        Scanner leitor = new Scanner(System.in);
    }
    
    private static void listarPedido(){
        Scanner leitor = new Scanner(System.in);
    }
}
