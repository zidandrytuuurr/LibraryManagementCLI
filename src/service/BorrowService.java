package service;

import dao.BorrowDAO;

public class BorrowService {

    private BorrowDAO dao = new BorrowDAO();

    public void pinjamBuku(int idBuku, String nama, String tanggal) {

        dao.pinjamBuku(idBuku, nama, tanggal);

    }

    public void tampilPeminjaman() {

        dao.tampilPeminjaman();

    }

    public void tampilView() {
    dao.tampilViewPeminjaman();

    }

    public void kembalikanBuku(int idPinjam) {
    dao.kembalikanBuku(idPinjam);
    }

}