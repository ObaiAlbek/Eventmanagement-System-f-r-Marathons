package com.marathon;

import com.marathon.model.*;
import com.marathon.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MarathonSystemIntegrationTest {

    @Autowired EventRepository eventRepository;
    @Autowired NutzerRepository nutzerRepository;
    @Autowired AnmeldungRepository anmeldungRepository;
    @Autowired MaterialRepository materialRepository;

    @Test
    void fullEventFlow() {
        Nutzer n = new Nutzer();
        n.setVorname("Obai");
        n.setNachname("Albek");
        n = nutzerRepository.save(n);

        Event e = new Event();
        e.setName("Mannheim Marathon");
        e.setDatum(LocalDate.now().plusMonths(6));
        e.setStandort("Mannheim");
        e.setStatus(EventStatus.PLANUNG);
        e = eventRepository.save(e);

        Anmeldung a = new Anmeldung();
        a.setAnmeldedatum(LocalDate.now());
        a.setEvent(e);
        a.setNutzer(n);
        a = anmeldungRepository.save(a);

        Material m = new Material();
        m.setName("Wasser");
        m.setMenge(5000);
        m.setStueckpreis(0.20);
        m.setEvent(e);
        m = materialRepository.save(m);

        assertThat(eventRepository.findAll()).hasSize(1);
        assertThat(anmeldungRepository.findAll()).hasSize(1);
        assertThat(materialRepository.findAll()).hasSize(1);
    }
}
