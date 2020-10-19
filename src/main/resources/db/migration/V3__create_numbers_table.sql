CREATE TABLE numbers
(
    number_id uuid PRIMARY KEY,
    user_id         uuid NOT NULL,
    value           VARCHAR(500),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    unique (number_id, user_id)
);

GRANT SELECT, INSERT, DELETE ON numbers TO ${dbAppUser};