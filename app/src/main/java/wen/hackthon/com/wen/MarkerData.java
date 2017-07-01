package wen.hackthon.com.wen;

/**
 * Created by amitabhs on 01/07/17.
 */

public class MarkerData {

    private String title;
    private double latit;
    private double longit;

    public MarkerData(double latit, double longit, String title) {
        this.title = title;
        this.latit = latit;
        this.longit = longit;
    }

    public String getTitle() {
        return title;
    }

    public double getLatit() {
        return latit;
    }

    public double getLongit() {
        return longit;
    }
}
