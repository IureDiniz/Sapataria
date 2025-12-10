/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author iured
 */
public class Sapato {
    int sap_codigo;
    String sap_nome;
    String sap_fornecedor;
    double sap_preco_compra;
    double sap_preco_venda;
    int sap_quantidade;
    
    boolean existeSapato(int idSapato){
        /*if(getSapato(idSapato) != null){
            return true;
        }else{
            return false;
        }
        */
        return false;
    }
    
    boolean possuiPedido(){
        /*
        ArrayList<Pedido> pedidos = PedidoDAO.listPedido();
        for(int i =0; i<pedidos.size(); i++){
            Pedido ped = pedidos.get(i);
            if(ped.sap_codigo == this.sap_codigo){
                return true;
                break;
            }
        }
        */
        return false;
    }
}
