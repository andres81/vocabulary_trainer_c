/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.gui.RepresentativesViewCallback;
import com.mycompany.vocabularytrainer.gui.VocabularyExerciseView;
import com.mycompany.vocabularytrainer.gui.VocabularyPresenterListCellRenderer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
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
        VocabularyExerciseView guiOptions = new VocabularyExerciseView();
//        frame.add(guiOptions);
        
        VocabularyExerciseModel model = new VocabularyExerciseModel();
        model.setVocabularyEntryPairs(getRepresentatives());
        model.setActivePairs(getActiveUuids());
        guiOptions.setModel(model);
        guiOptions.setController(new VocabularyExerciseControllerDefault());
        
        
        
        DefaultListModel<Representative> listModel = new DefaultListModel<>();
        JList<Representative> list = new JList<>(listModel);
        list.setCellRenderer(new VocabularyPresenterListCellRenderer());
        listModel.addElement(new DefaultRepresentative(new UUID(111,222), "one", null));
        listModel.addElement(new DefaultRepresentative(new UUID(211,222), "two", null));
        listModel.addElement(new DefaultRepresentative(new UUID(311,222), "three", null));
        
        frame.add(new JScrollPane(list));
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
    public static List<VocabularyEntryPair> getRepresentatives() {
        List<VocabularyEntryPair> pairs = new ArrayList<>();
        
        VocabularyEntryPair pair = new VocabularyEntryPair(new UUID(1,2),
            new DefaultRepresentative(new UUID(111,222), "one", null),
            new DefaultRepresentative(new UUID(333,444), "un", null));
        pairs.add(pair);
        pair = new VocabularyEntryPair(new UUID(3,4),
            new DefaultRepresentative(new UUID(11,22), "two", null),
            new DefaultRepresentative(new UUID(33,44), "deux", null));
        pairs.add(pair);
        pair = new VocabularyEntryPair(new UUID(5,6),
            new DefaultRepresentative(new UUID(1,5), "three", null),
            new DefaultRepresentative(new UUID(2,6), "trois", null));
        pairs.add(pair);
        return pairs;
    }
    
    @Override
    public void representativeClicked(UUID uuid) {
        logger.info("uuid received: " + uuid.toString());
        
    }
    
}
