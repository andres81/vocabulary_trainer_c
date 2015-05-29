/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyElementPair;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
import com.mycompany.vocabularytrainer.gui.RepresentativesViewCallback;
import com.mycompany.vocabularytrainer.gui.VocabularyExercise;
import com.mycompany.vocabularytrainer.gui.VocabularyPresenter;
import com.mycompany.vocabularytrainer.gui.VocabularyPresenterListCellRenderer;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class Main implements RepresentativesViewCallback {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        VocabularyExercise guiOptions = new VocabularyExercise();
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.add(guiOptions,BorderLayout.CENTER);
        
        VocabularyModel model = guiOptions.getModel();
        model.setVocabularyElementPairs(getRepresentatives());
        model.setActivePairs(getActiveUuids());
        
        DefaultListModel<VocabularyElementPair> listModel = new DefaultListModel<>();
        VocabularyPresenter<DefaultVocabularyElementPair> vocPresenter = new VocabularyPresenter<>(listModel);
        vocPresenter.setCellRenderer(new VocabularyPresenterListCellRenderer());
        for (VocabularyElementPair pair : getRepresentatives()) {
            listModel.addElement(pair);
        }
//        listModel.addElement(new DefaultRepresentative(new UUID(111,222), "one", null));
//        listModel.addElement(new DefaultRepresentative(new UUID(211,222), "two", null));
//        listModel.addElement(new DefaultRepresentative(new UUID(311,222), "three", null));
        
        contentPane.add(new JScrollPane(vocPresenter),BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 
     * @return 
     */
    public static List<UUID> getActiveUuids() {
        List<UUID> activeUuids = new ArrayList<>();
        activeUuids.add(new UUID(1,2));
        activeUuids.add(new UUID(3,4));
        activeUuids.add(new UUID(5,6));
        
        return activeUuids;
    }
    
    /**
     * 
     * @return 
     */
    public static List<VocabularyElementPair> getRepresentatives() {
        List<VocabularyElementPair> pairs = new ArrayList<>();
        
        DefaultVocabularyElementPair pair = new DefaultVocabularyElementPair(new UUID(1,2),
            new DefaultDecorableRepresentative(new UUID(111,222), "one", null),
            new DefaultDecorableRepresentative(new UUID(333,444), "un", null));
        pairs.add(pair);
        pair = new DefaultVocabularyElementPair(new UUID(3,4),
            new DefaultDecorableRepresentative(new UUID(11,22), "two", null),
            new DefaultDecorableRepresentative(new UUID(33,44), "deux", null));
        pairs.add(pair);
        pair = new DefaultVocabularyElementPair(new UUID(5,6),
            new DefaultDecorableRepresentative(new UUID(1,5), "three", null),
            new DefaultDecorableRepresentative(new UUID(2,6), "trois", null));
        pairs.add(pair);
        return pairs;
    }
    
    @Override
    public void representativeClicked(UUID uuid) {
        logger.info("uuid received: " + uuid.toString());
        
    }
    
}
