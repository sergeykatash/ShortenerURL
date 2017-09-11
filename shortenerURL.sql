--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2017-09-11 18:44:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16631)
-- Name: tags; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tags (
    id_tag integer NOT NULL,
    name_tag text
);


ALTER TABLE public.tags OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16629)
-- Name: tags_id_tag_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tags_id_tag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tags_id_tag_seq OWNER TO postgres;

--
-- TOC entry 1968 (class 0 OID 0)
-- Dependencies: 172
-- Name: tags_id_tag_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tags_id_tag_seq OWNED BY tags.id_tag;


--
-- TOC entry 171 (class 1259 OID 16617)
-- Name: urls; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE urls (
    id integer NOT NULL,
    url text,
    shorturl text,
    description text,
    id_tag integer,
    id_user integer
);


ALTER TABLE public.urls OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16615)
-- Name: urls_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE urls_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.urls_id_seq OWNER TO postgres;

--
-- TOC entry 1969 (class 0 OID 0)
-- Dependencies: 170
-- Name: urls_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE urls_id_seq OWNED BY urls.id;


--
-- TOC entry 175 (class 1259 OID 33095)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id_user integer NOT NULL,
    username text,
    password text,
    role text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 33093)
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_user_seq OWNER TO postgres;

--
-- TOC entry 1970 (class 0 OID 0)
-- Dependencies: 174
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_user_seq OWNED BY users.id_user;


--
-- TOC entry 1839 (class 2604 OID 16634)
-- Name: id_tag; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tags ALTER COLUMN id_tag SET DEFAULT nextval('tags_id_tag_seq'::regclass);


--
-- TOC entry 1838 (class 2604 OID 16620)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY urls ALTER COLUMN id SET DEFAULT nextval('urls_id_seq'::regclass);


--
-- TOC entry 1840 (class 2604 OID 33098)
-- Name: id_user; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id_user SET DEFAULT nextval('users_id_user_seq'::regclass);


--
-- TOC entry 1957 (class 0 OID 16631)
-- Dependencies: 173
-- Data for Name: tags; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tags (id_tag, name_tag) FROM stdin;
\.


--
-- TOC entry 1971 (class 0 OID 0)
-- Dependencies: 172
-- Name: tags_id_tag_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tags_id_tag_seq', 48, true);


--
-- TOC entry 1955 (class 0 OID 16617)
-- Dependencies: 171
-- Data for Name: urls; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY urls (id, url, shorturl, description, id_tag, id_user) FROM stdin;
\.


--
-- TOC entry 1972 (class 0 OID 0)
-- Dependencies: 170
-- Name: urls_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('urls_id_seq', 57, true);


--
-- TOC entry 1959 (class 0 OID 33095)
-- Dependencies: 175
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id_user, username, password, role) FROM stdin;
\.


--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 174
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_user_seq', 19, true);


--
-- TOC entry 1844 (class 2606 OID 16639)
-- Name: tags_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tags
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id_tag);


--
-- TOC entry 1842 (class 2606 OID 16625)
-- Name: urls_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY urls
    ADD CONSTRAINT urls_pkey PRIMARY KEY (id);


--
-- TOC entry 1846 (class 2606 OID 33103)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-09-11 18:44:17

--
-- PostgreSQL database dump complete
--

