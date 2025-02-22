package view;
import dao.ProdutoDao;
import model.Produto;
import javax.swing.*;
import java.io.IOException;
import java.util.Set;

public class Main {
    private static ProdutoDao produtoDao = new ProdutoDao();
    public static void main(String[] args) {
                while (true) {
                    String opcao = JOptionPane.showInputDialog(null,
                            "Escolha uma opção:\n1 - Adicionar Produto\n2 - Listar Produtos\n3 - Remover Produto\n4 - Sair",
                            "Gerenciador de Produtos", JOptionPane.QUESTION_MESSAGE);

                    if (opcao == null || opcao.equals("4")) {
                        JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                        break;
                    }

                    switch (opcao) {
                        case "1":
                            adicionarProduto();
                            break;
                        case "2":
                            listarProdutos();
                            break;
                        case "3":
                            removerProduto();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
                    }
                }
            }

            private static void adicionarProduto() {
                String nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
                if (nomeProduto != null && !nomeProduto.trim().isEmpty()) {
                    try {
                        if (produtoDao.adicionarProduto(new Produto(nomeProduto.trim()))) {
                            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto já existe!");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar produto.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do produto inválido!");
                }
            }

            private static void listarProdutos() {
                try {
                    Set<Produto> produtos = produtoDao.getProdutos();
                    if (produtos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
                    } else {
                        StringBuilder lista = new StringBuilder("Lista de Produtos:\n");
                        int i = 1;
                        for (Produto produto : produtos) {
                            lista.append(i++).append(" - ").append(produto).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar produtos.");
                }
            }

            private static void removerProduto() {
                String nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto a ser removido:", "Remover Produto", JOptionPane.QUESTION_MESSAGE);
                if (nomeProduto != null && !nomeProduto.trim().isEmpty()) {
                    try {
                        if (produtoDao.removerProduto(new Produto(nomeProduto.trim()))) {
                            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao remover produto.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do produto inválido!");
                }
            }
}