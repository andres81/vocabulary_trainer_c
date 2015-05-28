/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.DefaultVocabularyController;
import com.mycompany.vocabularytrainer.domain.DefaultVocabularyModel;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyController;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
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
public class VocabularyExercise extends JPanel implements Observer, RepresentativesViewCallback {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyExercise.class);
    
    /**
     * 
     */
    private VocabularyModel model = null;
    
    /**
     * 
     */
    private VocabularyController controller = null;
    
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
    public VocabularyExercise() {
        super();
        init();
        setModel(new DefaultVocabularyModel());
        setController(new DefaultVocabularyController(model));
    }
    
    /**
     * 
     */
    private void init() {
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
    public void setModel(VocabularyModel model) {
        if (model == null) {
            throw new NullPointerException("Can't set a null value for the model.");
        }
        this.model = model;
        if (controller != null) {
            controller.setModel(model);
        }
        model.addObserver(this);
        updateVocabularyEntryPairs();
    }
    
    /**
     * 
     * @param controller 
     */
    public void setController(VocabularyController controller) {
        this.controller = controller;
        this.controller.setModel(model);
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
            throw new NullPointerException();
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
    
    /**
     * 
     * @return 
     */
    public VocabularyModel getModel() {
        return model;
    }
}
