package com.trodev.smartkrishi.fragment;

public class BooksFragmentData {
    String bookname, pdf, image, key;

    public BooksFragmentData() {
    }

    public BooksFragmentData(String bookname, String pdf, String image, String key) {
        this.bookname = bookname;
        this.pdf = pdf;
        this.image = image;
        this.key = key;
    }

    public String getName() {
        return bookname;
    }

    public void setName(String bookname) {
        this.bookname = bookname;
    }

    public String getPdf() {
        return pdf;
    }
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
