-- Relación: cada perfil pertenece a un usuario
ALTER TABLE profiles
    ADD CONSTRAINT FK_profiles_user_id
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE;

-- Relación: cada tarea pertenece a un perfil
ALTER TABLE tasks
    ADD CONSTRAINT FK_tasks_profile_id
        FOREIGN KEY (profile_id)
            REFERENCES profiles(id)
            ON DELETE CASCADE;

-- Ya tienes esta, pero la incluyo para contexto
ALTER TABLE tasks
    ADD CONSTRAINT FK_tasks_plant_id
        FOREIGN KEY (plant_id)
            REFERENCES plants(id)
            ON DELETE CASCADE;
