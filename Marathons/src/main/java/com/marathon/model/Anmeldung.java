package com.marathon.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Anmeldung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate anmeldedatum;

    @ManyToOne
    private Nutzer nutzer;

    @ManyToOne
    private Event event;
}
