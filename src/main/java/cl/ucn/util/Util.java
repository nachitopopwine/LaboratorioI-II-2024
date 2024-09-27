package cl.ucn.util;

import cl.ucn.modelo.Usuario;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Usuario> loadCsv() {
        String[] values;
        List<Usuario> usuarios = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("externo.csv"))) {
            while ((values = csvReader.readNext()) != null) {
                Usuario usuario = new Usuario();
                usuario.setRut(Integer.parseInt(values[0]));
                usuario.setNombre(values[1]);
                usuario.setTienePermiso("1".equals(values[2]));
                usuario.setRecursosMultimedia(null); // No asignamos recursos de momento
                usuarios.add(usuario);
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }
}