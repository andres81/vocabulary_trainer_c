/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.Objects;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class VocabularyElementPair {

    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyElementPair.class);
    
    /**
     * 
     */
    private final Representative entryOne;
    
    /**
     * 
     */
    private final Representative entryTwo;
    
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
    public VocabularyElementPair(UUID uuid, Representative first, Representative second) {
        this.uuid = uuid;
        entryOne = first;
        entryTwo = second;
    }
    
    /**
     * 
     * @return 
     */
    public Representative getFirst() {
        return entryOne;
    }
    
    /**
     * 
     * @return 
     */
    public Representative getSecond() {
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
        if (obj instanceof VocabularyElementPair) {
            VocabularyElementPair pair = (VocabularyElementPair) obj;
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
