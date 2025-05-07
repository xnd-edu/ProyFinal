package xnd.proyfinal.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import xnd.proyfinal.common.Config;
import xnd.proyfinal.domain.LocalDateTimeDeserializer;
import xnd.proyfinal.domain.LocalDateTimeSerializer;
import xnd.proyfinal.domain.Partida;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Guardados {

    public List<Partida> loadPartidas(String jugador) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Partida>>() {}.getType();
        log.info("cargando Partidas");
        List<Partida> Partidas = null;
        try {
            Partidas = gson.fromJson(
                    new FileReader(new Config().loadPathProperties() + jugador + ".json"),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return Partidas;
    }

    public boolean savePartidas(List<Partida> partidas, String jugador) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(partidas));
        try (FileWriter fw = new FileWriter(new Config().loadPathProperties() + jugador + ".json")) {
            gson.toJson(partidas, fw);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
