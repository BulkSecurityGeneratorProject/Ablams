package de.teberhardt.ablams.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AudioLibrary entity.
 */
public class AudioLibraryDTO implements Serializable {

    private Long id;

    private String filepath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AudioLibraryDTO audioLibraryDTO = (AudioLibraryDTO) o;
        if (audioLibraryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), audioLibraryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AudioLibraryDTO{" +
            "id=" + getId() +
            ", filepath='" + getFilepath() + "'" +
            "}";
    }
}
