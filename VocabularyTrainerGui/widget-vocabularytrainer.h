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



#ifndef VOCABULARYTRAINERWIDGET_H
#define VOCABULARYTRAINERWIDGET_H

#include <QWidget>
#include <QPushButton>
#include <QVBoxLayout>

#include "option.h"
#include "widget-optionchooser.h"
#include "WidgetVocabularyEntryPresenter.h"
#include "option-controller.h"
#include "observer-interface.h"


class WidgetVocabularyTrainer : public QWidget, ObserverInterface
{
    Q_OBJECT

    WidgetOptionChooser *optionChooser = NULL;
    WidgetVocabularyEntryPresenter *optionQuestion = NULL;
    std::string currentOptionUuid;
    OptionController *controller = NULL;
    OptionsModel *model = NULL;
    
private slots:
    void optionChosen(QString);
    
public:
    WidgetVocabularyTrainer(OptionsModel* model, OptionController* controller, QWidget* parent = 0);
    ~WidgetVocabularyTrainer();
    virtual void Update(SubjectInterface* changedSubject);
    
private:
    void updateActiveOption();
    void updateActiveOptions();
};

#endif // VOCABULARYTRAINERWIDGET_H
