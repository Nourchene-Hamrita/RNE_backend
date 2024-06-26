-- Créer la séquence si elle n'existe pas
CREATE SEQUENCE IF NOT EXISTS referentiel.code_postal_id_seq;

-- Table referentiel.type_redaction
CREATE TABLE IF NOT EXISTS referentiel.type_redaction
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT type_redaction_pkey PRIMARY KEY (id)
);

-- Table referentiel.gouvernorats
CREATE TABLE IF NOT EXISTS referentiel.gouvernorats
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT gouvernorats_pkey PRIMARY KEY (code),
    CONSTRAINT gouvernorats_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Table referentiel.sections
CREATE TABLE IF NOT EXISTS referentiel.sections
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    titre_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    titre_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sections_pkey PRIMARY KEY (code),
    CONSTRAINT sections_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Table referentiel.villes
CREATE TABLE IF NOT EXISTS referentiel.villes
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    gouvernorat_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT villes_pkey PRIMARY KEY (code),
    CONSTRAINT fkhiuoi5utrfkr2w33e2df7i43n FOREIGN KEY (gouvernorat_code)
        REFERENCES referentiel.gouvernorats (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT villes_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Table referentiel.code_postal
CREATE TABLE IF NOT EXISTS referentiel.code_postal
(
    id bigint NOT NULL DEFAULT nextval('referentiel.code_postal_id_seq'::regclass),
    code_postal character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ville_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT code_postal_pkey PRIMARY KEY (id),
    CONSTRAINT fkm5co6047d6buipnn602ymsae7 FOREIGN KEY (ville_code)
        REFERENCES referentiel.villes (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table referentiel.articles
CREATE TABLE IF NOT EXISTS referentiel.articles
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    autre_proposition character varying(255) COLLATE pg_catalog."default",
    text_complementaire character varying(255) COLLATE pg_catalog."default",
    titre_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    titre_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    section_code character varying(255) COLLATE pg_catalog."default",
    type_redaction_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT articles_pkey PRIMARY KEY (code),
    CONSTRAINT fk4u3w0wo8inv0n8f4m3xll0t0e FOREIGN KEY (section_code)
        REFERENCES referentiel.sections (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk6ewh6sk1hm5393089nx7ts3rg FOREIGN KEY (type_redaction_id)
        REFERENCES referentiel.type_redaction (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT articles_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Table referentiel.propositions
CREATE TABLE IF NOT EXISTS referentiel.propositions
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default",
    texte_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    texte_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    article_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT propositions_pkey PRIMARY KEY (code),
    CONSTRAINT fkijfr59b8xqvkihwt68pmnahcs FOREIGN KEY (article_code)
        REFERENCES referentiel.articles (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT propositions_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Table referentiel.statuts
CREATE TABLE IF NOT EXISTS referentiel.statuts
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    categorie character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default" NOT NULL,
    forme_juridique_id bigint,
    titre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT statuts_pkey PRIMARY KEY (code),
    CONSTRAINT statuts_categorie_check CHECK (categorie::text = ANY (ARRAY['Association'::character varying, 'Societe'::character varying]::text[]))
);

-- Table referentiel.statuts_sections
CREATE TABLE IF NOT EXISTS referentiel.statuts_sections
(
    statut_code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    sections_code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT fkkmvbkwdc6ndts0ekj2xm05oll FOREIGN KEY (sections_code)
        REFERENCES referentiel.sections (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqy2tcpi2o55wls0ng4nv1hrc3 FOREIGN KEY (statut_code)
        REFERENCES referentiel.statuts (code) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
