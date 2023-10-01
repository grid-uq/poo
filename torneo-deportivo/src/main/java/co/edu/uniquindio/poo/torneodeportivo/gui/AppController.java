package co.edu.uniquindio.poo.torneodeportivo.gui;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import co.edu.uniquindio.poo.torneodeportivo.TipoTorneo;
import co.edu.uniquindio.poo.torneodeportivo.Torneo;
import co.edu.uniquindio.poo.util.TorneoBusquedaUtil;

public enum AppController {
    INSTANCE;
    private final Collection<Torneo> torneos;
    
    AppController() {
        torneos = new LinkedList<>();
    }

    public void adicionar(Torneo torneo){
        torneos.add(torneo);
    }

    public Collection<Torneo> getTorneos(){
        return Collections.unmodifiableCollection(torneos);
    }

    public void remover(Torneo torneoSeleccionado) {
        torneos.remove(torneoSeleccionado);
    }

    public Collection<Torneo> buscar(String nombre, Byte numeroParticipantes, Byte limiteEdad, Integer valorInscripcion, TipoTorneo tipoTorneo) {
        var filtro = TorneoBusquedaUtil.buscarPorTodo(nombre, numeroParticipantes, limiteEdad, valorInscripcion, tipoTorneo);
        return torneos.stream().filter(filtro).toList();
    }
}
