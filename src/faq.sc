theme: /faq
    
    # Общий FAQ 
    state: Main
        a: || htmlEnabled = true, html = "
            ❓ <b>Зачем проходить ТО?</b> 
            <br>Техническое обслуживание нужно, чтобы предотвратить вероятность случайных поломок, 
            а также произвести регулировку всех основных узлов и агрегатов, чтобы максимально снизить
            расход топлива и смазочных материалов.
            <br>
            <br>❓ <b>Что входит в плановое ТО?</b> 
            <br>Плановое ТО включает замену масла и фильтров, проверку тормозов, подвески, жидкости, шин, диагностику двигателя и электроники. 
            Подробнее — <a href=\"http://www.someautodealer/techservice\">на нашем сайте</a>.
            <br>
            <br>❓ <b>Как часто нужно проходить обслуживание?</b> 
            <br>Отслеживайте сроки <a href=\"http://www.someautodealer/techservice\">по графику ТО</a>.
            <br>
            <br>❓ <b>Сколько по времени занимает ТО?</b> 
            <br> В среднем техническое обслуживание занимает 2 часа. Зависит от конкретного плана работ.
            <br>
            <br>❓<b>Сколько стоит ТО? </b> 
            <br> - <a href=\"http://www.someautodealer/techservice#calculate\">Калькулятор стоимости</a>.
            <br> - <a href=\"http://www.someautodealer/techservice#actions\">Акции и специальные предложения</a>. 
            <br>
            <br>❓<b>А как записаться?</b> 
            <br>Нажмите кнпоку «Записаться на ТО» и заполните небольшую заявку. Наш специалист свяжется с вами и согласует время.
            "
        buttons:
            "Записаться на ТО" -> /service/Start


    # Зачем нужно ТО
    state: WhyService 
        q!: $WhyService
        a: Техническое обслуживание нужно, чтобы предотвратить вероятность случайных поломок, а также произвести регулировку всех основных узлов и агрегатов, чтобы максимально снизить расход топлива и смазочных материалов. 
        go!: /service/New
        
    # Когда ехать на ТО
    state: WhenService
        q!: $WhenService 
        a: || htmlEnabled = true, html = "
            График технического обслуживания можно узнать <a href=\"http://www.someautodealer/techservice\">на этой странице ТО</a>.
            "
    
    # Возникла конфликтная ситуация
    state: ConflictSituation
        q!: $ConflictSituation 
        a: || htmlEnabled = true, html = "
            Сожалею, что так вышло. <a href=\"http://www.someautodealer/contacts\">Свяжитесь с моими коллегами</a>, чтобы разобраться в ситуации.
            "
    # Повод для записи на сервис
    state: ReasonForService
        q: $ReasonForService     
        a: Записать вас на техническое обслуживание?
        buttons:
            "Да" -> /faq/ReasonForService/Yes
            "Нет" -> /faq/ReasonForService/No
        
        state: Yes
            q: $Yes
            go!: /service/Start
            
        state: No
            q: $No
            a: Хорошо   

    # Скидки
    state: Discount 
        q!: $Discount
        a: || htmlEnabled = true, html = "
            Акции на техническое обслуживание представлены <a href=\"http://www.someautodealer/techservice#actions\">на этой странице</a>.
            "        
    # Cколько по времени займет ТО
    state: HowLongService     
        q!: $HowLongService 
        a: В среднем техническое обслуживание занимает 2 часа. Точное время зависит от конкретного плана работ.
    
    # Cколько стоит ТО
    state: CostOfService
        q!: $CostOfService
        a: || htmlEnabled = true, html = "
            Стоимость обслуживания можно рассчитать <a href=\"http://www.someautodealer/techservice#calculate\">на нашем сайте</a>.
            " 
    
    # Что входит в ТО
    state: ContentsOfService
        q!: $ContentsOfService 
        a: || htmlEnabled = true, html = "
            План работ технического обслуживания можно узнать <a href=\"http://www.someautodealer/techservice#calculate\">на нашем сайте</a>.
            " 

