/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
