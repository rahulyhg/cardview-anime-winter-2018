package xyz.rasyidcode.animewinter2018.model;

/**
 * Created by Jamil on 2/14/2018.
 */

public class AnimeWinter {
    private String title;
    private int numOfEps;
    private int thumbnail;

    public AnimeWinter() {}

    public AnimeWinter(String title, int numOfEps, int thumbnail) {
        this.title = title;
        this.numOfEps = numOfEps;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfEps() {
        return numOfEps;
    }

    public void setNumOfEps(int numOfEps) {
        this.numOfEps = numOfEps;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
