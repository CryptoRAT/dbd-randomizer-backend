CREATE TYPE perk_type AS ENUM ('Killer', 'Survivor');
CREATE TYPE character_type AS ENUM ('Killer', 'Survivor');

CREATE TABLE IF NOT EXISTS characters
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(50)  NOT NULL,
    colloquial_name VARCHAR(50),
    type            character_type,
    lore            TEXT         NOT NULL,
    image_path      VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS perks
(
    id              SERIAL PRIMARY KEY,
    character_id    INT          NOT NULL,
    name            VARCHAR(100) NOT NULL,
    colloquial_name VARCHAR(50),
    type            perk_type,
    description     VARCHAR(255) NOT NULL,
    image_path      VARCHAR(255) NOT NULL,
    CONSTRAINT fk_character FOREIGN KEY (character_id) REFERENCES characters (id) ON DELETE SET NULL
);

