import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnumGen_Pedido {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        List<Item> itens = new ArrayList<>();

        while (true) {
            System.out.print("Digite a descrição do item (ou pressione Enter para finalizar): ");
            String descricao = leia.nextLine();
            if (descricao.isEmpty()) {
                break;
            }

            System.out.print("Digite a quantidade do item: ");
            int quantidade = leia.nextInt();
            leia.nextLine();

            System.out.println("Selecione a categoria:");
            System.out.println("1. Alimento");
            System.out.println("2. Eletrônico");
            System.out.println("3. Outros");
            System.out.print("Categoria listada selecionada: ");
            int categoriaEscolhida = leia.nextInt();
            leia.nextLine();

            String categoria = "";
            switch (categoriaEscolhida) {
                case 1:
                    categoria = "Alimento";
                    break;
                case 2:
                    categoria = "Eletrônico";
                    break;
                case 3:
                    categoria = "Outros";
                    break;
                default:
                    System.out.println("Categoria inválida. Item será registrado como 'Outros'.");
                    categoria = "Outros";
                    break;
            }

            itens.add(new Item(descricao, quantidade, categoria));
        }

        System.out.println("\nLista de Pedidos:");
        for (Item item : itens) {
            System.out.printf("%s %s %d%n", item.getCategoria(), item.getDescricao(), item.getQuantidade());
        }

        leia.close();
    }
}

class Item {
    private String descricao;
    private int quantidade;
    private String categoria;

    public Item(String descricao, int quantidade, String categoria) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }
}
