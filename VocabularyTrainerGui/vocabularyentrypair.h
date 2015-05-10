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

#ifndef VOCABULARYENTRYPAIR_H
#define	VOCABULARYENTRYPAIR_H

#include <string>
#include "vocabularyentry.h"

class VocabularyEntryPair {
    
    std::string uuid;
    const VocabularyEntry entryOne;
    const VocabularyEntry entryTwo;
    
public:
    VocabularyEntryPair(std::string uuid, const VocabularyEntry entryOne, const VocabularyEntry entryTwo);
    VocabularyEntryPair(const VocabularyEntryPair& orig){};
    virtual ~VocabularyEntryPair(){};
    
    std::string getUuid();
    const VocabularyEntry* getEntryOne() const;
    const VocabularyEntry* getEntryTwo() const;
    
private:

};

#endif	/* VOCABULARYENTRYPAIR_H */

