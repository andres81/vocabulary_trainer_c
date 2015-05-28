/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.List;
import java.util.Observer;
import java.util.UUID;

/**
 *
 * @author andre
 */
public interface VocabularyModel {
    
    /**
     * 
     */
    public enum Direction {
       COLUMNONETOONE,
       COLUMNONETOTWO,
       COLUMNTWOTOONE,
       COLUMNTWOTOTWO;
    };
    
    /**
     * 
     * @param direction 
     */
    public void setDirection(Direction direction);
    
    /**
     * 
     * @param pairs 
     */
    public void setVocabularyEntryPairs(List<VocabularyEntryPair> pairs);
    
    public List<Representative> getActiveOptions();
    
    public Representative getActiveQuery();
    
    public List<VocabularyEntryPair> getActivePairs();
    
    public void setActivePairs(List<UUID> activePairUuids);
    
    public void setActiveQueryPair(UUID uuid);
    
    public void setActiveQueryPair();
    
    public VocabularyEntryPair getActiveQueryPair();
    
    public boolean isQueryOption(UUID uuid);
    
    public void addObserver(Observer o);
}
