package Entities;

public enum Environment {
    URL("https://dsternlicht.github.io/RESTool");

    private String url;

    Environment(String envUrl) {
        this.url = envUrl;
    }

    public String getUrl() {
        return url;
    }
}