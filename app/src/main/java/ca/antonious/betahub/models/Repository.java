package ca.antonious.betahub.models;

import java.io.Serializable;

/**
 * Created by George on 2017-11-12.
 */

public class Repository implements Serializable {
    private String name;
    private int totalStars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }
}
