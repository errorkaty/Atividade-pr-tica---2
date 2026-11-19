package siga;

public interface FaseReserva {

    String getSituacao();

    void retirar(Reserva reserva);

    void devolver(Reserva reserva);

    void cancelar(Reserva reserva);
}
