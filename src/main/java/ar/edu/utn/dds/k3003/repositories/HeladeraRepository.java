package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Heladera;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HeladeraRepository {

    private static AtomicInteger seqId = new AtomicInteger();
    private Collection<Heladera> heladeras;

    public HeladeraRepository() {
        this.heladeras = new ArrayList<>();
    }

    public Heladera save(Heladera heladera) {
        if (Objects.isNull(heladera.getId())) {
            heladera.setId(seqId.getAndIncrement());
            this.heladeras.add(heladera);
        } else {
            Optional<Heladera> existingHeladera = this.heladeras.stream()
                    .filter(h -> Objects.equals(h.getId(), heladera.getId()))
                    .findFirst();

            existingHeladera.ifPresentOrElse(
                    existing -> {
                        int index = ((List<Heladera>) this.heladeras).indexOf(existing);
                        ((List<Heladera>) this.heladeras).set(index, heladera);
                    },
                    () -> {
                        this.heladeras.add(heladera);
                    }
            );
        }

        return heladera;
    }


    public Heladera findById(Integer id) {
        Optional<Heladera> first = this.heladeras.stream().filter(x -> x.getId().equals(id)).findFirst();
        return first.orElseThrow(() -> new NoSuchElementException(
                String.format("No hay una heladera de id: %s", id)
        ));
    }

}
