-- Create the sequence if it doesn't exist
CREATE SEQUENCE IF NOT EXISTS referentiel.forme_juridique_id_seq;
CREATE SEQUENCE IF NOT EXISTS referentiel.propositions_id_seq;
-- Create table forme_juridique
DROP TABLE IF EXISTS referentiel.forme_juridique;
CREATE TABLE IF NOT EXISTS referentiel.forme_juridique (
    id BIGINT NOT NULL DEFAULT nextval('referentiel.forme_juridique_id_seq'::regclass),
    activation VARCHAR(255) COLLATE pg_catalog."default" NOT NULL,
    categorie VARCHAR(255) COLLATE pg_catalog."default",
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL,
    nom VARCHAR(255) COLLATE pg_catalog."default",
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT forme_juridique_pkey PRIMARY KEY (id),
    CONSTRAINT forme_juridique_activation_check CHECK (activation::TEXT = ANY (ARRAY['Active', 'Desactive']::TEXT[])),
    CONSTRAINT forme_juridique_categorie_check CHECK (categorie::TEXT = ANY (ARRAY['Association', 'Societe']::TEXT[]))
);

-- Insert data into forme_juridique
INSERT INTO referentiel.forme_juridique (id, activation, categorie, nom, created_at, updated_at)
VALUES 
    (1, 'Active', 'Societe', 'Société Civile', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'Active', 'Societe', 'Société Anonyme', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 'Active', 'Societe', 'Société Unipersonnelle à Responsabilité Limitée', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 'Active', 'Societe', 'Société à Responsabilité Limitée', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- Table referentiel.gouvernorats
DROP TABLE IF EXISTS referentiel.gouvernorats;
CREATE TABLE IF NOT EXISTS referentiel.gouvernorats
(
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    activation character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    nom_ar character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nom_fr character varying(255) COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp(6) without time zone NOT NULL,
    CONSTRAINT gouvernorats_pkey PRIMARY KEY (code),
    CONSTRAINT gouvernorats_activation_check CHECK (activation::text = ANY (ARRAY['Active'::character varying, 'Desactive'::character varying]::text[]))
);

-- Insertion des données dans gouvernorats
INSERT INTO referentiel.gouvernorats (code, activation,created_at, nom_ar, nom_fr,updated_at)
VALUES 
    ('GOUV001', 'Active',CURRENT_TIMESTAMP, 'تونس', 'Tunis',CURRENT_TIMESTAMP),
    ('GOUV002', 'Active',CURRENT_TIMESTAMP, 'أريانة', 'Ariana',CURRENT_TIMESTAMP);
-- Create table statuts
DROP TABLE IF EXISTS referentiel.statuts;
CREATE TABLE IF NOT EXISTS referentiel.statuts (
    code VARCHAR(255) NOT NULL,
    activation VARCHAR(255),
    categorie VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255) NOT NULL,
    titre VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    forme_juridique_id BIGINT,
    CONSTRAINT statuts_pkey PRIMARY KEY (code),
    CONSTRAINT statuts_forme_juridique_fkey FOREIGN KEY (forme_juridique_id)
        REFERENCES referentiel.forme_juridique (id) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT statuts_activation_check CHECK (activation IN ('Active', 'Desactive')),
    CONSTRAINT statuts_categorie_check CHECK (categorie IN ('Association', 'Societe'))
);

-- Insert data into statuts
INSERT INTO referentiel.statuts (code, activation, categorie, created_at, description, updated_at, forme_juridique_id, titre)
VALUES 
    ('STAT001', 'Active', 'Societe', CURRENT_TIMESTAMP, 'Description du statut 1', CURRENT_TIMESTAMP, 1, 'Titre du statut 1'),
    ('STAT002', 'Active', 'Societe', CURRENT_TIMESTAMP, 'Description du statut 2', CURRENT_TIMESTAMP, 2, 'Titre du statut 2');

-- Create table sections
DROP TABLE IF EXISTS referentiel.sections;
CREATE TABLE IF NOT EXISTS referentiel.sections (
    code VARCHAR(255) NOT NULL,
    activation VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    titre_ar VARCHAR(255) NOT NULL,
    titre_fr VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    statut_code VARCHAR(255),
    CONSTRAINT sections_pkey PRIMARY KEY (code),
    CONSTRAINT sections_statut_fkey FOREIGN KEY (statut_code)
        REFERENCES referentiel.statuts (code) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT sections_activation_check CHECK (activation IN ('Active', 'Desactive'))
);

-- Insert data into sections
INSERT INTO referentiel.sections (code, activation, created_at, titre_ar, titre_fr, updated_at, statut_code)
VALUES 
    ('SEC001', 'Active', CURRENT_TIMESTAMP, 'قسم 1', 'Section 1', CURRENT_TIMESTAMP, 'STAT001'),
    ('SEC002', 'Active', CURRENT_TIMESTAMP, 'قسم 2', 'Section 2', CURRENT_TIMESTAMP, 'STAT001');

