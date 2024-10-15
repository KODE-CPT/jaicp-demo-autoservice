require: service.sc 
require: smalltalk.sc
require: faq.sc
require: patterns/intents.sc
require: patterns/patterns.sc
require: js/scripts.js

require: csv/brands.csv
    name = Brands
    var = Brands

require: csv/models.csv
    name = Models
    var = Models
    
require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
#-------------------------------------------------------------------------------

theme: /main

    state: Start
        q!: $regex</start>
        script: $context.session = {};
        a: Здравствуйте! Чем могу помочь?
        buttons:
            "Записаться на ТО" -> /service/Start
            "FAQ" -> /faq/Main
   
    state: NoMatch
        event!: noMatch
        a: Извините, непонятно. Попробуйте ещё раз.
        
    state: LengthLimit
        event!: lengthLimit
        a: Ваше сообщение слишком длинное. Попробуйте написать короче.