package de.teberhardt.ablams.service;

import de.teberhardt.ablams.domain.AudioLibrary;
import de.teberhardt.ablams.web.dto.AudiobookDTO;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Audiobook.
 */
public interface AudiobookService {

    /**
     * Save a audiobook.
     *
     * @param audiobookDTO the entity to save
     * @return the persisted entity
     */
    AudiobookDTO save(AudiobookDTO audiobookDTO);

    /**
     * Get all the audiobooks.
     *
     * @return the list of entities
     */
    List<AudiobookDTO> findAll();
    /**
     * Get all the AudiobookDTO where Image is null.
     *
     * @return the list of entities
     */
    List<AudiobookDTO> findAllWhereImageIsNull();


    /**
     * Get the "id" audiobook.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AudiobookDTO> findOne(Long id);

    /**
     * Delete the "id" audiobook.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    void scan(Path folderPath, List<Path> audiofilePaths, AudioLibrary audioLibrary);
}
