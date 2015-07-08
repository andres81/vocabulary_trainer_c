# VocabularyTrainer
##### Easy learning of vocabularies, with the option of different representations like images or sounds or whatever.

## What is a "vocabulary"

A vocabulary can be described as being a list of pairs or as two columns next to eachother with equal height. Both views are used in different contexts. 

***Two columns:***

| column 1 | column 2   |
|:--------:|:----------:|
| one      |  une       |
| two      |  deux      |
| three    |  trois     |

***Set of pairs:***

|             | column 1 | column 2   |
|-------------|:--------:|:----------:|
| **pair 1:** | one      |  une       |
| **pair 2:** | two      |  deux      |
| **pair 3:** | three    |  trois     |

## The way to learn a vocabulary

To learn a vocabulary fast, the best way is to ****do**** the vocabulary. What do I mean by that? Well, do the following:

1. Choose five pairs from the vocabulary.
1. Choose one pair, which we call the query pair.
1. Set the element in column 1 of the query pair as the element the user has to guess.
1. Set the elements in column 2 of the five pairs as the options, the elements from which the user can choose
1. If the user chooses wrong, do nothing, if the user chooses the correct element from column 2, choose another pair and set it as the query pair.

Why do nothing? Punishment is never good. Only positive reinforcement works. Don't punish the behaviour you don't want, but reinforce the behaviour you wish to be performed.

With software we can make this into a game. Fast clicking means processing of a lot of elements and a lot of exposure of the elements that are worked with. Exactly what is needed to make them stick in memory. 

The exercise itself is a lot of fun and will make you beg for more.

## Element types

The elements do not have to be of only one type: string. They could be images, sounds or even other things (Formulas...):

|             | column 1                        | column 2   |
|-------------|:-------------------------------:|:----------:|
| **pair 1:** | one   \| one.png   \| one.ogg   |  une   \| une.png   \| une.ogg   |
| **pair 2:** | two   \| two.png   \| two.ogg   |  deux  \| deux.png  \| deux.ogg  |
| **pair 3:** | three \| three.png \| three.ogg |  trois \| trois.png \| trois.ogg |

Although the elements have different presentation forms, only one presentation form is active during the exercise. But the columns can have different presentation types. For example, an image from column one could be queried while five audio files are presented as options.
Of course presenting audio files as options is not very practical so I advise not to use this. But a user is free and should be free in an implementation to choose the representation.

## Options

With the previously given setup, the user should be presented with a set of options to configure the vocabulary. These are at the very least:

1. Change the query and option columns ( column1 - column2, column2 - column1, column1 - column1, column2 - column2.
1. Change the presentation of elements for the query and option column.
1. Change the five pairs that are being practiced.
