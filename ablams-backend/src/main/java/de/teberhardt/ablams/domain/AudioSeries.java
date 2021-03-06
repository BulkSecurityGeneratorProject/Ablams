package de.teberhardt.ablams.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A AudioSeries.
 */
@Entity
@Table(name = "audio_series")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AudioSeries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "series_name")
    private String seriesName;

    @OneToMany(mappedBy = "series")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Audiobook> audiobooks = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("audioSeries")
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public AudioSeries seriesName(String seriesName) {
        this.seriesName = seriesName;
        return this;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Set<Audiobook> getAudiobooks() {
        return audiobooks;
    }

    public AudioSeries audiobooks(Set<Audiobook> audiobooks) {
        this.audiobooks = audiobooks;
        return this;
    }

    public AudioSeries addAudiobook(Audiobook audiobook) {
        this.audiobooks.add(audiobook);
        audiobook.setSeries(this);
        return this;
    }

    public AudioSeries removeAudiobook(Audiobook audiobook) {
        this.audiobooks.remove(audiobook);
        audiobook.setSeries(null);
        return this;
    }

    public void setAudiobooks(Set<Audiobook> audiobooks) {
        this.audiobooks = audiobooks;
    }

    public Author getAuthor() {
        return author;
    }

    public AudioSeries author(Author author) {
        this.author = author;
        return this;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AudioSeries audioSeries = (AudioSeries) o;
        if (audioSeries.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), audioSeries.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AudioSeries{" +
            "id=" + getId() +
            ", seriesName='" + getSeriesName() + "'" +
            "}";
    }
}
