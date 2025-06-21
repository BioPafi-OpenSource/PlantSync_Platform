ALTER TABLE tasks
    ADD CONSTRAINT FK_tasks_plant_id
        FOREIGN KEY (plant_id)
            REFERENCES plants (id)
            ON DELETE CASCADE;