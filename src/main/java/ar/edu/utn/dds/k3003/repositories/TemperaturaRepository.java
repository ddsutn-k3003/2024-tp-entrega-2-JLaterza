package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.model.Temperatura;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TemperaturaRepository {

    private static AtomicInteger seqId = new AtomicInteger();
    private Collection<Temperatura> temperaturas;

    public TemperaturaRepository() {
        this.temperaturas = new ArrayList<>();
    }

    public Temperatura save(Temperatura temperatura) {
        if (Objects.isNull(temperatura.getId())) {
            temperatura.setId(seqId.getAndIncrement());
            this.temperaturas.add(temperatura);
        }
        return temperatura;
    }

    public List<Temperatura> findByHeladeraId(Integer idHeladera) {
        List<Temperatura> temperaturasById = this.temperaturas.stream()
                .filter(x -> x.getHeladeraId().equals(idHeladera))
                .collect(Collectors.toList());

        if (temperaturasById.isEmpty()) {
            throw new NoSuchElementException(
                    String.format("No hay temperaturas para la heladera de id: %s", idHeladera)
            );
        }

        return temperaturasById;
    }

}
