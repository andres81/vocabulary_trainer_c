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

#ifndef OPTIONSMODEL_H
#define	OPTIONSMODEL_H

#include <vector>

#include "observer-interface.h"
#include "vocabularyentry.h"

class VocabularyExerciseModel : public SubjectInterface {
    
    std::vector<VocabularyEntry> options;
    std::vector<const VocabularyEntry*> activeOptionsView;
    const VocabularyEntry* activeOptionView = NULL;
    std::vector<ObserverInterface*> observers;
    std::string state;
    
public:
    VocabularyExerciseModel(){};
    VocabularyExerciseModel(const VocabularyExerciseModel& orig);
    virtual ~VocabularyExerciseModel();
    const VocabularyEntry* getActiveOption();
    void setActiveOption(std::string uuid);
    std::vector<const VocabularyEntry*> getActiveOptions();
    void setActiveOptions(std::vector<std::string>);
    std::vector<VocabularyEntry> getOptions();
    void setOptions(std::vector<VocabularyEntry>);
    std::string GetState();
    virtual void Attach(ObserverInterface*);
    virtual void Detach(ObserverInterface*);
    virtual void Notify();
};

#endif	/* OPTIONSMODEL_H */
