package com.mycompany.vocabularytrainer.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class VocabularyExerciseModel extends Observable {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyExerciseModel.class);
    
    /**
     * 
     */
    private Map<UUID,VocabularyEntryPair> pairs = null;
    
    /**
     * 
     */
    private List<Representative> activeOptions = null;
    
    /**
     * 
     */
    private Representative activeQuery = null;
    
    /**
     * 
     */
    private Representative activeOption = null;
    
    /**
     * 
     */
    public enum Direction {
        ONETOONE,
        ONETOTWO,
        TWOTOONE,
        TWOTOTWO;
    };
    
    /**
     * 
     */
    private Direction direction = null;
    
    /**
     * 
     */
    public VocabularyExerciseModel() {
        direction = Direction.ONETOTWO;
    }
    
    /**
     * 
     * @return 
     */
    public Direction getDirection() {
        return direction;
    }
    
    /**
     * s
     * @param direction 
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    /**
     * 
     * @param pairs
     */
    public void setVocabularyEntryPairs(List<VocabularyEntryPair> pairs) {
        if (this.pairs == null) {
            this.pairs = new HashMap<>();
        }
        for (VocabularyEntryPair pair : pairs) {
            this.pairs.put(pair.getUuid(), pair);
        }
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @return 
     */
    public List<Representative> getActiveOptions() {
        return activeOptions;
    }
    
    /**
     * 
     * @return 
     */
    public Representative getActiveQuery() {
        return activeQuery;
    }
    
    /**
     * 
     * @return 
     */
    public Representative getActiveOption() {
        return activeOption;
    }
    
    /**
     * 
     * @param pairs 
     */
    public void setActivePairs(List<UUID> pairs) {
        if (activeOptions == null) {
            activeOptions = new ArrayList<>();
        }
        boolean activeQuerySet = false;
        for (UUID uuid : pairs) {
            VocabularyEntryPair pair = this.pairs.get(uuid);
            if (pair != null) {
                if (direction == Direction.ONETOONE ||
                    direction == Direction.TWOTOONE) {
                    activeOptions.add(pair.getFirst());
                } else {
                    activeOptions.add(pair.getSecond());
                }
                if (!activeQuerySet) {
                    if (direction == Direction.ONETOONE ||
                        direction == Direction.ONETOTWO) {
                        activeQuery = pair.getFirst();
                        activeOption = pair.getSecond();
                    } else {
                        activeQuery = pair.getSecond();
                        activeOption = pair.getFirst();
                    }
                    activeQuerySet = true;
                }
            }
        }
    }
}
