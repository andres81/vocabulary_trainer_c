/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class VocabularyEntryPair {

    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyEntryPair.class);
    
    /**
     * 
     */
    private Representative entryOne = null;
    
    /**
     * 
     */
    private Representative entryTwo = null;
    
    /**
     * 
     */
    private UUID uuid = null;
    
    /**
     * 
     * @param uuid
     */
    public VocabularyEntryPair(UUID uuid) {
        this.uuid = new UUID(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }
    
    /**
     * 
     * @param uuid
     * @param first
     * @param second
     */
    public VocabularyEntryPair(UUID uuid, Representative first, Representative second) {
        this(uuid);
        entryOne = first;
        entryTwo = second;
    }
    
    /**
     * 
     * @param first
     */
    public void setFirst(Representative first) {
        entryOne = first;
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
     * @param second 
     */
    public void setSecond(Representative second) {
        entryTwo = second;
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
     * @param first
     * @param second 
     */
    public void setEntries(Representative first, Representative second) {
        entryOne = first;
        entryTwo = second;
    }
    
    /**
     * 
     * @return 
     */
    public UUID getUuid() {
        return uuid;
    }
}
