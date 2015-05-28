/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain.interfaces;

import com.mycompany.vocabularytrainer.domain.DefaultVocabularyElementPair;
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
    public void setVocabularyElementPairs(List<DefaultVocabularyElementPair> pairs);
    
    /**
     * 
     * @return 
     */
    public List<DecorableRepresentative> getActiveOptions();
    
    /**
     * 
     * @return 
     */
    public DecorableRepresentative getActiveQuery();
    
    /**
     * 
     * @return 
     */
    public DecorableRepresentative getActiveQueryOption();
    
    /**
     * 
     * @return 
     */
    public List<DefaultVocabularyElementPair> getActivePairs();
    
    /**
     * 
     * @param activePairUuids 
     */
    public void setActivePairs(List<UUID> activePairUuids);
    
    /**
     * 
     * @param uuid 
     */
    public void setActiveQueryPair(UUID uuid);
    
    /**
     * 
     */
    public void setActiveQueryPair();
    
    /**
     * 
     * @return 
     */
    public DefaultVocabularyElementPair getActiveQueryPair();
    
    /**
     * 
     * @param uuid
     * @return 
     */
    public boolean isQueryOption(UUID uuid);
    
    /**
     * 
     * @param o 
     */
    public void addObserver(Observer o);
}
