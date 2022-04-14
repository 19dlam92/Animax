package com.lam.anime.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "series")
public class AnimeModel {

    // ====================================
	// DOMAIN MODEL - 
	// ====================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 200, message = "MUST be at least 2 characters!")
    private String shows;

    @NotNull
    @Size(min = 2, max = 200, message = "MUST be at least 2 characters!")
    private String manga;

    @NotNull
    @Size(min = 2, max = 200, message = "MUST be at least 2 characters!")
    private String genre;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


    // ====================================
	// EMPTY CONSTRUCTOR
	// ====================================
    public AnimeModel() {
        
    }


    // ====================================
	// LOADED CONSTRUCTOR
	// ====================================
    public AnimeModel(String shows, String manga, String genre) {
        this.shows = shows;
        this.manga = manga;
        this.genre = genre;
    }


    // ====================================
	// GETTERS
	// ====================================
    public String getShows() {
        return shows;
    }
    public String getManga() {
        return manga;
    }
    public String getGenre() {
        return genre;
    }


    // ====================================
	// SETTERS
	// ====================================
    public void setShows(String shows) {
        this.shows = shows;
    }
    public void setManga(String manga) {
        this.manga = manga;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // ====================================
	// CREATED AT & UPDATED AT
	// ====================================
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
