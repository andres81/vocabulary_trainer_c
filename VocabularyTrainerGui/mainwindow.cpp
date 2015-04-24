#include <vector>
#include <iostream>

#include "mainwindow.h"
#include "fiveoptioncontainer.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
{


}

MainWindow::~MainWindow()
{

}

void MainWindow::optionChosen(QString optionUuid) {
    std::cout << "Option chosen: " << optionUuid.toStdString() << std::endl;
}
