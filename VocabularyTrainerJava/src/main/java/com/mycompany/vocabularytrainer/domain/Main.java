/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.DecorableVocabularyElementPair;
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
        
        List<DecorableVocabularyElementPair> pairs = getRepresentatives();
        VocabularyModel model = guiOptions.getModel();
        model.setVocabularyElementPairs(pairs);
        model.setActivePairs(getActiveUuids());
        
        DefaultListModel<DecorableVocabularyElementPair> listModel = new DefaultListModel<>();
        VocabularyPresenter<DecorableVocabularyElementPair> vocPresenter = new VocabularyPresenter<>(listModel);
        vocPresenter.setCellRenderer(new VocabularyPresenterListCellRenderer());
        for (DecorableVocabularyElementPair pair : pairs) {
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
        activeUuids.add(new UUID(0,0));
        activeUuids.add(new UUID(1,1));
        activeUuids.add(new UUID(7,7));
        
        return activeUuids;
    }
    
    /**
     * 
     * @return 
     */
    public static List<DecorableVocabularyElementPair> getRepresentatives() {
        List<DecorableVocabularyElementPair> pairs = new ArrayList<>();
        
        DefaultDecorableVocabularyElementPair pair = new DefaultDecorableVocabularyElementPair(new UUID(0,0),
            new DefaultDecorableRepresentative(new UUID(1,11), "one", null),
            new DefaultDecorableRepresentative(new UUID(2,22), "un", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(1,1),
            new DefaultDecorableRepresentative(new UUID(1,33), "two", null),
            new DefaultDecorableRepresentative(new UUID(2,44), "deux", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(2,2),
            new DefaultDecorableRepresentative(new UUID(1,55), "three", null),
            new DefaultDecorableRepresentative(new UUID(2,66), "trois", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(3,3),
            new DefaultDecorableRepresentative(new UUID(1,77), "four", null),
            new DefaultDecorableRepresentative(new UUID(2,88), "vier", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(4,4),
            new DefaultDecorableRepresentative(new UUID(1,99), "five", null),
            new DefaultDecorableRepresentative(new UUID(2,99), "vijf", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(5,5),
            new DefaultDecorableRepresentative(new UUID(1,111), "six", null),
            new DefaultDecorableRepresentative(new UUID(2,222), "zes", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(6,6),
            new DefaultDecorableRepresentative(new UUID(1,333), "seven", null),
            new DefaultDecorableRepresentative(new UUID(2,444), "zeven", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(7,7),
            new DefaultDecorableRepresentative(new UUID(1,555), "acht", null),
            new DefaultDecorableRepresentative(new UUID(2,666), "eight", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(8,8),
            new DefaultDecorableRepresentative(new UUID(1,777), "nine", null),
            new DefaultDecorableRepresentative(new UUID(2,888), "negen", null));
        pairs.add(pair);
        pair = new DefaultDecorableVocabularyElementPair(new UUID(9,9),
            new DefaultDecorableRepresentative(new UUID(1,999), "ten", null),
            new DefaultDecorableRepresentative(new UUID(2,1111), "tien", null));
        pairs.add(pair);
        return pairs;
    }
    
    @Override
    public void representativeClicked(UUID uuid) {
        logger.info("uuid received: " + uuid.toString());
        
    }
    
}
