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

#include "vocabularyentrypair.h"
#include "vocabularyentry.h"

VocabularyEntryPair::VocabularyEntryPair(std::string uuid, const VocabularyEntry entry1, const VocabularyEntry entry2) 
: uuid(uuid), entryOne(entry1), entryTwo(entry2)
{
}

std::string VocabularyEntryPair::getUuid()
{
    return uuid;
}
        
const VocabularyEntry* VocabularyEntryPair::getEntryOne() const {
    return &entryOne;
}
    
const VocabularyEntry* VocabularyEntryPair::getEntryTwo() const {
    return &entryTwo;
}
