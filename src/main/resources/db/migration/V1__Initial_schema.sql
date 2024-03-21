
CREATE TABLE courses (
  id          BIGSERIAL PRIMARY KEY NOT NULL,
  category    VARCHAR(255),
  description VARCHAR(255),
  name        VARCHAR(255),
  rating      INTEGER NOT NULL
);