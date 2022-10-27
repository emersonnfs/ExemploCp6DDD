package service;

import model.Categoria;
import dao.Dao;
import java.sql.ResultSet;

public class CategoriaService {
	public static int InsertCategoria(Categoria c) {
		String query = String.format("select max(id_categoria) as id_categoria from t_categoria");
	 	ResultSet rs = Dao.SelectCommand(query);
	 	int id = -1;
	 	if(rs!=null) {
	 		try {
				while(rs.next()) {
					id=rs.getInt("id_categoria");
				}
				id++;
				c.setId(id);
				query = String.format("insert into t_categoria (id_categoria,nome) values(%s,'%s')", c.getId(), c.getNome());
				
			} catch (Exception e) {
				System.out.println(e);
			}
	 	
		}
	 	else {
	 		id=1;
	 		c.setId(id);
			query = String.format("insert into t_categoria (id_categoria,nome) values(%s,'%s')", c.getId(), c.getNome());
	 	}
	 	return id;
	}
	
	public static void UpdateCategoria(Categoria c) {
		String query = String.format("update t_categoria set nome = '%s' where id_categoria = %s", c.getNome(), c.getId());
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void DeleteCategoria(int id) {
		String query = String.format("delete from t_categoria where id_categoria = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
	}
	
	public static void SelectAllCategoria() {
		String query= String.format("select * from t_categoria");   
        ResultSet rs = Dao.SelectCommand(query);
        if (rs!=null) {
        	try {
        		while(rs.next()) {
        			Categoria c = new Categoria();
        			c.setId(rs.getInt("id_categoria"));
        			c.setNome(rs.getString("nome"));
        			System.out.println("----------------------------------------");
        			System.out.printf("ID da Categoria: %d\n",c.getId());
        			System.out.printf("NOME da Categoria: %s\n",c.getNome());
        		}
			} catch (Exception e) {
                System.out.println(e);
			}
        }else {
        	System.out.println("Não existe categorias ainda.");
        }
	}
	
	public static void SelectCategoria(int id) {
		String query = String.format("select * from t_categoria where id_categoria = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
        if (rs!=null) {
        	try {
				while(rs.next()) {
			        Categoria c=new Categoria();
					c.setNome(rs.getString("nome"));
					System.out.println("----------------------------------------");
					System.out.printf("NOME da Categoria: %s\n",c.getNome());
					System.out.printf("----------------------------------------");
				}
				
			} catch (Exception e) {
                System.out.println(e);
			}
        }
        else {
        	System.out.println("----------------------------------------");
        	System.out.println("Não existe nenhuma categoria com esse ID");
        	System.out.println("----------------------------------------");
        }
	}
}
