package siga;

import java.util.ArrayList;
import java.util.List;

public class CatalogoEquipamentos {

    private final InventarioService inventarioService;

    public CatalogoEquipamentos(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public List<Equipamento> listarDisponiveis() {
        List<Equipamento> disponiveis = new ArrayList<>();
        for (Equipamento item : inventarioService.listarEquipamentos()) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }
}
