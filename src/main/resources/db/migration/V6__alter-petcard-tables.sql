--ALTER TABLE pet_cards
--ADD COLUMN vaccine_info_id BIGINT,
--ADD COLUMN medication_info_id BIGINT;
--
--ALTER TABLE pet_cards
--ADD CONSTRAINT fk_pet_cards_vaccine_info FOREIGN KEY (vaccine_info_id) REFERENCES vaccine_info(id),
--ADD CONSTRAINT fk_pet_cards_medication_info FOREIGN KEY (medication_info_id) REFERENCES medication_info(id);

ALTER TABLE vaccine_info
ADD COLUMN pet_card_id TEXT,
ADD CONSTRAINT fk_vaccine_info_pet_card FOREIGN KEY (pet_card_id) REFERENCES pet_cards(id);

ALTER TABLE medication_info
ADD COLUMN pet_card_id TEXT,
ADD CONSTRAINT fk_medication_info_pet_card FOREIGN KEY (pet_card_id) REFERENCES pet_cards(id);