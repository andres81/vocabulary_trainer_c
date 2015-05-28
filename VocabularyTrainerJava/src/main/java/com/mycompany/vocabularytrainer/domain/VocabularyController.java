/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.UUID;

/**
 *
 * @author andres81
 */
public interface VocabularyController {

    /**
     * 
     * @param uuid 
     */
    public void doGuess(UUID uuid);
    
    /**
     * 
     * @param model 
     */
    public void setModel(VocabularyModel model);
}
