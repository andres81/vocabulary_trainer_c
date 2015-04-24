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



#include "option.h"

/**
 */
Option::Option(std::string uuid, std::string title)
{
    this->uuid = uuid;
    setTitle(title);
}

/**
 * 
 * @param orig
 */
Option::Option(const Option& orig)
{
    this->uuid = orig.uuid;
    this->title = orig.title;
}

/**
 * 
 */
Option::~Option()
{

}

/**
 * 
 * @return 
 */
std::string Option::getUuid() {
    return uuid;
}

/**
 * 
 * @param title
 */
void Option::setTitle(std::string title)
{
    this->title = title;
}

/**
 * 
 * @return 
 */
std::string Option::getTitle()
{
    return title;
}
