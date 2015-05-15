/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.Representative;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author andres81
 */
public class VocabularyPresenterListCellRenderer extends JPanel implements ListCellRenderer<Representative>{

    private JLabel labelone;
    private JLabel labeltwo;
    private JLabel labelthree;
    
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
    public Component getListCellRendererComponent(JList<? extends Representative> list,
                                                  Representative value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        
//        setText(value.getTitle());
        removeAll();
        labelone = new JLabel(value.getTitle());
        labeltwo = new JLabel(value.getTitle());
        labelthree = new JLabel(value.getTitle());
//        
        add(labelone);
        add(labeltwo);
        add(labelthree);
//        
//        if (isSelected) {
//            labelone.setBackground(Color.red);
//            labeltwo.setBackground(Color.red);
//            labelthree.setBackground(Color.red);
//        }
        
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

