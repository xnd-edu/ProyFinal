package xnd.proyfinal.ui;

import xnd.proyfinal.dao.Guardados;
import xnd.proyfinal.dao.Partidas;

public class Main {
    public static void main(String[] args) {
        Partidas partidas = new Partidas();
        Guardados guardados = new Guardados();
        guardados.savePartidas(partidas.getListaPartidas(), "Pepe");
    }
}