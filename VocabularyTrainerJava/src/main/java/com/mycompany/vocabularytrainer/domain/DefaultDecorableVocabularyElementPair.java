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
