/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.util.UUID;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author andres81
 */
public class VocabularyExerciseControllerDefault implements VocabularyExerciseController {

    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyExerciseControllerDefault.class);
    
    /**
     * 
     */
    private VocabularyExerciseModel model = null;
    
    /**
     * 
     * @param uuid 
     */
    @Override
    public void doGuess(UUID uuid) {
        if (model == null) {
            
        }
    }

    /**
     * 
     * @param model 
     */
    @Override
    public void setModel(VocabularyExerciseModel model) {
        this.model = model;
    }
}
