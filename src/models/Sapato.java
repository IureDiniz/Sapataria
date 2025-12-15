package models;

import static dao.PedidoDAO.listPedido;
import static dao.SapatoDAO.getSapato;
import java.util.List;

public class Sapato {

    private int SAP_CODIGO;
    private String SAP_NOME;
    private String SAP_FORNECEDOR;
    private double SAP_PRECO_COMPRA;
    private double SAP_PRECO_VENDA;
    private int SAP_QUANTIDADE;
    
    public static boolean existeSapato(int idSapato){
        if(getSapato(idSapato) != null){
            return true;
        }else{
            return false;
        }
        /*if(getSapato(idSapato) != null){
            return true;
        }else{
            return false;
        }
        */
    }
    
    public boolean possuiEstoque(int id, int qtde){
        Sapato sap = getSapato(id);
        if(sap.getSAP_QUANTIDADE() >= qtde){
            return true;
        }else{
            return false;
        }
    }
    
    public int getSAP_CODIGO() {
        return SAP_CODIGO;
    }

    public void setSAP_CODIGO(int SAP_CODIGO) {
        this.SAP_CODIGO = SAP_CODIGO;
    }

    public String getSAP_NOME() {
        return SAP_NOME;
    }

    public void setSAP_NOME(String SAP_NOME) {
        this.SAP_NOME = SAP_NOME;
    }

    public String getSAP_FORNECEDOR() {
        return SAP_FORNECEDOR;
    }

    public void setSAP_FORNECEDOR(String SAP_FORNECEDOR) {
        this.SAP_FORNECEDOR = SAP_FORNECEDOR;
    }

    public double getSAP_PRECO_COMPRA() {
        return SAP_PRECO_COMPRA;
    }

    public void setSAP_PRECO_COMPRA(double SAP_PRECO_COMPRA) {
        this.SAP_PRECO_COMPRA = SAP_PRECO_COMPRA;
    }

    public double getSAP_PRECO_VENDA() {
        return SAP_PRECO_VENDA;
    }

    public void setSAP_PRECO_VENDA(double SAP_PRECO_VENDA) {
        this.SAP_PRECO_VENDA = SAP_PRECO_VENDA;
    }

    public int getSAP_QUANTIDADE() {
        return SAP_QUANTIDADE;
    }

    public void setSAP_QUANTIDADE(int SAP_QUANTIDADE) {
        this.SAP_QUANTIDADE = SAP_QUANTIDADE;
    }
    
    public String toString(){
        String m = "Código: " + this.SAP_CODIGO + "\n"
                + "Nome: " + this.SAP_NOME + "\n"
                + "Fornecedor: " + this.SAP_FORNECEDOR + "\n"
                + "Preço de compra: " + this.SAP_PRECO_COMPRA + "\n"
                + "Preço de vanda: " + this.SAP_PRECO_VENDA + "\n"
                + "Quantidade: " + this.SAP_QUANTIDADE + "\n";
        
        return m;
    }
}