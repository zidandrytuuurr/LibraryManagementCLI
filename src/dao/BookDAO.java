package dao;

import database.DatabaseConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    public void tambahBuku(Book book) {

        String sql = "INSERT INTO buku(judul, penulis, stok) VALUES(?,?,?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getJudul());
            ps.setString(2, book.getPenulis());
            ps.setInt(3, book.getStok());
            
System.out.println("DEBUG STOK = " + book.getStok());

            ps.executeUpdate();

            System.out.println("Data buku berhasil ditambahkan.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void tampilBuku() {

        String sql = "SELECT * FROM buku";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== DAFTAR BUKU =====");

            while (rs.next()) {

                System.out.println("ID      : " + rs.getInt("id_buku"));
                System.out.println("Judul   : " + rs.getString("judul"));
                System.out.println("Penulis : " + rs.getString("penulis"));
                System.out.println("Stok    : " + rs.getInt("stok"));
                System.out.println("-------------------------");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void cariBuku(int id) {

    String sql = "SELECT * FROM buku WHERE id_buku=?";

    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\n===== DATA BUKU =====");
            System.out.println("ID      : " + rs.getInt("id_buku"));
            System.out.println("Judul   : " + rs.getString("judul"));
            System.out.println("Penulis : " + rs.getString("penulis"));
            System.out.println("Stok    : " + rs.getInt("stok"));

        } else {

            System.out.println("Buku tidak ditemukan.");

        }

        } catch (Exception e) {
        System.out.println(e.getMessage());
        }

    }

    public void updateBuku(int id, String judul, String penulis, int stok) {

    String sql = "UPDATE buku SET judul=?, penulis=?, stok=? WHERE id_buku=?";

    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, judul);
        ps.setString(2, penulis);
        ps.setInt(3, stok);
        ps.setInt(4, id);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("ID Buku tidak ditemukan.");
        }

        } catch (Exception e) {
        System.out.println(e.getMessage());
        }

    }

    public void hapusBuku(int id) {

    String sql = "DELETE FROM buku WHERE id_buku=?";

    try (
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setInt(1, id);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("ID Buku tidak ditemukan.");
        }

        } catch (Exception e) {
        System.out.println(e.getMessage());
        }

    }

}
