package siga;

public class FaseSolicitada implements FaseReserva {

    @Override
    public String getSituacao() {
        return "SOLICITADA";
    }

    @Override
    public void retirar(Reserva reserva) {
        reserva.setFase(new FaseEmUso());
    }

    @Override
    public void devolver(Reserva reserva) {
        throw new IllegalStateException("Nao e possivel devolver em SOLICITADA.");
    }

    @Override
    public void cancelar(Reserva reserva) {
        reserva.setFase(new FaseEncerrada());
    }
}
