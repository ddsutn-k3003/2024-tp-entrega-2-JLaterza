package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Heladera;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
        }
        return heladera;
    }
}
