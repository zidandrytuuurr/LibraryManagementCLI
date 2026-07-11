package main;

import java.util.Scanner;
import service.BookService;
import service.BorrowService;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BookService bookService = new BookService();
        BorrowService borrowService = new BorrowService();

        int pilih;

        do {

            System.out.println("\n====================================");
            System.out.println("   SISTEM MANAJEMEN PERPUSTAKAAN");
            System.out.println("====================================");
            System.out.println("1. Kelola Buku");
            System.out.println("2. Peminjaman Buku");
            System.out.println("3. Laporan");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    menuBuku(input, bookService);
                    break;

                case 2:
                    menuPinjam(input, borrowService);
                    break;

                case 3:
                    menuLaporan(bookService, borrowService);
                    break;

                case 0:
                    System.out.println("Terima kasih.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");

            }

        } while (pilih != 0);

        input.close();

    }

    public static void menuBuku(Scanner input, BookService service) {

    int pilih;

    do {

        System.out.println("\n=================================");
        System.out.println("         KELOLA BUKU");
        System.out.println("=================================");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Semua Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Ubah Buku");
        System.out.println("5. Hapus Buku");
        System.out.println("0. Kembali");
        System.out.println("=================================");
        System.out.print("Pilih Menu : ");

        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {

            case 1:

                System.out.print("Judul Buku : ");
                String judul = input.nextLine();

                System.out.print("Penulis : ");
                String penulis = input.nextLine();

                System.out.print("Stok : ");
                int stok = input.nextInt();
                input.nextLine();

                service.tambahBuku(judul, penulis, stok);
                break;

            case 2:

                service.tampilBuku();
                break;

            case 3:

    System.out.print("Masukkan ID Buku : ");
    int idCari = input.nextInt();
    input.nextLine();

    service.cariBuku(idCari);

    break;

            case 4:

    System.out.print("Masukkan ID Buku : ");
    int idUpdate = input.nextInt();
    input.nextLine();

    System.out.print("Judul Baru : ");
    String judulBaru = input.nextLine();

    System.out.print("Penulis Baru : ");
    String penulisBaru = input.nextLine();

    System.out.print("Stok Baru : ");
    int stokBaru = input.nextInt();
    input.nextLine();

    service.updateBuku(idUpdate, judulBaru, penulisBaru, stokBaru);

    break;

            case 5:

    System.out.print("Masukkan ID Buku yang akan dihapus : ");
    int idHapus = input.nextInt();
    input.nextLine();

    service.hapusBuku(idHapus);

    break;

            case 0:

                break;

            default:

                System.out.println("Menu tidak tersedia.");

        }

    } while (pilih != 0);

}

    public static void menuPinjam(Scanner input, BorrowService service) {

        int pilih;

        do {

            System.out.println("\n===== PEMINJAMAN =====");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Lihat Peminjaman");
            System.out.println("3. Kembalikan Buku");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:

                    System.out.print("ID Buku : ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Peminjam : ");
                    String nama = input.nextLine();

                    System.out.print("Tanggal Pinjam (YYYY-MM-DD): ");
                    String tanggal = input.nextLine();

                    service.pinjamBuku(id, nama, tanggal);

                    break;

                case 2:

                    service.tampilPeminjaman();

                    break;

                case 3:

                    System.out.print("Masukkan ID Peminjaman : ");
                    int idPinjam = input.nextInt();
                    input.nextLine();

                    service.kembalikanBuku(idPinjam);

    break;

            }

        } while (pilih != 0);

    }

    public static void menuLaporan(BookService bookService,
                                   BorrowService borrowService) {

        System.out.println("\n===== LAPORAN =====");

        System.out.println("\nData Buku");
        bookService.tampilBuku();

        System.out.println("\nData Peminjaman");
        borrowService.tampilView();

    }

}