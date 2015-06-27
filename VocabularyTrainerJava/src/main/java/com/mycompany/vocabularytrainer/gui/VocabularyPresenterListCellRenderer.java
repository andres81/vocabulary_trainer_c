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
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.interfaces.DecorableVocabularyElementPair;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class VocabularyPresenterListCellRenderer
        extends JPanel
        implements ListCellRenderer<DecorableVocabularyElementPair> {

    private JLabel labelone;
    private JLabel labeltwo;
    private JLabel labelthree;
    
    // Logging
    private static final Logger logger = LogManager.getLogger(VocabularyPresenterListCellRenderer.class);
    
    /**
     * 
     */
    public VocabularyPresenterListCellRenderer() {
         setOpaque(true);
    }
    
    /**
     * 
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return 
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends DecorableVocabularyElementPair> list,
                                                  DecorableVocabularyElementPair value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        
        removeAll();
        labelone = new JLabel(value.getFirst().getTitle());
        labelone.setIcon(new ImageIcon(value.getFirst().getImage()));
        labeltwo = new JLabel(" - ");
        labelthree = new JLabel(value.getSecond().getTitle());
        labelthree.setIcon(new ImageIcon(value.getSecond().getImage()));

        add(labelone);        
        add(labeltwo);
        add(labelthree);

        if (isSelected) {
            setBackground(list.getSelectionBackground()); 
            setForeground(list.getSelectionForeground()); 
        } else {
            boolean isActive = false;
            Object o = value.get(VocabularyModel.Status.ACTIVEPAIR);
            if (o != null) {
                isActive = (Boolean) o;
            }
            if (isActive) {
                setBackground(Color.GREEN); 
            } else {
                setBackground(list.getBackground()); 
                setForeground(list.getForeground()); 
                labelone.setForeground(Color.CYAN);
            }
        } 
        
        return this;
    }
}
