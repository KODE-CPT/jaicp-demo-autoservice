require: appointment.sc
require: smalltalk.sc
require: patterns.sc

require: js/scripts.js
    
require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
theme: /

    state: Start
        q!: $regex</start>
        script: $context.session = {};
        a: Здравствуйте! Чем я могу помочь?
        buttons:
            "Записаться на ТО" -> /appointment/Start

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        script:
            $faq.pushReplies();