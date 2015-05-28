package com.mycompany.vocabularytrainer.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class DefaultVocabularyModel extends Observable implements VocabularyModel {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(DefaultVocabularyModel.class);
    
    /**
     * 
     */
    private Map<UUID,VocabularyElementPair> pairs = null;
    
    /**
     * 
     */
    private List<Representative> activeOptions = null;
    
    /**
     * 
     */
    private List<VocabularyElementPair> activePairs = null;
            
    /**
     * 
     */
    private Representative activeQuery = null;

    /**
     * 
     */
    private VocabularyElementPair activeQueryPair = null;
            
    /**
     * 
     */
    private Representative activeQueryOption = null;
    
    /**
     * 
     */
    private Direction direction = null;
    
    /**
     * 
     */
    public DefaultVocabularyModel() {
        direction = Direction.COLUMNONETOTWO;
    }
    
    /**
     * s
     * @param direction 
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
        setActiveOptions();
        if (activeOptions != null &&
            activeOptions.size() > 0) {
            setActiveQueryPair(activeOptions.get(0).getUuid(),false);
        }
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @param pairs
     */
    @Override
    public void setVocabularyElementPairs(List<VocabularyElementPair> pairs) {
        if (pairs == null) {
            throw new NullPointerException();
        }

        if (this.pairs == null) {
            this.pairs = new HashMap<>();
        }
        for (VocabularyElementPair pair : pairs) {
            this.pairs.put(pair.getUuid(), pair);
        }
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<Representative> getActiveOptions() {
        if (activeOptions == null) {
            activeOptions = new ArrayList<>();
        }
        return activeOptions;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Representative getActiveQuery() {
        if (activeQuery == null) {
            activeQuery = new DefaultRepresentative();
        }
        return activeQuery;
    }
    
    /**
     * 
     * @return 
     */
    public Representative getActiveOption() {
        return activeQueryOption;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<VocabularyElementPair> getActivePairs() {
        if (activePairs == null) {
            activePairs = new ArrayList<>();
        }
        return new ArrayList<>(activePairs);
    }

    /**
     * 
     * @return 
     */
    public List<Integer> getActivePairIndexes() {
       
        List<Integer> indexes = new ArrayList<>();
        for (VocabularyElementPair pair : activePairs) {
            
        }
        
        return indexes;
    }
    
    /**
     * 
     * @param activePairUuids 
     */
    @Override
    public void setActivePairs(List<UUID> activePairUuids) {
        if (activePairUuids == null) {
            throw new NullPointerException();
        }
        if (this.activePairs == null) {
            this.activePairs = new ArrayList<>();
        }
        activePairs.clear();
        for (UUID uuid : activePairUuids) {
            VocabularyElementPair pair = this.pairs.get(uuid);
            if (pair != null) {
                activePairs.add(pair);
            }
        }
        if (!activePairs.isEmpty()) {
            setActiveQueryPair(activePairs.get(0).getUuid(),false);
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
        for (VocabularyElementPair pair : activePairs) {
            if (direction == Direction.COLUMNONETOONE ||
                direction == Direction.COLUMNTWOTOONE) {
                activeOptions.add(pair.getFirst());
            } else {
                activeOptions.add(pair.getSecond());
            }
        }
    }
    
    /**
     * Set a new random active query pair.
     */
    @Override
    public void setActiveQueryPair() {
        List<VocabularyElementPair> temp = new ArrayList<>(activePairs);
        temp.remove(activeQueryPair);
        Random r = new Random();
        int newIndex = r.nextInt(temp.size());
        setActiveQueryPair(temp.get(newIndex).getUuid(),true);
    }
    
    /**
     * 
     * @param uuid 
     */
    @Override
    public void setActiveQueryPair(UUID uuid) {
        setActiveQueryPair(uuid, true);
    }
    
    /**
     * 
     * @param uuid 
     */
    private void setActiveQueryPair(UUID uuid, boolean updateObservers) {
        VocabularyElementPair pair = pairs.get(uuid);
        if (pair == null ||
            !activePairs.contains(pair)) return; // No pair found with given uuid!
        activeQueryPair = pair;
        switch(direction) {
            case COLUMNONETOONE:
                activeQuery = pair.getFirst();
                activeQueryOption = pair.getFirst();
                break;
            case COLUMNONETOTWO:
                activeQuery = pair.getFirst();
                activeQueryOption = pair.getSecond();
                break;
            case COLUMNTWOTOONE:
                activeQuery = pair.getSecond();
                activeQueryOption = pair.getFirst();
                break;
            case COLUMNTWOTOTWO:
                activeQuery = pair.getSecond();
                activeQueryOption = pair.getSecond();
                break;
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
    @Override
    public VocabularyElementPair getActiveQueryPair() {
        return activeQueryPair;
    }
    
    /**
     * 
     * @param uuid
     * @return 
     */
    @Override
    public boolean isQueryOption(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException();
        }
        return uuid == activeQueryOption.getUuid();
    }
    
    @Override
    public void addObserver(Observer o) {
       super.addObserver(o);
    }
}
