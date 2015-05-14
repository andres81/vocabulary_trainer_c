/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.awt.Image;
import java.util.UUID;

/**
 *
 * @author andres81
 */
public interface Representative {

    /**
     * 
     * @return 
     */
    public Image getImage();
    
    /**
     * 
     * @return 
     */
    public String getTitle();

    /**
     * 
     * @return 
     */
    public UUID getUuid();
    
    /**
     * 
     */
    public enum Representation {
       STRING,
       IMAGE;
    }
}
