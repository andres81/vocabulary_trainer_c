/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.VocabularyExerciseController;
import com.mycompany.vocabularytrainer.domain.VocabularyExerciseModel;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class VocabularyExerciseView extends JPanel implements Observer, RepresentativesViewCallback {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyExerciseView.class);
    
    /**
     * 
     */
    private VocabularyExerciseModel model = null;
    
    /**
     * 
     */
    private VocabularyExerciseController controller = null;
    
    /**
     * 
     */
    private RepresentativesView representativesView = null;
    
    /**
     * 
     */
    private JLabel queryView = null;
            
    /**
     * 
     */
    public VocabularyExerciseView() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        queryView = new JLabel();
        queryView.setAlignmentX(CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(50, 50)));
        add(queryView);
        add(Box.createRigidArea(new Dimension(50, 50)));
        representativesView = new RepresentativesView(this);
        representativesView.setAlignmentX(CENTER_ALIGNMENT);
        add(representativesView);
    }
    
    /**
     * 
     * @param model
     */
    public void setModel(VocabularyExerciseModel model) {
        if (model == null) {
            return;
        }
        this.model = model;
        if (controller != null) {
            controller.setModel(model);
        }
        updateVocabularyEntryPairs();
    }
    
    /**
     * 
     * @param controller 
     */
    public void setController(VocabularyExerciseController controller) {
        this.controller = controller;
        this.controller.setModel(this.model);
    }
    
    /**
     * 
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o == this.model) {
            updateVocabularyEntryPairs();
        }
    }
    
    /**
     * 
     */
    private void updateVocabularyEntryPairs() {
        if (model == null) {
            return;
        }
        representativesView.setRepresentatives(model.getActiveOptions());
        queryView.setText(model.getActiveQuery().getTitle());
    }
            
    /**
     * 
     * @param uuid 
     */
    @Override
    public void representativeClicked(UUID uuid) {
        if (controller != null) {
            controller.doGuess(uuid);
        }
    }
}
