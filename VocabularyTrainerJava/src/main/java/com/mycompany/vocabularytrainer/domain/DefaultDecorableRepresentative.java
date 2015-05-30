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
import java.awt.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author andres81
 */
public class DefaultDecorableRepresentative extends DefaultRepresentative implements DecorableRepresentative {

    /**
     * 
     */
    private Map<Object,Object> decorators = null;

    /**
     * 
     */
    public DefaultDecorableRepresentative() {
        super();
    }
            
    /**
     * 
     * @param uuid
     * @param title
     * @param image 
     */
    public DefaultDecorableRepresentative(UUID uuid, String title, Image image) {
        super(uuid, title, image);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int size() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.size();
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.isEmpty();
    }

    /**
     * 
     * @param key
     * @return 
     */
    @Override
    public boolean containsKey(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.containsKey(key);
    }

    /**
     * 
     * @param value
     * @return 
     */
    @Override
    public boolean containsValue(Object value) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.containsValue(value);
    }

    /**
     * 
     * @param key
     * @return 
     */
    @Override
    public Object get(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.get(key);
    }

    /**
     * 
     * @param key
     * @param value
     * @return 
     */
    @Override
    public Object put(Object key, Object value) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.put(key, value);
    }

    /**
     * 
     * @param key
     * @return 
     */
    @Override
    public Object remove(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.remove(key);
    }

    /**
     * 
     * @param m 
     */
    @Override
    public void putAll(Map<? extends Object, ? extends Object> m) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        decorators.putAll(m);
    }
    
    /**
     * 
     */
    @Override
    public void clear() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        decorators.clear();
    }

    /**
     * 
     * @return 
     */
    @Override
    public Set<Object> keySet() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.keySet();
    }

    /**
     * 
     * @return 
     */
    @Override
    public Collection<Object> values() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.values();
    }

    /**
     * 
     * @return 
     */
    @Override
    public Set<Entry<Object, Object>> entrySet() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.entrySet();
    }
}
