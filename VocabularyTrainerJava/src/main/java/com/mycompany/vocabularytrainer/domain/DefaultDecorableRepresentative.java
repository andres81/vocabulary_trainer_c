/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author andres81
 */
public class DefaultDecorableRepresentative extends DefaultRepresentative implements DecorableRepresentative {

    private Map<Object,Object> decorators = null;
    
    @Override
    public int size() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.size();
    }

    @Override
    public boolean isEmpty() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.remove(key);
    }

    @Override
    public void putAll(Map<? extends Object, ? extends Object> m) {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        decorators.putAll(m);
    }

    @Override
    public void clear() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        decorators.clear();
    }

    @Override
    public Set<Object> keySet() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.keySet();
    }

    @Override
    public Collection<Object> values() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.values();
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        if (decorators == null) {
            decorators = new HashMap<>();
        }
        return decorators.entrySet();
    }
}
