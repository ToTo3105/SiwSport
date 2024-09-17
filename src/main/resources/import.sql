insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Atalanta', 1907);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Bologna', 1909);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Cagliari', 1920);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Como', 1907);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Empoli', 1920);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Fiorentina', 1926);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Genoa', 1926);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Hellas Verona', 1903);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Inter', 1908);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Juventus', 1897);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Lazio', 1900);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Lecce', 1908);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Milan', 1899);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Monza', 1912);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Napoli', 1926);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Parma', 1913);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Roma', 1927);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Torino', 1906);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Udinese', 1911);
insert into squadra (id, nome, anno_fondazione) values(nextval('squadra_seq'), 'Venezia', 1907);

insert into amministratore(id, nome, cognome, data_nascita, luogo_nascita) values(nextval('persona_seq'), 'Jacopo', 'Lore', '2000-05-31', 'Roma');
insert into credenziali (id, username, password, ruolo_utente, persona_id) values(nextval('credenziali_seq'), 'jacopo.lore', '$2a$10$25H5p2IZ12fTG12hWMC.DO8ctZS3Z0HedIXHhIVIcN51Cufun7EHi', 'AMMINISTRATORE', 1);

