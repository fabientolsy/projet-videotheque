PGDMP     3    "            	    y           ecole    13.4    13.3     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16394    ecole    DATABASE     a   CREATE DATABASE ecole WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_Canada.1252';
    DROP DATABASE ecole;
                postgres    false            ?            1259    16445    videotheque    TABLE     ?   CREATE TABLE public.videotheque (
    id integer NOT NULL,
    titre text NOT NULL,
    realisateur text,
    temps integer,
    categorie text
);
    DROP TABLE public.videotheque;
       public         heap    fabien    false            ?            1259    16443    videotheque_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.videotheque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.videotheque_id_seq;
       public          fabien    false    203            ?           0    0    videotheque_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.videotheque_id_seq OWNED BY public.videotheque.id;
          public          fabien    false    202            (           2604    16448    videotheque id    DEFAULT     p   ALTER TABLE ONLY public.videotheque ALTER COLUMN id SET DEFAULT nextval('public.videotheque_id_seq'::regclass);
 =   ALTER TABLE public.videotheque ALTER COLUMN id DROP DEFAULT;
       public          fabien    false    203    202    203            ?          0    16445    videotheque 
   TABLE DATA           O   COPY public.videotheque (id, titre, realisateur, temps, categorie) FROM stdin;
    public          fabien    false    203   ?
       ?           0    0    videotheque_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.videotheque_id_seq', 9, true);
          public          fabien    false    202            *           2606    16453    videotheque videotheque_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.videotheque
    ADD CONSTRAINT videotheque_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.videotheque DROP CONSTRAINT videotheque_pkey;
       public            fabien    false    203            ?   m   x?5ʻ
? @?9??L?-u??(J?.?K?AH$??/(.?,??i????r????ڍ?.τ?"Ei????H1???7??yr9\?y?[??????#9?_?~@?|?$     