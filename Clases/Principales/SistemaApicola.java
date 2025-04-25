package Clases.Principales;

import Clases.Principales.*;
import java.util.*;

public class SistemaApicola {
    private static DatosApicola datosApicola = new DatosApicola();
    
    public static void registrarApicultor() {
        System.out.println("REGISTRO DEL NUEVO APICULTOR");
    
        try {
            // SE piden los datos del nuevo apicultor
            String nombre = Utils.solicitarCampo("Ingrese el nombre del apicultor: ");
            String telefono = Utils.solicitarCampo("Ingrese el teléfono del apicultor: ");
            int edad = solicitarEdad();
            int experiencia = solicitarExperiencia(edad);
            String direccion = Utils.solicitarCampo("Ingrese la dirección del apicultor: ");
            String identificacion = Utils.solicitarCampo("Ingrese la identificación (DNI/ID/Cédula) del apicultor: ");
    
            // Crear objeto Apicultor
            Apicultor nuevoApicultor = new Apicultor(nombre, telefono, edad, experiencia, direccion, identificacion);
    
            // Agregar el apicultor a la lista correspondiente (en este caso, a datosApicola)
            datosApicola.agregarApicultor(nuevoApicultor);
    
            // Confirmar el registro
            System.out.println("✅ Apicultor registrado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al registrar el apicultor: " + e.getMessage());
        }
}

    public static void asignarAbejaReina() {
    System.out.println("ASIGNACIÓN DE ABEJA REINA");

    List<Colmena> colmenasSinReina = datosApicola.obtenerColmenasSinReina();

    if (colmenasSinReina.isEmpty()) {
        System.out.println("❌ No hay colmenas disponibles sin abeja reina.");
        return;
    }

    // Mostrar las colmenas sin reina
    System.out.println("Colmenas disponibles:");
    for (int i = 0; i < colmenasSinReina.size(); i++) {
        System.out.println((i + 1) + ". " + colmenasSinReina.get(i).descripcionCorta());
    }

    try {
        int opcion = Integer.parseInt(Utils.solicitarCampo("Seleccione el número de la colmena a asignar la abeja reina: "));
        if (opcion < 1 || opcion > colmenasSinReina.size()) {
            System.out.println("❌ Opción no válida.");
            return;
        }

        Colmena colmenaSeleccionada = colmenasSinReina.get(opcion - 1);

        // Pedir datos de la abeja reina
        String nombre = Utils.solicitarCampo("Ingrese el nombre de la abeja reina: ");
        int edad = Integer.parseInt(Utils.solicitarCampo("Ingrese la edad (en días) de la abeja reina: "));
        String origen = Utils.solicitarCampo("Ingrese el origen de la abeja reina: ");

        // Crear objeto AbejaReina
        AbejaReina reina = new AbejaReina(nombre, edad, origen);

        // Asignar a la colmena
        colmenaSeleccionada.asignarAbejaReina(reina);

        System.out.println("✅ Abeja reina asignada correctamente a la colmena.");
    } catch (Exception e) {
        System.out.println("❌ Error al asignar la abeja reina: " + e.getMessage());
    }
}


    public static void mostrarInformacion() {
        // TODO: Mostrar submenú con tipos de información a mostrar
        // TODO: Dependiendo de la opción, mostrar:
        //   - Colmenas registradas
        //   - Apicultores
        //   - Abejas reinas
        //   - Historial de inspecciones
        // TODO: Permitir volver al menú principal
    }

    public static void asignarApicultorAColmena() {
        // TODO: Mostrar lista de colmenas
        // TODO: Mostrar lista de apicultores
        // TODO: Permitir seleccionar ambos
        // TODO: Validar que el apicultor no esté ya asignado
        // TODO: Asignar apicultor a la colmena
        // TODO: Confirmar asignación
    }

    public static void editarInformacion() {
        // TODO: Mostrar submenú: ¿qué desea editar? (colmena, apicultor, abeja reina, inspección)
        // TODO: Según elección, mostrar lista de elementos
        // TODO: Permitir seleccionar uno
        // TODO: Pedir nuevos datos
        // TODO: Validar y aplicar cambios
        // TODO: Confirmar edición
    }
}
