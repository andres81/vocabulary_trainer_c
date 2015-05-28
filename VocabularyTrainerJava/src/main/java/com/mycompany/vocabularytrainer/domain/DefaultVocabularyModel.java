package com.mycompany.vocabularytrainer.domain;


import com.mycompany.vocabularytrainer.domain.interfaces.DecorableRepresentative;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
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
    private Map<UUID,DefaultVocabularyElementPair> pairs = null;
    
    /**
     * 
     */
    private List<DecorableRepresentative> activeOptions = null;
    
    /**
     * 
     */
    private List<DefaultVocabularyElementPair> activePairs = null;
            
    /**
     * 
     */
    private DecorableRepresentative activeQuery = null;

    /**
     * 
     */
    private DefaultVocabularyElementPair activeQueryPair = null;
            
    /**
     * 
     */
    private DecorableRepresentative activeQueryOption = null;
    
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
    public void setVocabularyElementPairs(List<DefaultVocabularyElementPair> pairs) {
        if (pairs == null) {
            throw new NullPointerException();
        }

        if (this.pairs == null) {
            this.pairs = new HashMap<>();
        }
        for (DefaultVocabularyElementPair pair : pairs) {
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
    public List<DecorableRepresentative> getActiveOptions() {
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
    public DecorableRepresentative getActiveQuery() {
        if (activeQuery == null) {
            activeQuery = new DefaultDecorableRepresentative();
        }
        return activeQuery;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public DecorableRepresentative getActiveQueryOption() {
        return activeQueryOption;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public List<DefaultVocabularyElementPair> getActivePairs() {
        if (activePairs == null) {
            activePairs = new ArrayList<>();
        }
        return new ArrayList<>(activePairs);
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
            DefaultVocabularyElementPair pair = this.pairs.get(uuid);
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
     * Set a new random active query pair.
     */
    @Override
    public void setActiveQueryPair() {
        List<DefaultVocabularyElementPair> temp = new ArrayList<>(activePairs);
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
     * @return 
     */
    @Override
    public DefaultVocabularyElementPair getActiveQueryPair() {
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
    
    /**
     * 
     * @param uuid 
     */
    private void setActiveQueryPair(UUID uuid, boolean updateObservers) {
        DefaultVocabularyElementPair pair = pairs.get(uuid);
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
     */
    private void setActiveOptions() {
        if (activeOptions == null) {
            activeOptions = new ArrayList<>();
        }
        for (DefaultVocabularyElementPair pair : activePairs) {
            if (direction == Direction.COLUMNONETOONE ||
                direction == Direction.COLUMNTWOTOONE) {
                activeOptions.add(pair.getFirst());
            } else {
                activeOptions.add(pair.getSecond());
            }
        }
    }
}
