package siga;

public class FaseEmUso implements FaseReserva {

    @Override
    public String getSituacao() {
        return "EM_USO";
    }

    @Override
    public void retirar(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel retirar em EM_USO.");
    }

    @Override
    public void devolver(Reserva reserva) {
        reserva.setFase(new FaseEncerrada());
    }

    @Override
    public void cancelar(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel cancelar em EM_USO.");
    }
}
