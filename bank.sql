PGDMP  '                    |           Bank    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16450    Bank    DATABASE     }   CREATE DATABASE "Bank" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Ukrainian_Ukraine.1252';
    DROP DATABASE "Bank";
                postgres    false            �            1259    16451    customer    TABLE     �   CREATE TABLE public.customer (
    surname text NOT NULL,
    name text,
    address text,
    phone_number text,
    date_of_birth date,
    iduser bigint NOT NULL
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    16456    customer_id_seq    SEQUENCE     x   CREATE SEQUENCE public.customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.customer_id_seq;
       public          postgres    false    215            �           0    0    customer_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.iduser;
          public          postgres    false    216            �            1259    16460 	   operation    TABLE     �   CREATE TABLE public.operation (
    id_operation bigint NOT NULL,
    operation_type text,
    date date,
    value text,
    operation_subtype text,
    id_worker bigint,
    id_customer bigint
);
    DROP TABLE public.operation;
       public         heap    postgres    false            �            1259    16465    operation_id_seq    SEQUENCE     y   CREATE SEQUENCE public.operation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.operation_id_seq;
       public          postgres    false    217            �           0    0    operation_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.operation_id_seq OWNED BY public.operation.id_operation;
          public          postgres    false    218            �            1259    16474    worker    TABLE     q   CREATE TABLE public.worker (
    id_worker bigint NOT NULL,
    name text NOT NULL,
    surname text NOT NULL
);
    DROP TABLE public.worker;
       public         heap    postgres    false            �            1259    16479    worker_id_seq    SEQUENCE     v   CREATE SEQUENCE public.worker_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.worker_id_seq;
       public          postgres    false    219            �           0    0    worker_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.worker_id_seq OWNED BY public.worker.id_worker;
          public          postgres    false    220            $           2604    16457    customer iduser    DEFAULT     n   ALTER TABLE ONLY public.customer ALTER COLUMN iduser SET DEFAULT nextval('public.customer_id_seq'::regclass);
 >   ALTER TABLE public.customer ALTER COLUMN iduser DROP DEFAULT;
       public          postgres    false    216    215            %           2604    16466    operation id_operation    DEFAULT     v   ALTER TABLE ONLY public.operation ALTER COLUMN id_operation SET DEFAULT nextval('public.operation_id_seq'::regclass);
 E   ALTER TABLE public.operation ALTER COLUMN id_operation DROP DEFAULT;
       public          postgres    false    218    217            &           2604    16480    worker id_worker    DEFAULT     m   ALTER TABLE ONLY public.worker ALTER COLUMN id_worker SET DEFAULT nextval('public.worker_id_seq'::regclass);
 ?   ALTER TABLE public.worker ALTER COLUMN id_worker DROP DEFAULT;
       public          postgres    false    220    219            �          0    16451    customer 
   TABLE DATA           _   COPY public.customer (surname, name, address, phone_number, date_of_birth, iduser) FROM stdin;
    public          postgres    false    215   �       �          0    16460 	   operation 
   TABLE DATA           y   COPY public.operation (id_operation, operation_type, date, value, operation_subtype, id_worker, id_customer) FROM stdin;
    public          postgres    false    217   $       �          0    16474    worker 
   TABLE DATA           :   COPY public.worker (id_worker, name, surname) FROM stdin;
    public          postgres    false    219   j       �           0    0    customer_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.customer_id_seq', 1, true);
          public          postgres    false    216            �           0    0    operation_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.operation_id_seq', 4, true);
          public          postgres    false    218            �           0    0    worker_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.worker_id_seq', 3, true);
          public          postgres    false    220            (           2606    16459    customer customer_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (iduser);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    215            *           2606    16468    operation operation_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id_operation);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_pkey;
       public            postgres    false    217            ,           2606    16482    worker worker_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.worker
    ADD CONSTRAINT worker_pkey PRIMARY KEY (id_worker);
 <   ALTER TABLE ONLY public.worker DROP CONSTRAINT worker_pkey;
       public            postgres    false    219            -           2606    16469    operation operationcustomer    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operationcustomer FOREIGN KEY (id_customer) REFERENCES public.customer(iduser) NOT VALID;
 E   ALTER TABLE ONLY public.operation DROP CONSTRAINT operationcustomer;
       public          postgres    false    4648    215    217            .           2606    16483    operation operationworker    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operationworker FOREIGN KEY (id_worker) REFERENCES public.worker(id_worker) NOT VALID;
 C   ALTER TABLE ONLY public.operation DROP CONSTRAINT operationworker;
       public          postgres    false    219    4652    217            �   6   x�N-JO���ϩL,���,�����N�4�01�4200�54"NC�=... z��      �   6   x�3���O��4202�50�522A "l�i�e���I�P�	^�@1z\\\ �wV      �   .   x�3�tI��tJ-�2�t,*�t-+�2��IL�I,J,����� ��	�     