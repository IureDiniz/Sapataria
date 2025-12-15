package models;

import dao.SapatoDAO;
import java.sql.Date;

public class Pedido {
    private int PED_CODIGO;
    private String PED_CLIENTE;
    private int PED_QUANTIDADE;
    private double PED_PRECO_TOTAL;
    private int SAP_CODIGO;
    private java.sql.Date PED_DATA;

    public java.sql.Date getData() {
        java.sql.Date data = new java.sql.Date(this.PED_DATA.getTime());
        return data;
    }

    public void setPED_DATA (java.sql.Date data) {
        this.PED_DATA = data;
    }
    
    public int getPED_CODIGO() {
        return PED_CODIGO;
    }

    public void setPED_CODIGO(int PED_CODIGO) {
        this.PED_CODIGO = PED_CODIGO;
    }

    public String getPED_CLIENTE() {
        return PED_CLIENTE;
    }

    public void setPED_CLIENTE(String PED_CLIENTE) {
        this.PED_CLIENTE = PED_CLIENTE;
    }

    public int getPED_QUANTIDADE() {
        return PED_QUANTIDADE;
    }

    public void setPED_QUANTIDADE(int PED_QUANTIDADE) {
        this.PED_QUANTIDADE = PED_QUANTIDADE;
    }

    public double getPED_PRECO_TOTAL() {
        return PED_PRECO_TOTAL;
    }

    public void setPED_PRECO_TOTAL(double PED_PRECO_TOTAL) {
        this.PED_PRECO_TOTAL = PED_PRECO_TOTAL;
    }

    public int getSAP_CODIGO() {
        return SAP_CODIGO;
    }

    public void setSAP_CODIGO(int SAP_CODIGO) {
        this.SAP_CODIGO = SAP_CODIGO;
    }

    public Date getPED_DATA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String toString(){
        Sapato s = SapatoDAO.getSapato(this.PED_CODIGO);
        String m = "Código: " + this.PED_CLIENTE + "\n"
                + "Cliente: " + this.PED_CLIENTE + "\n"
                + "Sapato: " + s.getSAP_NOME() + "\n"
                + "Quantidade: " + this.PED_QUANTIDADE + "\n"
                + "Preço total: " + this.PED_PRECO_TOTAL + "\n"
                + "Data: " + this.PED_DATA + "\n";
        
        return m;
    }
}