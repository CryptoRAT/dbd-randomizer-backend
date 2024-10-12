-- Alter the perks table to remove the colloquial_name column
ALTER TABLE perks
    DROP COLUMN colloquial_name;

-- Alter the perks table to rename the character_id column to owner_id
ALTER TABLE perks
    RENAME COLUMN character_id TO owner_id;

-- Update the foreign key constraint on the renamed owner_id column
ALTER TABLE perks
    DROP CONSTRAINT fk_character;
ALTER TABLE perks
    ADD CONSTRAINT fk_character FOREIGN KEY (owner_id) REFERENCES characters (id) ON DELETE SET NULL;