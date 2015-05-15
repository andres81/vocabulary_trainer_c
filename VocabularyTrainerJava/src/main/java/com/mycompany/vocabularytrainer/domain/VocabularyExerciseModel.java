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
    private List<VocabularyEntryPair> activePairs = null;
            
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
    private VocabularyEntryPair activeQueryPair = null;
            
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
     * s
     * @param direction 
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
        setActiveOptions();
        if (activeOptions != null &&
            activeOptions.size() > 0) {
            setActiveQueryPair(activeOptions.get(0).getUuid());
        }
        setChanged();
        notifyObservers();
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
     * @return 
     */
    public List<VocabularyEntryPair> getActivePairs() {
        return new ArrayList<>(activePairs);
    }

    /**
     * 
     * @param pairs 
     */
    public void setActivePairs(List<UUID> pairs) {
        if (pairs == null ||
            pairs.size() < 1) {
            return;
        }
        if (activePairs == null) {
            activePairs = new ArrayList<>();
        }
        boolean isActiveQueryPairSet = false;
        for (UUID uuid : pairs) {
            VocabularyEntryPair pair = this.pairs.get(uuid);
            activePairs.add(pair);
            if (!isActiveQueryPairSet) {
                setActiveQueryPair(uuid,false);
                isActiveQueryPairSet = true;
            }
        }
        setActiveOptions();
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     */
    private void setActiveOptions() {
        if (activeOptions == null) {
            activeOptions = new ArrayList<>();
        }
        for (VocabularyEntryPair pair : activePairs) {
            if (direction == Direction.ONETOONE ||
                direction == Direction.TWOTOONE) {
                activeOptions.add(pair.getFirst());
            } else {
                activeOptions.add(pair.getSecond());
            }
        }
    }
    
    /**
     * 
     * @param uuid 
     */
    public void setActiveQueryPair(UUID uuid) {
        setActiveQueryPair(uuid, true);
    }
    
    /**
     * 
     * @param uuid 
     */
    private void setActiveQueryPair(UUID uuid, boolean updateObservers) {
        VocabularyEntryPair pair = pairs.get(uuid);
        if (pair == null) return; // No pair found with given uuid!
        activeQueryPair = pair;
        if (direction == Direction.ONETOONE ||
            direction == Direction.ONETOTWO) {
            activeQuery = pair.getFirst();
            activeOption = pair.getSecond();
        } else {
            activeQuery = pair.getSecond();
            activeOption = pair.getFirst();
        }
        if (updateObservers) {
            setChanged();
            notifyObservers();
        }
    }
    
    /**
     * 
     * @return 
     */
    public VocabularyEntryPair getActiveQueryPair() {
        return activeQueryPair;
    }
}
