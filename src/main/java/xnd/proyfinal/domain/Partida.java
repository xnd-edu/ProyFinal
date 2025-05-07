package xnd.proyfinal.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Partida {
    private int id;
    private LocalDateTime fechaPartida;
    private boolean resultado;
    private String jugador2;


    public Partida(int id, boolean resultado, String jugador2, LocalDateTime fechaPartida) {
        this.id = id;
        this.resultado = resultado;
        this.jugador2 = jugador2;
        this.fechaPartida = fechaPartida;
    }
}
