package com.starwarsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Film implements Serializable {

    public String title;
    @SerializedName("episode_id")
    public int episodeId;
    public String director;
    public String producer;

    public Film(String title, int episodeId, String director, String producer) {
        this.title = title;
        this.episodeId = episodeId;
        this.director = director;
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

