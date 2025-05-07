package xnd.proyfinal.dao;

import lombok.Data;
import xnd.proyfinal.domain.Partida;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@Data
public class Partidas {
    private final List<Partida> listaPartidas;

    public Partidas(List<Partida> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public Partidas() {
        this.listaPartidas = new ArrayList<Partida>();

        listaPartidas.add(new Partida(1, true, "Arthur", LocalDateTime.now()));
    }
}
