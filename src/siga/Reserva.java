package siga;

public class Reserva {

    private final Usuario solicitante;
    private final Equipamento item;
    private FaseReserva fase;

    public Reserva(Usuario solicitante, Equipamento item) {
        this.solicitante = solicitante;
        this.item = item;
        this.fase = new FaseSolicitada();
    }

    public String getSituacao() {
        return fase.getSituacao();
    }

    public void retirar() {
        fase.retirar(this);
    }

    public void devolver() {
        fase.devolver(this);
    }

    public void cancelar() {
        fase.cancelar(this);
    }

    void setFase(FaseReserva fase) {
        this.fase = fase;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public Equipamento getEquipamento() {
        return item;
    }
}
