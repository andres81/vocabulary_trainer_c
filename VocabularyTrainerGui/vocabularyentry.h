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



#ifndef OPTION_H
#define OPTION_H

#include <string>

class VocabularyEntry
{
    std::string uuid;
    std::string title;
    
public:
    VocabularyEntry(){};
    VocabularyEntry(std::string uuid);
    VocabularyEntry(std::string uuid, std::string title);
    VocabularyEntry(const VocabularyEntry& orig);
    ~VocabularyEntry();
    std::string getUuid() const;
    std::string getTitle() const;
    void setTitle(std::string);
};

inline bool operator==(const VocabularyEntry& lhs, const VocabularyEntry& rhs){ return lhs.getUuid() == rhs.getUuid(); }
inline bool operator!=(const VocabularyEntry& lhs, const VocabularyEntry& rhs){return !(lhs == rhs);}

#endif // OPTION_H
