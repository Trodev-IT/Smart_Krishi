package com.trodev.smartkrishi.weatheractivity;

public class WeatherData {
    String url, image, key;

    public WeatherData() {
    }

    public WeatherData(String image, String url, String key) {
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