-- Create table villes
DROP TABLE IF EXISTS referentiel.villes;

CREATE TABLE IF NOT EXISTS referentiel.villes (
    code VARCHAR(255) NOT NULL,
    activation VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name_ar VARCHAR(255) NOT NULL,
    nom_fr VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    gouvernorat_code VARCHAR(255),
    CONSTRAINT villes_pkey PRIMARY KEY (code),
    CONSTRAINT villes_gouvernorat_fkey FOREIGN KEY (gouvernorat_code)
        REFERENCES referentiel.gouvernorats (code) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT villes_activation_check CHECK (activation IN ('Active', 'Desactive'))
);

-- Insert data into villes
INSERT INTO referentiel.villes (code, activation, created_at, name_ar, nom_fr, updated_at, gouvernorat_code)
VALUES 
    ('VILLE001', 'Active', CURRENT_TIMESTAMP, 'مدينة تونس', 'Ville de Tunis', CURRENT_TIMESTAMP, 'GOUV001'),
    ('VILLE002', 'Active', CURRENT_TIMESTAMP, 'سكرة', 'Soukra', CURRENT_TIMESTAMP, 'GOUV002');



-- Create table code_postal
DROP TABLE IF EXISTS referentiel.code_postal;
CREATE TABLE IF NOT EXISTS referentiel.code_postal (
    id BIGINT NOT NULL DEFAULT nextval('referentiel.code_postal_id_seq'::regclass),
    activation VARCHAR(255) NOT NULL,
    code_postal VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ville_code VARCHAR(255),
    CONSTRAINT code_postal_pkey PRIMARY KEY (id),
    CONSTRAINT code_postal_ville_fkey FOREIGN KEY (ville_code)
        REFERENCES referentiel.villes (code) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT code_postal_activation_check CHECK (activation IN ('Active', 'Desactive'))
);

-- Insert data into code_postal
INSERT INTO referentiel.code_postal (id, activation, code_postal, created_at, updated_at, ville_code)
VALUES 
    (1, 'Active', '1000', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'VILLE001'),
    (2, 'Active', '2000', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'VILLE002');

-- Create table articles
DROP TABLE IF EXISTS referentiel.articles;
CREATE TABLE IF NOT EXISTS referentiel.articles (
    code VARCHAR(255) NOT NULL,
    activation VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    titre_ar VARCHAR(255) NOT NULL,
    titre_fr VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    section_code VARCHAR(255),
    CONSTRAINT articles_pkey PRIMARY KEY (code),
    CONSTRAINT articles_section_fkey FOREIGN KEY (section_code)
        REFERENCES referentiel.sections (code) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT articles_activation_check CHECK (activation IN ('Active', 'Desactive'))
);

-- Insert data into articles
INSERT INTO referentiel.articles (code, activation, created_at, titre_ar, titre_fr, updated_at, section_code)
VALUES 
    ('ART001', 'Active', CURRENT_TIMESTAMP, 'Titre AR A', 'Titre FR A', CURRENT_TIMESTAMP, 'SEC001'),
    ('ART002', 'Active', CURRENT_TIMESTAMP, 'Titre AR B', 'Titre FR B', CURRENT_TIMESTAMP, 'SEC002');

-- Create the sequence if it doesn't exist
CREATE SEQUENCE IF NOT EXISTS referentiel.propositions_id_seq;

-- Create table propositions
DROP TABLE IF EXISTS referentiel.propositions;
CREATE TABLE IF NOT EXISTS referentiel.propositions (
    id BIGINT NOT NULL DEFAULT nextval('referentiel.propositions_id_seq'::regclass),
    activation VARCHAR(255) NOT NULL,
    created_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    description TEXT,
    updated_at TIMESTAMP(6) WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    code_article VARCHAR(255),
    CONSTRAINT propositions_pkey PRIMARY KEY (id),
    CONSTRAINT propositions_article_fkey FOREIGN KEY (code_article)
        REFERENCES referentiel.articles (code) 
        ON UPDATE NO ACTION 
        ON DELETE NO ACTION,
    CONSTRAINT propositions_activation_check CHECK (activation IN ('Active', 'Desactive'))
);

-- Insert data into propositions
INSERT INTO referentiel.propositions (id, activation, created_at, description, updated_at, code_article)
VALUES 
    (1, 'Active', CURRENT_TIMESTAMP, 'Description proposition 1', CURRENT_TIMESTAMP, 'ART001'),
    (2, 'Active', CURRENT_TIMESTAMP, 'Description proposition 2', CURRENT_TIMESTAMP, 'ART002');
