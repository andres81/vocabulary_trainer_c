/*This file is part of the website andreschepers.org

andreschepers.org website software is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

andreschepers.org website software is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with andreschepers.org website software. If not, see <http://www.gnu.org/licenses/>.
*/

/**
 * The lists that are practiced.
 * @type lists
 */
var _lists = null;

/**
 * The lists set by the user.
 * @type lists
 */
var _originalListsStmT = null;

/**
 * 
 * @type Number
 */
var _nofCorrectAnswers = 0;

/**
 * 
 * @type Number
 */
var _nofCorrectAnswersToIncrease = 5;

/**
 * 
 * @type Number
 */
var _maxNofVisibleOptions = 5;

/**
 * 
 * @param {type} lists
 * @returns {undefined}
 */
function setListsStmT(lists) {
    _originalListsStmT = lists;
    initExercise();
}

/**
 * 
 * @returns {undefined}
 */
function initExercise() {
    
    _lists = {
     "list1":[],
     "list2":[]
    };
    
    // Add two options to list!
    addOptionToLists();
    addOptionToLists();
    
    updateExercise();
}

/**
 * 
 * @returns {undefined}
 */
function updateExercise() {
    clearVoctrainerDiv();
    setupExercise();
    setOptionBox();
    $(".guessBox").addClass("displaynone");
    initGuessObjects();
}

/**
 * 
 * @returns {undefined}
 */
function addOptionToLists() {
    var minLength = Math.min(_originalListsStmT.list1.length, _originalListsStmT.list2.length); 
    var randNumb = getNewRandNumb(minLength);
    var item1 = _originalListsStmT.list1[randNumb];
    var item2 = _originalListsStmT.list2[randNumb];
    while (_lists.list1.indexOf(item1) > -1 || _lists.list2.indexOf(item2) > -1) {
        randNumb = getNewRandNumb(minLength);
        item1 = _originalListsStmT.list1[randNumb];
        item2 = _originalListsStmT.list2[randNumb];
    }
    _lists.list1.push(item1);
    _lists.list2.push(item2);
}

/**
 * 
 * @returns {undefined}
 */
function reverseListsStmT() {
    var list1 = _originalListsStmT.list1;
    _originalListsStmT.list1 = _originalListsStmT.list2;
    _originalListsStmT.list2 = list1;
    initExercise();
}

/**
 * 
 * @returns {undefined}
 */
function clearVoctrainerDiv() {
    $('#voctrainer').html('');
}

/**
 * 
 * @returns {undefined}
 */
function setupExercise() {
    if (_lists) {
        var tag = 1;
        _lists.list1.forEach(function(elem) {
            injectDivObject('guessBox', tag, elem);
            tag++;
        });
        
        $('#voctrainer').append($('<br>'));
        
        tag = 1;
        _lists.list2.forEach(function(elem) {
            injectDivObject('optionBox', tag, elem);
            tag++;
        });
    } else {
        alert('Could not load exercises: no list of elements present!');
    }
}
/**
 * 
 * @param {type} type
 * @param {type} tag
 * @param {type} elem
 * @returns {undefined}
 */
function injectDivObject(type, tag, elem) {
    var newDiv = $('<div />');
    newDiv.text(elem);
    newDiv.addClass(type);
    newDiv.attr('data-tag', tag);
    $('#voctrainer').append(newDiv);
}

/**
 * 
 * @returns {undefined}
 */
function setOptionBox() {
  $(".optionBox").mouseenter(function(){ $(this).addClass("bold"); })
                 .mouseleave(function(){ $(this).removeClass("bold");})
		 .click(checkGuessAndIncrementNofOptions);
}

/**
 * 
 * @returns {undefined}
 */
function initGuessObjects() {
  $("#voctrainer").each(function() {
    setGuessObjectVisible($(this));
  });
}

/**
 * 
 * @param {type} domelem
 * @returns {undefined}
 */
function setGuessObjectVisible(domelem) {
    var children = domelem.children(".guessBox.displaynone");
    var newChild = $(children[getNewRandNumb(children.length)]);
    domelem.children(".guessBox").addClass("displaynone");
    $(newChild).removeClass("displaynone");
}

/**
 * 
 * @returns {undefined}
 */
function checkGuessAndIncrementNofOptions() {
    var tag = $(this).attr("data-tag");
    var exercise = $(this).parents("#voctrainer").get(0);
    var guessboxTag = $($(exercise).children(".guessBox").not(".displaynone").get(0)).attr("data-tag");
    if (tag === guessboxTag) {
        _nofCorrectAnswers++;
        if (_nofCorrectAnswers === _nofCorrectAnswersToIncrease) {
            _nofCorrectAnswers = 0;
            if (_lists.list1.length < _maxNofVisibleOptions-1) {
                addOptionToLists();
                updateExercise();
            } else {
                if (_lists.list1.length === _maxNofVisibleOptions-1) addOptionToLists();
                updateExercise();
                $( ".optionBox").unbind( "click" );
                $(".optionBox").click(checkGuess);
            }
        } else {
            setGuessObjectVisible($(exercise));
        }
    }
}

function showAllOptionsStmT() {
    _lists = {
        list1: _originalListsStmT.list1,
        list2: _originalListsStmT.list2
    }
    updateExercise();
    $(".optionBox").click(checkGuess);
}

/**
 * 
 * @param {type} event
 * @returns {undefined}
 */
function checkGuess(event) {
  var tag = $(this).attr("data-tag");
  var exercise = $(this).parents("#voctrainer").get(0);
  var guessboxTag = $($(exercise).children(".guessBox").not(".displaynone").get(0)).attr("data-tag");
  if (tag === guessboxTag) {
    setGuessObjectVisible($(exercise));
  }
}

/**
 * 
 * @param {type} roof
 * @returns {unresolved}
 */
function getNewRandNumb(roof) {
    return parseInt(Math.random() * roof);;
}

