CREATE TABLE phone_numbers
(
    phone_number_id uuid PRIMARY KEY,
    user_id         uuid NOT NULL,
    value           VARCHAR(500),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    unique (phone_number_id, user_id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON users TO ${dbAppUser};