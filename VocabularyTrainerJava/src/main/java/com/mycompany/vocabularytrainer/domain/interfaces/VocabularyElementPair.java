/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain.interfaces;

import java.util.UUID;

/**
 *
 * @author andres81
 */
public interface VocabularyElementPair {

    /**
     * 
     * @return 
     */
    public DecorableRepresentative getFirst();
    
    /**
     * 
     * @return 
     */
    public DecorableRepresentative getSecond();
    
    /**
     * 
     * @return 
     */
    public UUID getUuid();
}
