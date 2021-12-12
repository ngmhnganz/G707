package com.Nhom8.model;

public class Sach {
    private int id;
    private String name;
    private String nhaSanXuat;
    private int taiBan;
    private double gia;
    private byte[] anh;

    public Sach(int id, String name, String nhaSanXuat, int taiBan, double gia, byte[] anh) {
        this.id = id;
        this.name = name;
        this.nhaSanXuat = nhaSanXuat;
        this.taiBan = taiBan;
        this.gia = gia;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getTaiBan() {
        return taiBan;
    }

    public void setTaiBan(int taiBan) {
        this.taiBan = taiBan;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public Sach() {
    }
}
