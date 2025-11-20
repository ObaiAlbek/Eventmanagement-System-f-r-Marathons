package com.marathon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate datum;
    private String standort;

    private double budget;
    private int minTeilnehmer;
    private int maxTeilnehmer;

    private LocalDate anmeldeschluss;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToOne
    private Eventmanager eventmanager;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Anmeldung> anmeldungen = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Material> materialien = new ArrayList<>();
}
