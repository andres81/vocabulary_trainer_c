/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

        
  
//        if (isSelected) {
//            labelone.setBackground(Color.red);
//            labeltwo.setBackground(Color.red);
//            labelthree.setBackground(Color.red);
//        }
        
        if (isSelected) { 
            setBackground(list.getSelectionBackground()); 
            setForeground(list.getSelectionForeground()); 
        } else {
            boolean isActive = false;
            try {
                isActive = (Boolean) value.get(VocabularyModel.Status.ACTIVEPAIR);
            } catch (Exception e) {
                System.err.println("exception e: " + e.getMessage());
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
