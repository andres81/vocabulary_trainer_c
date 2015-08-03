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

import com.mycompany.vocabularytrainer.domain.DefaultVocabularyModel;
import com.mycompany.vocabularytrainer.domain.interfaces.DecorableVocabularyElementPair;
import com.mycompany.vocabularytrainer.domain.interfaces.VocabularyModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author andres81
 */
public class VocabularyPresenter extends JPanel implements ListSelectionListener, ActionListener {

    /**
     * 
     */
    private JList<DecorableVocabularyElementPair> vocabularyPairsList = null;
    
    /**
     * 
     */
    private JButton setActivePairsButton = null;
    
    /**
     * 
     */
    private VocabularyModel model = null;
    
    /**
     * 
     */
    private DefaultListModel<DecorableVocabularyElementPair> defaultListModel = null;
    
    /**
     * 
     */
    private List<UUID> currentSelection = null;
    
    /**
     * 
     */
    public VocabularyPresenter() {
        super();
        init();
        model = new DefaultVocabularyModel();
    }
    
    /**
     * 
     * @param model
     */
    public VocabularyPresenter(VocabularyModel model) {
        this();
        setVocabularyModel(model);
    }
    
    /**
     * 
     */
    private void init() {
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
       add(getList());
       add(getSetActivePairsButton());
    }
    
    /**
     * 
     * @return 
     */
    private JList<DecorableVocabularyElementPair> getList() {
       if (vocabularyPairsList == null) {
           vocabularyPairsList = new JList<>();
           vocabularyPairsList.setCellRenderer(new VocabularyPresenterListCellRenderer());
           vocabularyPairsList.addListSelectionListener(this);
       }
       return vocabularyPairsList;
    }
    
    /**
     * 
     * @return 
     */
    private JButton getSetActivePairsButton() {
        if (setActivePairsButton == null) {
            setActivePairsButton = new JButton("Set active pairs");
            setActivePairsButton.addActionListener(this);
        }
        return setActivePairsButton;
    }
    
    /**
     * 
     * @param model
     */
    public void setVocabularyModel(VocabularyModel model) {
        this.model = model;
        if (defaultListModel == null) {
            defaultListModel = new DefaultListModel<>();
        }
        defaultListModel.clear();
        for (DecorableVocabularyElementPair pair : model.getVocabularyElementPairs()) {
            defaultListModel.addElement(pair);
        }
        vocabularyPairsList.setModel(defaultListModel);
    }
    
    /**
     * 
     * @param e 
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList lsm = (JList)e.getSource();
        if (lsm != vocabularyPairsList) return;

        if (currentSelection == null) {
            currentSelection = new ArrayList<>();
        }
        currentSelection.clear();
        
        if (!lsm.isSelectionEmpty()) {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    DecorableVocabularyElementPair pair = (DecorableVocabularyElementPair) lsm.getModel().getElementAt(i);
                    currentSelection.add(pair.getUuid());
                }
            }
        }
        if (currentSelection.size() > 0) {
            setActivePairsButton.setEnabled(true);
        } else {
            setActivePairsButton.setEnabled(false);
        }
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (currentSelection != null &&
            !currentSelection.isEmpty()) {
            model.setActivePairs(currentSelection);
            vocabularyPairsList.updateUI();
            vocabularyPairsList.clearSelection();
        }
    }
}
