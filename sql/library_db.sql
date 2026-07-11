-- ============================================================
-- SISTEM MANAJEMEN PERPUSTAKAAN
-- LibraryManagementCLI
-- Database : library_db
-- ============================================================

DROP DATABASE IF EXISTS library_db;
CREATE DATABASE library_db;
USE library_db;

-- ============================================================
-- TABLE BUKU
-- ============================================================

CREATE TABLE buku (
    id_buku INT AUTO_INCREMENT PRIMARY KEY,
    judul VARCHAR(100) NOT NULL,
    penulis VARCHAR(100) NOT NULL,
    stok INT NOT NULL
);

-- ============================================================
-- TABLE PEMINJAMAN
-- ============================================================

CREATE TABLE peminjaman (
    id_pinjam INT AUTO_INCREMENT PRIMARY KEY,
    id_buku INT NOT NULL,
    nama_peminjam VARCHAR(100) NOT NULL,
    tanggal_pinjam DATE NOT NULL,
    tanggal_kembali DATE,
    status ENUM('Dipinjam','Dikembalikan') DEFAULT 'Dipinjam',

    CONSTRAINT fk_buku
    FOREIGN KEY (id_buku)
    REFERENCES buku(id_buku)
);

-- ============================================================
-- DATA CONTOH
-- ============================================================

INSERT INTO buku (judul, penulis, stok)
VALUES
('Pemrograman Java','Deandry',4),
('Pemrograman Java','Deandry',8),
('Belajar Java','Andi',10);

INSERT INTO peminjaman
(id_buku,nama_peminjam,tanggal_pinjam,tanggal_kembali,status)
VALUES
(1,'Deandry','2026-07-11',NULL,'Dipinjam'),
(2,'Budi','2026-07-10','2026-07-12','Dikembalikan');

-- ============================================================
-- VIEW
-- ============================================================

CREATE VIEW view_peminjaman AS

SELECT

    p.id_pinjam,
    b.judul,
    p.nama_peminjam,
    p.tanggal_pinjam,
    p.tanggal_kembali,
    p.status

FROM peminjaman p

JOIN buku b
ON p.id_buku = b.id_buku;

-- ============================================================
-- STORED PROCEDURE
-- ============================================================

DELIMITER $$

CREATE PROCEDURE tampilSemuaBuku()

BEGIN

    SELECT *
    FROM buku;

END $$

DELIMITER ;

-- ============================================================
-- FUNCTION
-- ============================================================

DELIMITER $$

CREATE FUNCTION totalStok()

RETURNS INT

DETERMINISTIC

BEGIN

    DECLARE jumlah INT;

    SELECT SUM(stok)
    INTO jumlah
    FROM buku;

    RETURN IFNULL(jumlah,0);

END $$

DELIMITER ;

-- ============================================================
-- TRIGGER
-- Mengurangi stok otomatis saat buku dipinjam
-- ============================================================

DELIMITER $$

CREATE TRIGGER kurangi_stok

AFTER INSERT
ON peminjaman

FOR EACH ROW

BEGIN

    UPDATE buku

    SET stok = stok - 1

    WHERE id_buku = NEW.id_buku;

END $$

DELIMITER ;

-- ============================================================
-- TEST QUERY
-- ============================================================

CALL tampilSemuaBuku();

SELECT totalStok();

SELECT * FROM view_peminjaman;

SELECT * FROM buku;

SELECT * FROM peminjaman;