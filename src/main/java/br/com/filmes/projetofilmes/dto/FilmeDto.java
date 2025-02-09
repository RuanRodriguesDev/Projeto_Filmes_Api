package br.com.filmes.projetofilmes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FilmeDto {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Actors")
    private String actors;

    public FilmeDto(String title, String poster, String plot, String actors) {
        this.title = title;
        this.poster = poster;
        this.plot = plot;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }

    public String getActors() {
        return actors;
    }

    
}