/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.awt.Image;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author andres81
 */
public class DefaultRepresentative implements Representative {
    
    // Logging
    private static final Logger logger = LogManager.getLogger(DefaultRepresentative.class);
    
    /**
     * 
     */
    private String title = null;
    
    /**
     * 
     */
    private Image image = null;
    
    /**
     * 
     */
    private UUID uuid = null;
    
    /**
     * 
     */
    public DefaultRepresentative() {
        uuid = UUID.randomUUID();
    }
    
    /**
     * 
     * @param uuid
     * @param title
     * @param image
     */
    public DefaultRepresentative(UUID uuid, String title, Image image) {
        if (uuid == null) {
            throw new NullPointerException();
        }
        this.uuid = uuid;
        this.title = title;
        this.image = image;
    }
    
    /**
     * 
     */
    @Override
    public Image getImage() {
        return image;
    }
    
    /**
     * 
     * @param image 
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getTitle() {
        if (title == null) {
            title = "";
        }
        return title; 
    }
    
    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
