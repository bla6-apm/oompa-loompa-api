
CREATE USER oompa WITH PASSWORD 'oompa';
SELECT 'CREATE DATABASE oompa' WHERE NOT exists (SELECT FROM pg_database WHERE datname = 'oompa');
GRANT ALL PRIVILEGES ON DATABASE $APP_DB_NAME TO $APP_DB_USER;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS oompa_loompa (
  id varchar NOT NULL,
  name varchar NOT NULL,
  age numeric NOT NULL,
  job varchar NOT NULL,
  height varchar NULL,
  weight varchar NULL,
  description varchar NULL,
    CONSTRAINT oompa_pk PRIMARY KEY (id)
);

INSERT INTO oompa_loompa(id, name, age, job, height, weight, description) VALUES ('be414e09-deff-4c40-8cdb-75e72fe84b09','adroompa', 26, 'RRHH', '1.32', '0.42', 'Oompa Loompa that is a Recruiter and is recruiting another Oompa Loompas');
INSERT INTO oompa_loompa(id, name, age, job, height, weight, description) VALUES ('8f0c72fa-0028-4905-8f6e-95bccb6db652','laroompa', 43, 'Lumberjack', '1.49', '0.47', 'Expand the house of Oompa Loompas');
INSERT INTO oompa_loompa(id, name, age, job, height, weight, description) VALUES ('8d8eebc8-d0a1-46cd-8456-b3756a5f9242','taroompa', 28, 'Writer', '1.10', '0.49', 'Write articles to get know the Oompa Loompas');
INSERT INTO oompa_loompa(id, name, age, job, height, weight, description) VALUES ('10816732-b3b0-4e7f-8289-5695ee6c4950','mojangoompa', 20, 'Boss', '1', '0.29', 'The Master Chief(Halo)');
INSERT INTO oompa_loompa(id, name, age, job, height, weight, description) VALUES ('0f7af871-3ea9-4ed4-bfe2-a7be7ae8bace','halooompa', 40, 'Architect', '1.3', '0.9', '');