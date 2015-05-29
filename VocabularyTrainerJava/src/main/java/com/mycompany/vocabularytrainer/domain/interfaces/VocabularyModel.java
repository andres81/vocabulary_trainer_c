/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain.interfaces;

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
     */
    public enum UpdateType {
       PAIRS,
       ACTIVEPAIRS,
       DIRECTION,
       ACTIVEPAIR,
       INTERACTIONTYPE;
    };
    
    /**
     * 
     */
    public enum Status {
       ACTIVEPAIR,
       ACTIVEQUERYPAIR,
       ACTIVEQUERY,
       ACTIVEQUERYOPTION;
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
    public void setVocabularyElementPairs(List<DecorableVocabularyElementPair> pairs);
    
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
    public List<DecorableVocabularyElementPair> getActivePairs();
    
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
    public void setRandomActiveQueryPair();
    
    /**
     * 
     * @return 
     */
    public DecorableVocabularyElementPair getActiveQueryPair();
    
    /**
     * 
     * @param o 
     */
    public void addObserver(Observer o);
    
    /**
     * 
     * @param nofPairs 
     */
    public void setRandomActivePairs(int nofPairs);
}
