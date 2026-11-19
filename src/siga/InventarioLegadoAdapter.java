package siga;

import java.util.ArrayList;

import java.util.List;

public class InventarioLegadoAdapter implements InventarioService {

    private final InventarioLegadoWS legado;

    public InventarioLegadoAdapter(InventarioLegadoWS legado) {
        this.legado = legado;
    }

    @Override
    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();
        for (String[] linha : legado.consultarEquipamentos()) {
            Equipamento item = new Equipamento(linha[0], linha[1]);
            // Tratamento unico e correto para letras maiusculas e minusculas
            item.setDisponivel("D".equalsIgnoreCase(linha[2]));
            equipamentos.add(item);
        }
        return equipamentos;
    }
}
