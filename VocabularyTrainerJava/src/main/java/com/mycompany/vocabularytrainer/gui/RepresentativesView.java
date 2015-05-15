/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.gui;

import com.mycompany.vocabularytrainer.domain.Representative;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author andres81
 */
public class RepresentativesView extends JPanel implements ActionListener {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(RepresentativesView.class);
    
    /**
     * 
     */
    private List<Representative> representatives = null;
    
    /**
     * 
     */
    private Representative.Representation representation = null;
    
    /**
     * 
     */
    private Map<JButton, UUID> buttonMapper = null;
    
    /**
     * 
     */
    private RepresentativesViewCallback callback = null;
    
    /**
     * 
     * @param callback 
     */
    public RepresentativesView(RepresentativesViewCallback callback) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        representation = Representative.Representation.STRING;
        this.callback = callback;
    }
    
    /**
     * 
     * @param callback 
     */
    public void setRepresentativesCallback(RepresentativesViewCallback callback) {
        this.callback = callback;
    }
    
    /**
     * 
     * @param representatives 
     */
    public void setRepresentatives(List<Representative> representatives) {
        this.representatives = representatives;
        initGui();
    }
    
    /**
     * 
     */
    private void initGui() {
        removeAll();
        if (buttonMapper == null) {
            buttonMapper = new HashMap<>();
        }
        if (representatives != null) {
            for (Representative rep : representatives) {
                JButton button = new JButton();
                button.setAlignmentX(CENTER_ALIGNMENT);
                switch (representation) {
                    case IMAGE:
                        break;
                    case STRING:
                        button.setText(rep.getTitle());
                        break;
                    default:
                        break;
                }
                add(button);
                add(Box.createRigidArea(new Dimension(10, 10)));
                buttonMapper.put(button,rep.getUuid());
                button.addActionListener(this);
            }
        }
        revalidate();
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (callback == null) {
            logger.info("No callback set so not calling callback function for button press.");
            return;
        }
        JButton buttonClicked;
        try {
            buttonClicked = (JButton) e.getSource();
        } catch(ClassCastException ex) {
            logger.error("Could not cast event source to JButton.", ex);
            return;
        }
        UUID uuid = buttonMapper.get(buttonClicked);
        if (uuid == null) {
            logger.error("Could not find uuid for button with title: " + buttonClicked.getText());
            return;
        }
        callback.representativeClicked(uuid);
    }
}
