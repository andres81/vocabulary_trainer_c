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
function initAudio() {
  $(".audiolink").click(clickAudio);
}

function clickAudio() {
  playAudio($(this));
}

function playAudio(elem){
  var play=elem.attr("play");
  
  var soundFile = "" + play;
  
  var audio=document.createElement("audio");
  audio.setAttribute('src', soundFile);
  audio.play();
}
