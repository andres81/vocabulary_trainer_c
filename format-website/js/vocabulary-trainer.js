
/**
 * 
 * @type type
 */
var _originalListsVocTrainer = null;

var _counter = 0;

var _maxNofListItems = 5;

/**
 * 
 * @param {type} lists
 * @returns {undefined}
 */
function setListsVocTrainer(lists) {
    
    _counter = 0;
    _originalListsVocTrainer = lists;
    
    console.log(lists);
    
    return nextGroupVocTrainer();
}

/**
 * 
 * @returns {nextGroupVocTrainer.vocabulary-trainerAnonym$0}
 */
function nextGroupVocTrainer() {

    var list1 = [];
    var list2 = [];
    
    var listLength = Math.min(_originalListsVocTrainer.list1.length, _originalListsVocTrainer.list2.length);
    console.log('ĺistLenght: ', listLength);
    
    _counter %= listLength;
    console.log(_counter);
    
    for(var i=0; i<_maxNofListItems; i++) {
        
        list1.push(_originalListsVocTrainer.list1[_counter]);
        list2.push(_originalListsVocTrainer.list2[_counter]);
        
        _counter++;
        console.log(_counter);
        _counter %= listLength;
        console.log(_counter);
    }
    
    console.log('ĺistLenght: ', listLength);
    
    return {
        list1: list1,
        list2: list2
    };
    
}    
