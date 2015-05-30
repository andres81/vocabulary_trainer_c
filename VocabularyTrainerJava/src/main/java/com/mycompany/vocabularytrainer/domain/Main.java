/**
 * VocabularyTrainer  Copyright (C) 2015  André Schepers
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycompany.vocabularytrainer.domain;

import com.mycompany.vocabularytrainer.domain.interfaces.DecorableVocabularyElementPair;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
import com.mycompany.vocabularytrainer.gui.RepresentativesViewCallback;
import com.mycompany.vocabularytrainer.gui.VocabularyExercise;
import com.mycompany.vocabularytrainer.gui.VocabularyPresenter;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
        
        contentPane.add(new JScrollPane(new VocabularyPresenter(model)),BorderLayout.EAST);
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
