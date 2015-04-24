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
#include "widget-optionquestion.h"


class WidgetVocabularyTrainer : public QWidget
{

    Q_OBJECT

    WidgetOptionChooser *optionChooser = NULL;
    WidgetOptionQuestion *optionQuestion = NULL;
    
    std::string currentOptionUuid;
    
private slots:
    void optionChosen(QString);

public:
    WidgetVocabularyTrainer(Option* options[5], QWidget* parent = 0);
    ~WidgetVocabularyTrainer();
};

#endif // VOCABULARYTRAINERWIDGET_H
