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
