#ifndef VOCABULARYTRAINERWIDGET_H
#define VOCABULARYTRAINERWIDGET_H

#include <qt5/QtWidgets/QWidget>
#include <qt5/QtWidgets/QPushButton>
#include <qt5/QtWidgets/QVBoxLayout>

class VocabularyTrainerWidget : public QWidget
{

    Q_OBJECT

private:
    QPushButton* button1;
    QPushButton* button2;
    QPushButton* button3;
    QPushButton* button4;
    QPushButton* button5;

public:
    VocabularyTrainerWidget(QWidget* parent = 0);
    ~VocabularyTrainerWidget();
};

#endif // VOCABULARYTRAINERWIDGET_H
