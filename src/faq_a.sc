theme: /faq_a

    # Зачем нужно ТО
    state: whyService
        a: Техническое обслуживание нужно, чтобы предотвратить вероятность случайных поломок, а также произвести регулировку всех основных узлов и агрегатов, чтобы максимально снизить расход топлива и смазочных материалов. 
        a: Давайте я запишу вас и вы сможете обсудить всё с нашим специалистом. 
        go!: /getService_a/name
       
        
    # Когда ехать на ТО
    state: whenService
        a: График технического обслуживания можно узнать тут.|| htmlEnabled = true, html = "
            График технического обслуживания можно узнать <a href=\"http://www.someautodealer/techservice\">тут</a>.
            "
            
    # Возникла конфликтная ситуация
    state: conflictSituation
        a: Свяжитесь с моими коллегами, чтобы разобраться в ситуации.|| htmlEnabled = true, html = "
           <a href=\"http://www.someautodealer/contacts\">Свяжитесь с моими коллегами</a>, чтобы разобраться в ситуации.
            "
    
    # Повод для записи на сервис
    state: reasonForService
        a: Записать вас на техническое обслуживание?
        buttons:
            "Да" -> /faq_a/reasonForService/yes
            "Нет" -> /faq_a/reasonForService/no
        go: /faq/reasonForService
        
        state: yes
            go!: /getService_a/start
            
        state: no
            a: Хорошо. Будут вопросы — обращайтесь!  

    # Скидки
    state: discount 
        a:  Акции на техническое обслуживание представлены тут.|| htmlEnabled = true, html = "
            Акции на техническое обслуживание представлены <a href=\"http://www.someautodealer/techservice#actions\">тут</a>.
            "        
    
    # Cколько по времени займет ТО
    state: howLongService     
        a: В среднем техническое обслуживание занимает 2 часа. Точное время зависит от конкретного плана работ.
        buttons: 
            "Записаться на ТО" -> /getService_a/start 
    
    # Cколько стоит ТО
    state: costOfService
        a: Стоимость обслуживания можно рассчитать тут.|| htmlEnabled = true, html = "
            Стоимость обслуживания можно рассчитать <a href=\"http://www.someautodealer/techservice#calculate\">тут</a>.
            " 
    
    # Что входит в ТО
    state: contentsOfService
        a: План работ технического обслуживания можно узнать тут.|| htmlEnabled = true, html = "
            План работ технического обслуживания можно узнать <a href=\"http://www.someautodealer/techservice#calculate\">тут</a>.
            " 

        
        