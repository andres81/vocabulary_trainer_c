/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.DecorableRepresentative;
import com.mycompany.vocabularytrainer.domain.interfaces.DecorableVocabularyElementPair;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class DefaultDecorableVocabularyElementPair implements DecorableVocabularyElementPair {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(DefaultDecorableVocabularyElementPair.class);
    
    /**
     * 
     */
    private final DecorableRepresentative entryOne;
    
    /**
     * 
     */
    private final DecorableRepresentative entryTwo;
    
    /**
     * 
     */
    private final UUID uuid;
    
    /**
     * 
     */
    private Map<Object,Object> decorators = null;
    
    /**
     * 
     * @param uuid
     * @param first
     * @param second
     */
    public DefaultDecorableVocabularyElementPair(UUID uuid, DecorableRepresentative first, DecorableRepresentative second) {
        if (uuid == null ||
            first == null ||
            second == null) {
            throw new NullPointerException();
        }
        this.uuid = uuid;
        entryOne = first;
        entryTwo = second;
        decorators = new HashMap<>();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public DecorableRepresentative getFirst() {
        return entryOne;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public DecorableRepresentative getSecond() {
        return entryTwo;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public UUID getUuid() {
        return uuid;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DefaultDecorableVocabularyElementPair) {
            DefaultDecorableVocabularyElementPair pair = (DefaultDecorableVocabularyElementPair) obj;
            return uuid == pair.getUuid();
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

    @Override
    public int size() {
        return decorators.size();
    }

    @Override
    public boolean isEmpty() {
        return decorators.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return decorators.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return decorators.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return decorators.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return decorators.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return decorators.remove(key);
    }

    @Override
    public void putAll(Map<? extends Object, ? extends Object> m) {
        decorators.putAll(m);
    }

    @Override
    public void clear() {
        decorators.clear();
    }

    @Override
    public Set<Object> keySet() {
        return decorators.keySet();
    }

    @Override
    public Collection<Object> values() {
        return decorators.values();
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        return decorators.entrySet();
    }
}
