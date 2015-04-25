#!/usr/bin/bash

rm *.pro
rm VocabularyTrainerGui
rm Makefile

echo "Running qmake -project"
qmake -project "QT = core gui widgets";
echo "Running qmake"
qmake;
echo "Running make"
make clean
make;
