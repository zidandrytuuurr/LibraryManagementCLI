package model;

public class Member extends Person {

    public Member() {
    }

    public Member(String nama) {
        super(nama);
    }

    @Override
    public void displayData() {
        System.out.println("Peminjam : " + getNama());
    }
}