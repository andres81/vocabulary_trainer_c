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
package com.mycompany.vocabularytrainer.domain.interfaces;

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
