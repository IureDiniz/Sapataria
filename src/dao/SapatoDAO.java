package dao;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Sapato;
 
public class SapatoDAO {
    	public static void saveSapato(Sapato sapato) {
		String sql = "INSERT INTO tbSapato(SAP_NOME, SAP_FORNECEDOR, SAP_PRECO_COMPRA, SAP_PRECO_VENDA, SAP_QUANTIDADE) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setString(1, sapato.getSAP_NOME());
			pstm.setString(2, sapato.getSAP_FORNECEDOR());
			pstm.setDouble(3, sapato.getSAP_PRECO_COMPRA());
			pstm.setDouble(4, sapato.getSAP_PRECO_VENDA());
                        pstm.setInt(5, sapato.getSAP_QUANTIDADE());
			
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
	
	public static Sapato getSapato(int codigo) {
		Sapato produto = new Sapato();
		
		String sql = "SELECT * FROM tbSapato";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Sapato aux = new Sapato();
				
				// Recuperar os atributos
				aux.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));
				aux.setSAP_NOME(rset.getString("SAP_NOME"));
				aux.setSAP_FORNECEDOR(rset.getString("SAP_FORNECEDOR"));
				aux.setSAP_PRECO_COMPRA(rset.getDouble("SAP_PRECO_COMPRA"));
				aux.setSAP_PRECO_VENDA(rset.getDouble("SAP_PRECO_VENDA"));
                                aux.setSAP_QUANTIDADE(rset.getInt("SAP_QUANTIDADE"));
				
				if(aux.getSAP_CODIGO() == codigo) {
					produto = aux;
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
		
		return produto;
	}
	
	public static void updateSapato(Sapato sapato) {
	String sql = "UPDATE tbSapato SET SAP_NOME = ?, SAP_FORNECEDOR = ?, SAP_PRECO_COMPRA = ?, SAP_PRECO_VENDA = ?, SAP_QUANTIDADE WHERE PRO_CODIGO = ?";
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	try {
		//Cria conexão
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Cria classe de execução da query
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		
		// Adiciona os valores para atualizar
		pstm.setString(1, sapato.getSAP_NOME());
		pstm.setString(2, sapato.getSAP_FORNECEDOR());
		pstm.setDouble(3, sapato.getSAP_PRECO_COMPRA());
		pstm.setDouble(4, sapato.getSAP_PRECO_VENDA());
                pstm.setInt(5, sapato.getSAP_QUANTIDADE());
		pstm.setInt(6, sapato.getSAP_CODIGO());
		
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
	
	public static void deleteSapato(Sapato sapato) {
		String sql = "DELETE FROM tbSapato WHERE SAP_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, sapato.getSAP_CODIGO());
			
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

	public static List<Sapato> listSapato(){
		List<Sapato> sapatos = new ArrayList<Sapato>();
		
		String sql = "SELECT * FROM tbSapato";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Sapato sapato = new Sapato();
				
				// Recuperar os atributos
				sapato.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));
				sapato.setSAP_NOME(rset.getString("SAP_NOME"));
				sapato.setSAP_FORNECEDOR(rset.getString("SAP_FORNECEDOR"));
				sapato.setSAP_PRECO_COMPRA(rset.getDouble("SAP_PRECO_COMPRA"));
				sapato.setSAP_PRECO_VENDA(rset.getDouble("SAP_PRECO_VENDA"));
				sapato.setSAP_QUANTIDADE(rset.getInt("SAP_QUANTIDADE"));
                                
				sapatos.add(sapato);
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
		
		return sapatos;
	}

	public static List<Sapato> listSapato(String pesquisaNome) {
		String sql = "SELECT * FROM tbSapato WHERE SAP_NOME LIKE ?";
		
		List<Sapato> sapatos = new ArrayList<Sapato>();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, "%" + pesquisaNome + "%");

			rset = pstm.executeQuery();
			
			while (rset.next()) {	
				Sapato sapato = new Sapato();
				
				// Recuperar os atributos
				sapato.setSAP_CODIGO(rset.getInt("SAP_CODIGO"));
				sapato.setSAP_NOME(rset.getString("SAP_NOME"));
				sapato.setSAP_FORNECEDOR(rset.getString("SAP_FORNECEDOR"));
				sapato.setSAP_PRECO_COMPRA(rset.getDouble("SAP_PRECO_COMOPRA"));
				sapato.setSAP_PRECO_VENDA(rset.getDouble("SAP_PRECO_VENDA"));
				sapato.setSAP_QUANTIDADE(rset.getInt("SAP_QUANTIDADE"));
                                
				sapatos.add(sapato);
			}
			
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
		return sapatos;
	}

}
