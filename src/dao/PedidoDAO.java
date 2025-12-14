package dao;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Pedido;

public class PedidoDAO {
    public static void savePedido(Pedido pedido) {
		String sql = "INSERT INTO tbPedido(PED_CLIENTE, PED_DATA, PED_QUANTIDADE, PED_PRECO_TOTAL, SAP_CODIGO) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setString(1, pedido.getPED_CLIENTE());
			pstm.setDate(2, pedido.getPED_DATA());
                        pstm.setInt(3, pedido.getPED_QUANTIDADE());
                        pstm.setDouble(4, pedido.getPED_PRECO_TOTAL());
                        pstm.setInt(5, pedido.getSAP_CODIGO());
			
			// Executa a query
			pstm.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// Fechar as conexões
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    public static Pedido getPedido(int codigoPedido){
		Pedido pedido = null;
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido aux = new Pedido();
				
				// Recuperar os atributos
				aux.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				aux.setPED_CLIENTE(rset.getString("CLIENTE"));
				aux.setPED_DATA(rset.getDate("PED_DATA"));
                                aux.setPED_QUANTIDADE(rset.getInt("PED_QUANTIDADE"));
                                aux.setPED_PRECO_TOTAL(rset.getDouble("PED_PRECO_TOTAL"));
                                aux.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));
				
				if(aux.getPED_CODIGO() == codigoPedido) {
					pedido = aux;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pedido;
	}

    public static Pedido getLastPedido(){
		Pedido pedido = null;
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			// Laço que percorre todos os pedidos até salvar o último
			while (rset.next()) {
				Pedido aux = new Pedido();
				
				// Recuperar os atributos
				aux.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				aux.setPED_CLIENTE(rset.getString("CLIENTE"));
				aux.setPED_DATA(rset.getDate("PED_DATA"));
                                aux.setPED_QUANTIDADE(rset.getInt("PED_QUANTIDADE"));
                                aux.setPED_PRECO_TOTAL(rset.getDouble("PED_PRECO_TOTAL"));
                                aux.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));

				pedido = aux;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pedido;
	}
	
    public static void updatePedido(Pedido pedido) {
		String sql = "UPDATE tbPedido SET PED_CLIENTE = ?, PED_DATA = ?, PED_QUANTIDADE = ?, PED_PRECO_TOTAL = ?, SAP_CODIGO = ?" +
				 "WHERE PED_CODIGO = ?";
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	try {
		//Cria conexão
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Cria classe de execução da query
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		
		// Adiciona os valores para atualizar
		pstm.setString(1, pedido.getPED_CLIENTE());
		pstm.setDate(2, pedido.getPED_DATA());
                pstm.setInt(3, pedido.getPED_QUANTIDADE());
                pstm.setDouble(4, pedido.getPED_PRECO_TOTAL());
                pstm.setInt(5, pedido.getSAP_CODIGO());
		
		// Executa a query
		pstm.execute();
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
	
    public static void deletePedido(Pedido pedido) {
		String sql = "DELETE FROM tbPedido WHERE PED_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getPED_CODIGO());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public static List<Pedido> listPedido(){
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido pedido = new Pedido();
				
				// Recuperar os atributos
				pedido.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				pedido.setPED_CLIENTE(rset.getString("CLIENTE"));
				pedido.setPED_DATA(rset.getDate("PED_DATA"));
                                pedido.setPED_QUANTIDADE(rset.getInt("PED_QUANTIDADE"));
                                pedido.setPED_PRECO_TOTAL(rset.getDouble("PED_PRECO_TOTAL"));
                                pedido.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));
				
				pedidos.add(pedido);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return pedidos;
	}
}
