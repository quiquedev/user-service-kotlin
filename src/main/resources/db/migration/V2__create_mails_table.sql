CREATE TABLE mails(
  mail_id uuid PRIMARY KEY,
  user_id uuid,
  value VARCHAR (500),
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (user_id),
  unique (mail_id, user_id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON users TO ${dbAppUser};