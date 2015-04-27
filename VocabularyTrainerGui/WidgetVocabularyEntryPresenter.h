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



#ifndef GUESSOBJECTWIDGET_H
#define GUESSOBJECTWIDGET_H

#include <QWidget>
#include <QLabel>

#include "option.h"

class WidgetVocabularyEntryPresenter : public QWidget
{
    Q_OBJECT

    QLabel *textLabel = NULL;
    Option entry;
public:
    explicit WidgetVocabularyEntryPresenter(QWidget *parent = 0);
    ~WidgetVocabularyEntryPresenter();

    void setVocabularyEntry(Option entry);
};

#endif // GUESSOBJECTWIDGET_H
