require: appointment.sc
require: smalltalk.sc
require: faq.sc
require: patterns.sc

require: js/scripts.js
    
require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
theme: /main

    state: Start
        q!: $regex</start>
        script: $context.session = {};
        a: Здравствуйте! Чем могу помочь?
        buttons:
            "Записаться на ТО" -> /appointment/Start
            "FAQ" -> /FAQ/Main
   
    state: NoMatch
        event!: noMatch
        a: Извините, непонятно. Попробуйте ещё раз.

