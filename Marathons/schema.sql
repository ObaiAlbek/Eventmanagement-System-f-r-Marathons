CREATE TABLE event (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  datum DATE,
  standort VARCHAR(255),
  budget DOUBLE,
  min_teilnehmer INT,
  max_teilnehmer INT,
  anmeldeschluss DATE,
  status VARCHAR(50)
);

CREATE TABLE nutzer (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  vorname VARCHAR(255),
  nachname VARCHAR(255)
);

CREATE TABLE anmeldung (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  anmeldedatum DATE,
  event_id BIGINT,
  nutzer_id BIGINT,
  FOREIGN KEY (event_id) REFERENCES event(id),
  FOREIGN KEY (nutzer_id) REFERENCES nutzer(id)
);

CREATE TABLE material (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  menge INT,
  stueckpreis DOUBLE,
  event_id BIGINT,
  FOREIGN KEY (event_id) REFERENCES event(id)
);

CREATE TABLE benachrichtigung (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  text VARCHAR(500),
  nutzer_id BIGINT,
  FOREIGN KEY (nutzer_id) REFERENCES nutzer(id)
);
