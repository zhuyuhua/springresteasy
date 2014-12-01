drop database if exists contact;
create database contact character set utf8;

-- Table: contact

-- DROP TABLE contact;

CREATE TABLE contact
(
  id integer NOT NULL,
  name character varying(75),
  email character varying(75),
  phone character varying(75),
  CONSTRAINT contact_pkey PRIMARY KEY (id)
);


-- Table: contacttocontactjointable

-- DROP TABLE contacttocontactjointable;

CREATE TABLE contacttocontactjointable
(
  parentcontactid integer NOT NULL,
  childcontactid integer NOT NULL,
  CONSTRAINT contacttocontactjointable_pkey PRIMARY KEY (parentcontactid, childcontactid),
  CONSTRAINT contacttocontactjointable_childcontactid_fkey FOREIGN KEY (childcontactid)
      REFERENCES contact (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT contacttocontactjointable_parentcontactid_fkey FOREIGN KEY (parentcontactid)
      REFERENCES contact (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);