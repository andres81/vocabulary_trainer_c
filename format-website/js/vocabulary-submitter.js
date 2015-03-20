/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitVocabularies() {
    var list1 = $('#voc1').val().split('\n');
    var list2 = $('#voc2').val().split('\n');

    console.log(list1);
    console.log(list2);
    
    var index = list1.indexOf("");
    console.log(index);
    while (index > -1) {
        list1.splice(index, 1);
        index = list1.indexOf("");
    }
    
    var index = list2.indexOf("");
    while (index > -1) {
        list2.splice(index, 1);
        index = list1.indexOf("");
    }
    
    var minLength = Math.min(list1.length, list2.length);
    list1 = list1.slice(0,minLength);
    list2 = list2.slice(0,minLength);
    
    return {
        list1: list1,
        list2: list2
    };

}
