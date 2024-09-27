package cl.ucn.main;

import cl.ucn.modelo.RecursosMultimedia;
import cl.ucn.modelo.Usuario;
import cl.ucn.util.Util;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multimediaApp");
        EntityManager em = emf.createEntityManager();

        // Buscar usuario en la base de datos
        Optional<Usuario> usuarioOpt = buscarUsuarioBD(em, 89830291);

        if (usuarioOpt.isEmpty()) {
            // Si no está en la base de datos, buscar en el CSV
            System.out.println("El usuario no existe en la base de datos, buscando en CSV...");
            Util util = new Util();
            List<Usuario> usuariosCsv = util.loadCsv();
            usuarioOpt = usuariosCsv.stream()
                    .filter(usuario -> usuario.getRut() == 89830291)
                    .findFirst();
        }

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            System.out.println("Usuario encontrado: " + usuario.getNombre());

            // Buscar archivo multimedia asociado
            if (usuario.getRecursosMultimedia() != null) {
                RecursosMultimedia archivo = usuario.getRecursosMultimedia();
                Archivo proxyArchivo = new ProxyArchivo(archivo.getNombre(), usuario);
                proxyArchivo.abrirArchivo();
            } else {
                System.out.println("No se encontró un archivo multimedia asociado.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }

        em.close();
    }

    // Método auxiliar para buscar usuario en la base de datos
    private static Optional<Usuario> buscarUsuarioBD(EntityManager em, int rut) {
        String jpql = "SELECT u FROM Usuario u WHERE u.rut = :rut";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("rut", rut);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}