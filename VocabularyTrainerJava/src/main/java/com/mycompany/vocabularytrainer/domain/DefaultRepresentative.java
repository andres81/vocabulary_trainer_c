/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vocabularytrainer.domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
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
        image = new BufferedImage(100, 100, TYPE_INT_RGB);
        title = "TITLE";
    }
    
    /**
     * 
     * @param uuid
     * @param title
     * @param image
     */
    public DefaultRepresentative(UUID uuid, String title, Image image) {
        this();
        if (uuid != null) {
            this.uuid = uuid;
        }
        if (title != null) {
            this.title = title;
        }
        if (image != null) {
            this.image = image;
        }
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
        if (image == null) {
            throw new NullPointerException("Null given for image parameter!");
        }
        this.image = image;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getTitle() {
        return title; 
    }
    
    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("");
        }
        this.title = title;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
