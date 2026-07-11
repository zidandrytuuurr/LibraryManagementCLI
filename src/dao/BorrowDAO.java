package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BorrowDAO {
    

    public void pinjamBuku(int idBuku, String namaPeminjam, String tanggalPinjam) {

        String sql = "INSERT INTO peminjaman(id_buku,nama_peminjam,tanggal_pinjam,status) VALUES(?,?,?,'Dipinjam')";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idBuku);
            ps.setString(2, namaPeminjam);
            ps.setString(3, tanggalPinjam);

            ps.executeUpdate();

            System.out.println("Peminjaman berhasil.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void tampilPeminjaman() {

        String sql = "SELECT * FROM peminjaman";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== DATA PEMINJAMAN =====");

            while (rs.next()) {

                System.out.println("ID Pinjam : " + rs.getInt("id_pinjam"));
                System.out.println("ID Buku   : " + rs.getInt("id_buku"));
                System.out.println("Nama      : " + rs.getString("nama_peminjam"));
                System.out.println("Tanggal   : " + rs.getDate("tanggal_pinjam"));
                System.out.println("Status    : " + rs.getString("status"));
                System.out.println("----------------------------");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void tampilViewPeminjaman() {

    String sql = "SELECT * FROM view_peminjaman";

    try (
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {

        System.out.println("\n===== DATA PEMINJAMAN =====");

        while (rs.next()) {

            System.out.println("ID Pinjam         : " + rs.getInt("id_pinjam"));
            System.out.println("Judul Buku        : " + rs.getString("judul"));
            System.out.println("Nama Peminjam     : " + rs.getString("nama_peminjam"));
            System.out.println("Tanggal Pinjam    : " + rs.getDate("tanggal_pinjam"));
            System.out.println("Tanggal Kembali   : " + rs.getDate("tanggal_kembali"));
            System.out.println("Status            : " + rs.getString("status"));
            System.out.println("----------------------------------");

        }

        } catch (Exception e) {
        System.out.println("Gagal menampilkan data.");
        System.out.println(e.getMessage());
        }

    }

    public void kembalikanBuku(int idPinjam) {

    String sql = """
        UPDATE peminjaman
        SET status='Dikembalikan',
            tanggal_kembali=CURDATE()
        WHERE id_pinjam=? AND status='Dipinjam'
        """;

    try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idPinjam);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {
            System.out.println("Buku berhasil dikembalikan.");
        } else {
            System.out.println("ID peminjaman tidak ditemukan atau buku sudah dikembalikan.");
        }

        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

}

