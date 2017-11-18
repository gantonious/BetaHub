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
    @SerializedName("forks")
    private int totalForks;
    @SerializedName("watchers_count")
    private int totalWatchers;

    public int getTotalForks() {
        return totalForks;
    }

    public void setTotalForks(int totalForks) {
        this.totalForks = totalForks;
    }

    public int getTotalWatchers() {
        return totalWatchers;
    }

    public void setTotalWatchers(int totalWatchers) {
        this.totalWatchers = totalWatchers;
    }

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
