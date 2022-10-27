package service;

import model.Produto;
import dao.Dao;
import java.sql.ResultSet;

public class ProdutoService {
	public static int InsertProduto(Produto p) {
		String query = String.format("select max(id_produto) as id_produto from t_produto");
	 	ResultSet rs = Dao.SelectCommand(query);
	 	int id = -1;
	 	if (rs!=null) {
	 		try {
				while(rs.next()) {
					id = rs.getInt("id_produto");
				}
				id++;
				p.setId(id);
				query = String.format("insert into t_produto (id_produto,nome, preco, quantidade, id_categoria) values(%s,'%s',%s, %s,%s)", p.getId(), p.getNome(), p.getPreco(), p.getQuantidade(),p.getCategoria().getId());
			} catch (Exception e) {
				System.out.println(e);
			}
	 	}
	 	else {
	 		p.setId(1);
	 		query = String.format("insert into t_produto (id_produto,nome, preco, quantidade, id_categoria) values(%s,'%s',%s, %s,%s)", p.getId(), p.getNome(), p.getPreco(), p.getQuantidade(),p.getCategoria().getId());
	 	}
	 	return id;
	}
	
	public static int InsertSomenteProduto(Produto p) {
		String query = String.format("select max(id_produto) as id_produto from t_produto");
	 	ResultSet rs = Dao.SelectCommand(query);
	 	int id = -1;
	 	if (rs!=null) {
	 		try {
				while(rs.next()) {
					id = rs.getInt("id_produto");
				}
				id++;
				p.setId(id);
				query = String.format("insert into t_produto (id_produto,nome, preco, quantidade) values(%s,'%s',%s, %s,%s)", p.getId(), p.getNome(), p.getPreco(), p.getQuantidade());
			} catch (Exception e) {
				System.out.println(e);
			}
	 	}
	 	else {
	 		p.setId(1);
	 		query = String.format("insert into t_produto (id_produto,nome, preco, quantidade) values(%s,'%s',%s, %s,%s)", p.getId(), p.getNome(), p.getPreco(), p.getQuantidade());
	 	}
	 	return id;
	}
	public static void UpdateProduto(Produto p) {
		String query = String.format("update t_produto set nome = '%s', preco = %s, quantidade = %s, where id_produto = %s", p.getNome(),p.getPreco(), p.getQuantidade() ,p.getId());
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void DeleteProduto(int id) {
		String query = String.format("delete from t_produto where id_produto = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void SelectAllProdutos() {
		String query= String.format("select * from t_produto");   
        ResultSet rs = Dao.SelectCommand(query);
        if (rs!=null) {
        	try {
				while (rs.next()) {
					Produto p= new Produto();
					p.setId(rs.getInt("id_produto"));
					p.setNome(rs.getString("nome"));
					p.setPreco(rs.getInt("preco"));
					p.setQuantidade(rs.getInt("quantidade"));
					System.out.println("----------------------------------------");
					System.out.printf("ID do produto: %s\n",p.getId());
					System.out.printf("NOME do produto: %s\n",p.getNome());
					System.out.printf("PREÇO do produto: %s\n",p.getPreco());
					System.out.printf("QUANTIDADE do produto: %s\n",p.getQuantidade());
					System.out.println("----------------------------------------");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
        }else {
        	System.out.println("Não existe produtos ainda.");
        }
	}
	
	public static void SelectProduto(int id) {
		String query = String.format("select * from t_produto where id_produto = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
        if (rs!=null) {
        	try {
				while (rs.next()) {
					Produto p= new Produto();
					p.setId(rs.getInt("id_produto"));
					p.setNome(rs.getString("nome"));
					p.setPreco(rs.getInt("preco"));
					p.setQuantidade(rs.getInt("quantidade"));
					System.out.println("----------------------------------------");
					System.out.printf("ID do produto: %s\n",p.getId());
					System.out.printf("NOME do produto: %s\n",p.getNome());
					System.out.printf("PREÇO do produto: %s\n",p.getPreco());
					System.out.printf("QUANTIDADE do produto: %s\n",p.getQuantidade());
					System.out.println("----------------------------------------");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
        }else {
        	System.out.println("Não existe produto com esse ID.");
        }
	}
}
