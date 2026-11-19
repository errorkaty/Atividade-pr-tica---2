package siga;

public class FaseEncerrada implements FaseReserva {

    @Override
    public String getSituacao() {
        return "ENCERRADA";
    }

    @Override
    public void retirar(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel retirar em ENCERRADA.");
    }

    @Override
    public void devolver(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel devolver em ENCERRADA.");
    }

    @Override
    public void cancelar(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel cancelar em ENCERRADA.");
    }
}
