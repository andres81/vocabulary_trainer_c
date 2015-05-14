/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.gui.RepresentativesView;
import com.mycompany.vocabularytrainer.gui.RepresentativesViewCallback;
import com.mycompany.vocabularytrainer.gui.VocabularyExerciseView;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JFrame;
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
        
        logger.info("Testing this logging");
        
        JFrame frame = new JFrame();
        VocabularyExerciseView guiOptions = new VocabularyExerciseView();
        
//        RepresentativesView optionsView = new RepresentativesView();
//        optionsView.setRepresentatives(null);
//        optionsView.setRepresentativesCallback(new Main());
        
        frame.add(guiOptions);
        
//        List<Representative> reps = new ArrayList<>();
//        reps.add(new DefaultRepresentative(new UUID(1,2), "button one", null));
//        reps.add(new DefaultRepresentative(new UUID(3,4), "button two", null));
//        reps.add(new DefaultRepresentative(new UUID(5,6), "button three", null));
//        
        VocabularyExerciseModel model = new VocabularyExerciseModel();
        List<VocabularyEntryPair> pairs = new ArrayList<>();
        
        VocabularyEntryPair pair = new VocabularyEntryPair(new UUID(1,2));
        pair.setFirst(new DefaultRepresentative(new UUID(111,222), "button one", null));
        pair.setSecond(new DefaultRepresentative(new UUID(333,444), "button un", null));
        pairs.add(pair);
        pair = new VocabularyEntryPair(new UUID(3,4));
        pair.setFirst(new DefaultRepresentative(new UUID(11,22), "button two", null));
        pair.setSecond(new DefaultRepresentative(new UUID(33,44), "button deux", null));
        pairs.add(pair);
        pair = new VocabularyEntryPair(new UUID(5,6));
        pair.setFirst(new DefaultRepresentative(new UUID(1111,2222), "button three", null));
        pair.setSecond(new DefaultRepresentative(new UUID(3333,4444), "button trois", null));
        pairs.add(pair);
        model.setVocabularyEntryPairs(pairs);
        List<UUID> activeUuids = new ArrayList<>();
        activeUuids.add(new UUID(1,2));
        activeUuids.add(new UUID(3,4));
        activeUuids.add(new UUID(5,6));
        model.setActivePairs(activeUuids);
        guiOptions.setModel(model);
        

        
        
//        VocabularyEntryPair entry1 = new VocabularyEntryPair(new UUID(100, 200), "button1");
//        VocabularyEntryPair entry2 = new VocabularyEntryPair(new UUID(200, 100), "button2");
//        List<VocabularyEntryPair> options = new ArrayList<>();
//        options.add(entry1);
//        options.add(entry2);
//        guiOptions.setOptions(options);
//        
//        frame.add(guiOptions);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        
//        guiOptions.setOptions(options);
    }

    @Override
    public void representativeClicked(UUID uuid) {
        logger.info("uuid received: " + uuid.toString());
        
    }
    
}
