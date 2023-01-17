package Entities;

public enum Environment {
    URL("http://localhost:3001");

    private String url;

    Environment(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}