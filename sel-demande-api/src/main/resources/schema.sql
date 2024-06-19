CREATE TABLE IF NOT EXISTS demande.benifvalidation
(
    numbenif  SERIAL PRIMARY KEY,
    nom VARCHAR(100) ,
    prenom VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS demande.certificat
(
    numCertificat integer,
    isValid boolean,
    denomination_sociale_ar varchar(100),
    denomination_sociale_fr varchar(100)
);


CREATE TABLE IF NOT EXISTS demande.identifiant_unique
(
    id SERIAL PRIMARY KEY,
    denomination_sociale_fr VARCHAR(100),
    denomination_sociale_ar VARCHAR(100),
    isValid boolean,
    formeJuridiqueName VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS demande.membre_spec
(
    id SERIAL PRIMARY KEY,
    date_fin_nomination date,
    date_nomination date,
    duree_nomination bigint,
    pouvoirs VARCHAR(100),
    qualite VARCHAR(100),
    societe_id bigint,
    adress VARCHAR(100),
    adress_elec VARCHAR(100),
    genre VARCHAR(100),
    is_deposant boolean,
    num_tlf integer NOT NULL,
    CONSTRAINT membre_spec_pkey PRIMARY KEY (id),
    CONSTRAINT fkboil7ve6o7x8pyyaqc3u40l6b FOREIGN KEY (societe_id)
        REFERENCES demande.societe (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT membre_spec_genre_check CHECK (genre IN ('male', 'femelle')),
    CONSTRAINT membre_spec_pouvoirs_check CHECK (pouvoirs IN ('RepresentantLegal', 'Pouvoir_etendu', 'Signature', 'Co_Signature', 'RepresentantAdministration', 'RepresentantTribunaux'
    )),
    CONSTRAINT membre_spec_qualite_check CHECK (qualite IN ('Gerant', 'Co_Gerant1', 'Co_Gerant2', 'Gerant_Delegue', 'President_du_conseil_administration', 'Vice_President_du_conseil_administration', 'Commissaire'))
);

CREATE TABLE IF NOT EXISTS demande.membre_spec_personnes
(
    membre_spec_id bigint NOT NULL,
    personnes_id bigint NOT NULL,
    CONSTRAINT fkbr8m8rc36fl989uk4iaoqtqpl FOREIGN KEY (personnes_id)
        REFERENCES demande.personne (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkfir07jgqf4mynrqdtyay6t2i0 FOREIGN KEY (membre_spec_id)
        REFERENCES demande.membre_spec (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
CREATE TABLE IF NOT EXISTS demande.personne
(
    id SERIAL PRIMARY KEY,
    id_carte bigint,
    date_delivrance date,
    date_naiss date,
    genre VARCHAR(100),
    lieu_naiss_ar VARCHAR(100),
    lieu_naiss_fr VARCHAR(100),
    nom_prenom_ar VARCHAR(100),
    nom_prenom_fr VARCHAR(100),
    adresse_id bigint,
    CONSTRAINT personne_pkey PRIMARY KEY (id),
    CONSTRAINT uk_iw4d7fbix8d591gyvja8qcmj6 UNIQUE (adresse_id),
    CONSTRAINT fk64wypb6go3kiegrp8ntdf7ywp FOREIGN KEY (adresse_id)
        REFERENCES demande.adresse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT personne_genre_check CHECK (genre IN ('male', 'femelle'))
);

CREATE TABLE IF NOT EXISTS demande.personne_actions
(
    personnes_id bigint NOT NULL,
    actions_id bigint NOT NULL,
    CONSTRAINT personne_actions_pkey PRIMARY KEY (personnes_id, actions_id),
    CONSTRAINT fkfu0u5stmjh6hexivmnc8k0e5e FOREIGN KEY (actions_id)
        REFERENCES demande.action (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkolbxt4e1ds42tmh1f16ue2dnu FOREIGN KEY (personnes_id)
        REFERENCES demande.personne (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS demande.personne_actions
(
    personnes_id bigint NOT NULL,
    actions_id bigint NOT NULL,
    CONSTRAINT personne_actions_pkey PRIMARY KEY (personnes_id, actions_id),
    CONSTRAINT fkfu0u5stmjh6hexivmnc8k0e5e FOREIGN KEY (actions_id)
        REFERENCES demande.action (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkolbxt4e1ds42tmh1f16ue2dnu FOREIGN KEY (personnes_id)
        REFERENCES demande.personne (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)