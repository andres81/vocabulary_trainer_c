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

class Option
{
    std::string uuid;
    std::string title;
    
public:
    Option(){};
    Option(std::string uuid);
    Option(std::string uuid, std::string title);
    Option(const Option& orig);
    ~Option();
    std::string getUuid() const;
    std::string getTitle() const;
    void setTitle(std::string);
};

inline bool operator==(const Option& lhs, const Option& rhs){ return lhs.getUuid() == rhs.getUuid(); }
inline bool operator!=(const Option& lhs, const Option& rhs){return !(lhs == rhs);}

#endif // OPTION_H
