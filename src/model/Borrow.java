package model;

public class Borrow {

    private int idPinjam;
    private int idBuku;
    private String namaPeminjam;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String status;

    public Borrow() {
    }

    public Borrow(int idPinjam, int idBuku, String namaPeminjam,
                  String tanggalPinjam, String tanggalKembali, String status) {
        this.idPinjam = idPinjam;
        this.idBuku = idBuku;
        this.namaPeminjam = namaPeminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    public int getIdPinjam() {
        return idPinjam;
    }

    public void setIdPinjam(int idPinjam) {
        this.idPinjam = idPinjam;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayData() {
        System.out.println("-------------------------");
        System.out.println("ID Pinjam      : " + idPinjam);
        System.out.println("ID Buku        : " + idBuku);
        System.out.println("Nama Peminjam  : " + namaPeminjam);
        System.out.println("Tanggal Pinjam : " + tanggalPinjam);
        System.out.println("Tanggal Kembali: " + tanggalKembali);
        System.out.println("Status         : " + status);
    }
}