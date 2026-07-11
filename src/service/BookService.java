package service;

import dao.BookDAO;
import model.Book;

public class BookService {

    private BookDAO dao = new BookDAO();

    public void tambahBuku(String judul, String penulis, int stok) {

        Book book = new Book(0, judul, penulis, stok);

        dao.tambahBuku(book);

    }

    public void tampilBuku() {

        dao.tampilBuku();

    }

    public void cariBuku(int id) {
    dao.cariBuku(id);
    }

    public void updateBuku(int id, String judul, String penulis, int stok) {
    dao.updateBuku(id, judul, penulis, stok);
    }

    public void hapusBuku(int id) {
    dao.hapusBuku(id);
    }

}