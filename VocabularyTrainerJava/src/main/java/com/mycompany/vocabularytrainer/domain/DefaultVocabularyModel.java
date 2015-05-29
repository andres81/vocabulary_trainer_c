package com.mycompany.vocabularytrainer.domain;


import com.mycompany.vocabularytrainer.domain.interfaces.DecorableRepresentative;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyElementPair;
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
    private Map<UUID,VocabularyElementPair> pairs = null;
    
    /**
     * 
     */
    private List<DecorableRepresentative> activeOptions = null;
    
    /**
     * 
     */
    private List<VocabularyElementPair> activePairs = null;
            
    /**
     * 
     */
    private DecorableRepresentative activeQuery = null;

    /**
     * 
     */
    private VocabularyElementPair activeQueryPair = null;
            
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
        if (direction == null) {
            throw new NullPointerException();
        }
        this.direction = direction;
        updateActiveOptions();
        updateQueryAndQueryOption();
        setChanged();
        notifyObservers(UpdateType.DIRECTION);
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
        setRandomActivePairsNoUpdate(5); // @TODO Change this to a configuration parameter
        setChanged();
        notifyObservers(UpdateType.PAIRS);
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
        return new ArrayList<>(activeOptions);
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
        if (activeQueryOption == null) {
            activeQueryOption = new DefaultDecorableRepresentative();
        }
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
        updateActiveOptions();
        setRandomActiveQueryPairNoUpdate();
        setChanged();
        notifyObservers(UpdateType.ACTIVEPAIRS);
    }
    
    /**
     * Set a new random active query pair.
     */
    @Override
    public void setRandomActiveQueryPair() {
        setRandomActiveQueryPairNoUpdate();
        setChanged();
        notifyObservers(UpdateType.ACTIVEPAIR);
    }
    
    /**
     * 
     * @param uuid 
     */
    @Override
    public void setActiveQueryPair(UUID uuid) {
        setActiveQueryPairNoUpdate(uuid);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public VocabularyElementPair getActiveQueryPair() {
        if (activeQueryPair == null) {
            activeQueryPair = new DefaultVocabularyElementPair(UUID.randomUUID(), new DefaultDecorableRepresentative(), new DefaultDecorableRepresentative());
        }
        return activeQueryPair;
    }
    
    /**
     * 
     * @param o 
     */
    @Override
    public void addObserver(Observer o) {
       super.addObserver(o);
    }

    /**
     * 
     * @param nofPairs 
     */
    @Override
    public void setRandomActivePairs(int nofPairs) {
        setRandomActivePairsNoUpdate(nofPairs);
        setChanged();
        notifyObservers(UpdateType.ACTIVEPAIRS);
    }
    
    /**
     * 
     * @param nofPairs 
     */
    private void setRandomActivePairsNoUpdate(int nofPairs) {
        if (this.pairs == null) {
            return;
        }
        if (this.activePairs == null) {
            activePairs = new ArrayList<>();
        }
        this.activePairs.clear();
        List<VocabularyElementPair> temp = new ArrayList<>(this.activePairs);
        for (int i = 0;i<nofPairs;++i) {
            if (temp.isEmpty()) break;
            Random r = new Random();
            int newIndex = r.nextInt(temp.size());
            VocabularyElementPair pair = temp.get(newIndex);
            this.activePairs.add(pair);
            temp.remove(pair);
        }
        updateActiveOptions();
        setRandomActiveQueryPair();
    }
    
    /**
     * 
     * @param uuid 
     */
    private void setActiveQueryPairNoUpdate(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException();
        }
        VocabularyElementPair pair = pairs.get(uuid);
        if (pair == null ||
            !activePairs.contains(pair)) return; // No pair found with given uuid!
        activeQueryPair = pair;
        updateQueryAndQueryOption();
    }
    
    /**
     * 
     */
    private void updateQueryAndQueryOption() {
        DecorableRepresentative first = activeQueryPair.getFirst();
        DecorableRepresentative second = activeQueryPair.getSecond();
        switch(direction) {
            case COLUMNONETOONE:
                activeQuery = first;
                activeQueryOption = first;
                break;
            case COLUMNONETOTWO:
                activeQuery = first;
                activeQueryOption = second;
                break;
            case COLUMNTWOTOONE:
                activeQuery = second;
                activeQueryOption = first;
                break;
            case COLUMNTWOTOTWO:
                activeQuery = second;
                activeQueryOption = second;
                break;
        }
    }
    
    /**
     * 
     */
    private void updateActiveOptions() {
        if (activeOptions == null) {
            activeOptions = new ArrayList<>();
        }
        activeOptions.clear();
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
    private void setRandomActiveQueryPairNoUpdate() {
        if (activePairs == null ||
            activePairs.isEmpty()) {
            activeQueryPair = null;
            activeQuery = null;
            activeQueryOption = null;
            return;
        }
        List<VocabularyElementPair> temp = new ArrayList<>(activePairs);
        if (activeQueryPair != null) {
            temp.remove(activeQueryPair);
        }
        Random r = new Random();
        int newIndex = r.nextInt(temp.size());
        setActiveQueryPairNoUpdate(temp.get(newIndex).getUuid());
    }
}
