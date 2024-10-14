
// Преобразуем имя и фамилию
function getRenderName(surName, name) {
  // Справочник названий авто, распознаваемых как имя
    var namesLikeCars = [ 
    'мазда', 'мазду', 
    'лансер', 'лансера',
    'черри', 'субару',
    ];
    
  return [name, surName]
    .filter(function(item) {
      return Boolean(item);
    })
    .map(function(item) {
      if (namesLikeCars.indexOf(item.toLowerCase()) !== -1){
        return ''; 
      }
      return item[0].toUpperCase() + item.substring(1).toLowerCase(); 
    })
    .filter(function(item) {
      return Boolean(item); 
    })
    .join(" ");
}


// Чистим строку с названием неизвестного авто от заведомо мусорных слов
function removePhrasesForUnknownCar(str) {
  var phrasesToRemove = [
      'у меня', 'у нас'
      ];
  var lowerStr = str.toLowerCase();

  for (var i = 0; i < phrasesToRemove.length; i++) {
    var phrase = phrasesToRemove[i];
    var lowerPhrase = phrase.toLowerCase(); 
    var index = lowerStr.indexOf(lowerPhrase);
    
    while (index !== -1) { 
      str = str.slice(0, index) + str.slice(index + phrase.length);
      lowerStr = lowerStr.slice(0, index) + lowerStr.slice(index + lowerPhrase.length); 
      index = lowerStr.indexOf(lowerPhrase); 
    }
  }

  return str.trim(); 
}