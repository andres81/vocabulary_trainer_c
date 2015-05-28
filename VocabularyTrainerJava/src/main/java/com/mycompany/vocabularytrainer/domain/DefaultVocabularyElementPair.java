/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.DecorableRepresentative;
import java.util.Objects;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class DefaultVocabularyElementPair {

    // Logging
    private static final Logger logger = LogManager.getLogger(DefaultVocabularyElementPair.class);
    
    /**
     * 
     */
    private final DecorableRepresentative entryOne;
    
    /**
     * 
     */
    private final DecorableRepresentative entryTwo;
    
    /**
     * 
     */
    private final UUID uuid;
    
    /**
     * 
     * @param uuid
     * @param first
     * @param second
     */
    public DefaultVocabularyElementPair(UUID uuid, DecorableRepresentative first, DecorableRepresentative second) {
        this.uuid = uuid;
        entryOne = first;
        entryTwo = second;
    }
    
    /**
     * 
     * @return 
     */
    public DecorableRepresentative getFirst() {
        return entryOne;
    }
    
    /**
     * 
     * @return 
     */
    public DecorableRepresentative getSecond() {
        return entryTwo;
    }
    
    /**
     * 
     * @return 
     */
    public UUID getUuid() {
        return uuid;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DefaultVocabularyElementPair) {
            DefaultVocabularyElementPair pair = (DefaultVocabularyElementPair) obj;
            return uuid == pair.getUuid();
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.uuid);
        return hash;
    }
}
