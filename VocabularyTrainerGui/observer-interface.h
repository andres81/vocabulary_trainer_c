/* 
 * File:   Observer.h
 * Author: andres81
 *
 * Created on April 27, 2015, 1:58 PM
 */

#ifndef OBSERVER_H
#define	OBSERVER_H

#include <string>

class SubjectInterface;

class ObserverInterface {
public:
    virtual ~ObserverInterface() {};
    virtual void Update(SubjectInterface* changedSubject) = 0;
protected:
    ObserverInterface() {};
};

class SubjectInterface {
public:
    virtual ~SubjectInterface() {};
    virtual void Attach(ObserverInterface*) = 0;
    virtual void Detach(ObserverInterface*) = 0;
    virtual void Notify() = 0;
protected:
    SubjectInterface() {};
};

#endif	/* OBSERVER_H */

