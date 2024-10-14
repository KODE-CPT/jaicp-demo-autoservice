require: appointment.sc
require: smalltalk.sc
require: patterns.sc

require: js/scripts.js
    
require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
theme: /main

    state: Start
        q!: $regex</start>
        script: $context.session = {};
        a: Здравствуйте! Чем я могу помочь?
        buttons:
            "Записаться на ТО" -> /appointment/Start
            "FAQ" -> /main/FAQ
   
    state: NoMatch
        event!: noMatch
        a: Извините, непонятно. Попробуйте ещё раз.

    state: FAQ
        a: || htmlEnabled = true, html = "
            ❓ <b>Зачем проходить ТО?</b> 
            <br> Техническое обслуживание нужно, чтобы предотвратить вероятность случайных поломок, 
            а также произвести регулировку всех основных узлов и агрегатов, чтобы максимально снизить
            расход топлива и смазочных материалов.
            <br>
            <br>❓ <b>Что входит в плановое ТО?</b> 
            <br>Плановое ТО включает замену масла и фильтров, проверку тормозов, подвески, жидкости, шин, диагностику двигателя и электроники. Подробнее — <a href=\"http://www.someautodealer/techservice>на нашем сайте.</a>.
            <br>
            <br>❓ <b>Сколько по времени занимает ТО?</b> 
            <br> В среднем техническое обслуживание занимает 2 часа. Зависит от конкретного плана работ.
            <br>
            <br>❓<b>И сколько это стоит?</b> 
            <br> Точные расценки смотрите <a href=\"http://www.someautodealer/techservice#calculate>здесь.</a>. А <a href=\"http://www.someautodealer/techservice#actions>здесь</a> — наши акции и специальные предложения. 
            <br>
            <br>❓<b>А как записаться?</b> 
            <br> Нажмите кнпоку «Записаться на ТО» и заполните небольшую заявку. Наш специалист свяжется с вами и согласует время."
        
        buttons:
            "Записаться на ТО" -> /appointment/Start        
    
    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        script:
            $faq.pushReplies();