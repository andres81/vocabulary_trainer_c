#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <qt5/QtWidgets/QMainWindow>
#include <qt5/QtWidgets/QVBoxLayout>
#include <qt5/QtWidgets/QPushButton>

class MainWindow : public QMainWindow
{
    Q_OBJECT

private slots:
    void optionChosen(QString);

public:
    MainWindow(QWidget *parent = 0);
    ~MainWindow();


    QPushButton* button1;
    QPushButton* button2;
    QPushButton* button3;
    QPushButton* button4;
    QPushButton* button5;
};

#endif // MAINWINDOW_H
