/**
 * VocabularyTrainer  Copyright (C) 2015  André Schepers
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
    public List<DecorableVocabularyElementPair> getVocabularyElementPairs();
    
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
