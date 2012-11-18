/*
DROP TABLE IF EXISTS user_data CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS user_role;
*/

CREATE TABLE IF NOT EXISTS user_data
(
  id bigint NOT NULL,
  name character varying(100),
  password character varying(40),
  username character varying(32),
  CONSTRAINT user_data_pkey PRIMARY KEY (id ),
  CONSTRAINT user_data_username_key UNIQUE (username )
);

CREATE TABLE IF NOT EXISTS role
(
  id bigint NOT NULL,
  name character varying(100),
  CONSTRAINT role_pkey PRIMARY KEY (id )
);

CREATE TABLE IF NOT EXISTS user_role
(
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (user_id , role_id ),
  CONSTRAINT fk143bf46a15c0f479 FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk143bf46abaebb859 FOREIGN KEY (user_id)
      REFERENCES user_data (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
