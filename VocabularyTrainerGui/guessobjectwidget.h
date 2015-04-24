#ifndef GUESSOBJECTWIDGET_H
#define GUESSOBJECTWIDGET_H

#include <qt5/QtWidgets/QWidget>

class Option;

class GuessObjectWidget : public QWidget
{
    Q_OBJECT

    Option** options;
    int currentOption;

public:
    explicit GuessObjectWidget(Option* options[5], QWidget *parent = 0);
    ~GuessObjectWidget();

    const char* setNewOption();
    void setNewOption(const char*);

signals:

public slots:
};

#endif // GUESSOBJECTWIDGET_H
