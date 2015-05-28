/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.VocabularyElementPair;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
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
public class VocabularyPresenterListCellRenderer extends JPanel implements ListCellRenderer<VocabularyElementPair>{

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
    public Component getListCellRendererComponent(JList<? extends VocabularyElementPair> list,
                                                  VocabularyElementPair value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        
        removeAll();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel row = new JPanel();
        row.setAlignmentX(CENTER_ALIGNMENT);
        labelone = new JLabel(value.getFirst().getTitle());
        labeltwo = new JLabel(" - ");
        labelthree = new JLabel(value.getSecond().getTitle());

        row.add(labelone);        
        row.add(labeltwo);
        row.add(labelthree);
//        
//        if (isSelected) {
//            labelone.setBackground(Color.red);
//            labeltwo.setBackground(Color.red);
//            labelthree.setBackground(Color.red);
//        }
        
        add(row);
        
        if (isSelected) { 
            setBackground(list.getSelectionBackground()); 
            setForeground(list.getSelectionForeground()); 
        } else { 
            setBackground(list.getBackground()); 
//            setForeground(list.getForeground()); 
            labelone.setForeground(Color.CYAN); 
        } 
        
        return this;
    }
}

