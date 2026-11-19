package siga;

import java.util.List;

public class RelatorioAcervo {

    private final InventarioService inventarioService;

    public RelatorioAcervo(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public List<Equipamento> listarTodos() {
        return inventarioService.listarEquipamentos();
    }

    public void imprimir() {
        System.out.println("   Situacao segundo o relatorio:");
        for (Equipamento item : listarTodos()) {
            System.out.println("     " + item + " - "
                    + (item.isDisponivel() ? "disponivel" : "baixado"));
        }
    }
}
