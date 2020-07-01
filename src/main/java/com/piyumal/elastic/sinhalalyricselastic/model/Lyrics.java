package com.piyumal.elastic.sinhalalyricselastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "songs", type ="songs", shards = 2)
public class Lyrics {
    @Id
    private String track_id;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String track_name_en;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String track_name_si;
    private String track_rating;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String album_name_en;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String album_name_si;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String artist_name_en;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String artist_name_si;
    private String artist_rating;
    @MultiField(
            mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = {
                    @InnerField(suffix = "verbatim", type = FieldType.Keyword)
            }
    )
    private String lyrics;

    public Lyrics() {
    }

    public Lyrics(String track_id, String track_name_en, String track_name_si, String track_rating, String album_name_en, String album_name_si, String artist_name_en, String artist_name_si, String artist_rating, String lyrics) {
        this.track_id = track_id;
        this.track_name_en = track_name_en;
        this.track_name_si = track_name_si;
        this.track_rating = track_rating;
        this.album_name_en = album_name_en;
        this.album_name_si = album_name_si;
        this.artist_name_en = artist_name_en;
        this.artist_name_si = artist_name_si;
        this.artist_rating = artist_rating;
        this.lyrics = lyrics;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public String getTrack_name_en() {
        return track_name_en;
    }

    public void setTrack_name_en(String track_name_en) {
        this.track_name_en = track_name_en;
    }

    public String getTrack_name_si() {
        return track_name_si;
    }

    public void setTrack_name_si(String track_name_si) {
        this.track_name_si = track_name_si;
    }

    public String getTrack_rating() {
        return track_rating;
    }

    public void setTrack_rating(String track_rating) {
        this.track_rating = track_rating;
    }

    public String getAlbum_name_en() {
        return album_name_en;
    }

    public void setAlbum_name_en(String album_name_en) {
        this.album_name_en = album_name_en;
    }

    public String getAlbum_name_si() {
        return album_name_si;
    }

    public void setAlbum_name_si(String album_name_si) {
        this.album_name_si = album_name_si;
    }

    public String getArtist_name_en() {
        return artist_name_en;
    }

    public void setArtist_name_en(String artist_name_en) {
        this.artist_name_en = artist_name_en;
    }

    public String getArtist_name_si() {
        return artist_name_si;
    }

    public void setArtist_name_si(String artist_name_si) {
        this.artist_name_si = artist_name_si;
    }

    public String getArtist_rating() {
        return artist_rating;
    }

    public void setArtist_rating(String artist_rating) {
        this.artist_rating = artist_rating;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
