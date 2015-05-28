/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyController;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
import java.util.UUID;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author andres81
 */
public class DefaultVocabularyController implements VocabularyController {

    // Logging
    private static final Logger logger = LogManager.getLogger(DefaultVocabularyController.class);
    
    /**
     * 
     */
    private VocabularyModel model = null;
    
    /**
     * 
     * @param model
     */
    public DefaultVocabularyController(VocabularyModel model) {
        if (model == null) {
            throw new NullPointerException();
        }
        this.model = model;
    }
    
    /**
     * 
     * @param uuid 
     */
    @Override
    public void doGuess(UUID uuid) {
        if (model != null) {
            if (model.isQueryOption(uuid)) {
                model.setActiveQueryPair();
            }
        }
    }

    /**
     * 
     * @param model 
     */
    @Override
    public void setModel(VocabularyModel model) {
        this.model = model;
    }
}
