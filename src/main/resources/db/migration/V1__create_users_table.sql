CREATE TABLE users (
  user_id uuid PRIMARY KEY,
  last_name VARCHAR(500) NOT NULL,
  first_name VARCHAR(500) NOT NULL
);

GRANT SELECT, INSERT, DELETE ON users TO ${dbAppUser};

