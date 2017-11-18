package ca.antonious.betahub.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by George on 2017-11-12.
 */

public class Repository implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("stargazers_count")
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
