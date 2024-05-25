package com.trodev.smartkrishi.newsactivity;

public class NewsData {
    String url, image, key;

    public NewsData() {
    }

    public NewsData(String image, String url, String key) {
        this.url= url;
        this.image = image;
        this.key = key;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
