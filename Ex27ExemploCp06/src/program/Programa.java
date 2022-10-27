package program;

import model.Produto;
import model.Categoria;
import service.CategoriaService;
import service.ProdutoService;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("=======================================================");
			System.out.println("======================= SISTEMA =======================");
			System.out.println("=======================================================");
			System.out.println("ESCOLHA UMA OPÇÃO:");
			System.out.println("1-CADASTRAR PRODUTO");
			System.out.println("2-ATUALIZAR PRODUTO");
			System.out.println("3-EXCLUIR PRODUTO");
			System.out.println("4-LISTAR TODOS PRODUTOS");
			System.out.println("5-LISTAR UM PRODUTO");
			System.out.println("=======================================================");
			option= sc.nextInt();
			if(option==1) {
				Produto p = new Produto();
				System.out.println("Digite o nome do produto: ");
   				p.setNome(sc.next());
   				
   				System.out.println("Digite o preço do produto: ");
   				p.setPreco(sc.nextDouble());
   				
   				System.out.println("Digite a quantidade do produto: ");
   				p.setQuantidade(sc.nextInt());
   				
   				System.out.println("Tem categoria (S/N): ");
   				if (sc.next().toUpperCase().equals("N")) {
   					ProdutoService.InsertSomenteProduto(p);
   				}else {
   					System.out.println("Gostaria de criar uma categoria (S/N): ");
   					if (sc.next().toUpperCase().equals("N")) {
   						CategoriaService.SelectAllCategoria();
   						System.out.println("Qual o ID da Categoria que deseja inserir o seu produto?");
   						p.setQuantidade(sc.nextInt());
   						ProdutoService.InsertProduto(p);
   					}else {
   						Categoria c = new Categoria();
   						System.out.println("Qual o nome da categoria que deseja criar?");
   						c.setNome(sc.next());
   						p.setQuantidade(CategoriaService.InsertCategoria(c));
   						ProdutoService.InsertProduto(p);
   					}
   				}
			}else if(option==2) {
				System.out.println("Deseja atualizar:");
				System.out.println("1-Para atualizar um produto");
				System.out.println("2-Para atualizar uma categoria");
				System.out.println("3-Para Atualizar o produto e sua categoria");
				if(sc.nextInt()==1){
					Produto p = new Produto();
					ProdutoService.SelectAllProdutos();
					
					System.out.println("Qual o ID do Produto que deseja atualizar?");
					p.setId(sc.nextInt());
					
					System.out.println("Digite o novo nome do produto: ");
	   				p.setNome(sc.next());
	   				
	   				System.out.println("Digite o novo preço do produto: ");
	   				p.setPreco(sc.nextDouble());
	   				
	   				System.out.println("Digite a nova quantidade do produto: ");
	   				p.setQuantidade(sc.nextInt());
	   				ProdutoService.UpdateProduto(p);
				}else if(sc.nextInt()==2) {
					Categoria c =new Categoria();
					CategoriaService.SelectAllCategoria();
					System.out.println("Qual o ID da Categoria que deseja atualizar?");
					c.setId(sc.nextInt());
					System.out.println("Digite o novo nome da categoria: ");
	   				c.setNome(sc.next());
					CategoriaService.UpdateCategoria(c);
				}else {
					Produto p = new Produto();
					ProdutoService.SelectAllProdutos();
					Categoria c =new Categoria();
					
					System.out.println("Qual o ID do Produto que deseja atualizar?");
					p.setId(sc.nextInt());
					
					System.out.println("Digite o novo nome do produto: ");
	   				p.setNome(sc.next());
	   				
	   				System.out.println("Digite o novo preço do produto: ");
	   				p.setPreco(sc.nextDouble());
	   				
	   				System.out.println("Digite a nova quantidade do produto: ");
	   				p.setQuantidade(sc.nextInt());
	   				
	   				System.out.println("Digite o novo nome da categoria: ");
	   				c.setNome(sc.next());
	   				c.setId(p.getCategoria().getId());
					CategoriaService.UpdateCategoria(c);
	   				ProdutoService.UpdateProduto(p);
				}
			}else if (option==3) {
				ProdutoService.SelectAllProdutos();
   				System.out.println("Qual o ID do produto que deseja excluir?");
   				ProdutoService.DeleteProduto(sc.nextInt());
			}
			
		}while (option<6 && option>0);
	}

}
