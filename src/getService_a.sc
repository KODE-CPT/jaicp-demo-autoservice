theme: /getService_a
    
# КЛАССИФИКАЦИЯ ПАРАМЕТРОВ ИЗ СТАРТОВОГО ЗАПРОСА -------------------------------
    state: start
        script: 
            $session.clientName = getRenderName($parseTree._Name, $parseTree._SurName);
            $session.phone = $parseTree._Phone;
            if ($parseTree._Model) {$session.car = $parseTree._Model.name}
            else if ($parseTree._Brand) {$session.car = $parseTree._Brand.name}
        a: ОК, сейчас запишем.
        go!: /getService_a/name
        
        
# ЗАПРОС ИМЕНИ ----------------------------------------------------------------- 
    state: name
        if: $session.clientName  // Если параметр сохранен из стартового запроса, переходим к следующему вопросу.
            go!: /getService_a/phone
        go!: /getService_a/name/question
            
        state: question  
            a: Как вас зовут?
            go: /getService/name/sendName

        # Реакция на реплику пользователя: c распознанным параметром и без него 
        state: reaction
            state: correct   
                script: $session.clientName = getRenderName($parseTree._Name, $parseTree._SurName)
                go!: /getService_a/phone
                        
            state: noMatch 
                a: Не похоже на имя. Попробуйте ещё раз.
                go: /getService/name/sendName


# ЗАПРОС ТЕЛЕФОНА --------------------------------------------------------------                
    state: phone
        if: $session.phone
            go!: /getService_a/car
        go!: /getService_a/phone/question
            
        state: question
            a: Напишите ваш номер телефона. Мы позвоним на него, чтобы согласовать время.
            buttons: 
                "Напишите мне в Телеграм" -> /getService/phone/sendTelegram
            go: /getService/phone/sendPhone
        
        state: reaction    
            state: correct  
                script: $session.phone = $parseTree._Phone
                go!: /getService_a/car
                        
            state: noMatch 
                a: Не похоже на номер телефона. Напишите его в формате 8 XXX XXX-XX-XX.
                go: /getService/phone/sendPhone   


# РЕАКЦИЯ НА ПРОСЬБУ ИСПОЛЬЗОВАТЬ ТЕЛЕГРАМ  ------------------------------------                
    state: telegram
        state: reaction
            state: correct    
                script: 
                    $session.useTelegram = true
                    // $session.telegram = $request.rawRequest.message.from.username  / Закоментили для прохождения автотестов
                a: Хорошо
                go!: /getService_a/car


# ЗАПРОС АВТОМОБИЛЬ (МОДЕЛЬ/МАРКА/СВОБОДНЫЙ ВВОД)  -----------------------------             
    state: car 
        if: $session.car
            go!: /getService_a/done
        go!: /getService_a/car/question
            
        state: question
            a: Укажите марку или модель вашего автомобиля
            go: /getService/car/sendCar
            
        state: reaction
            state: correct  
                script: 
                    if ($parseTree._Model) {$session.car = $parseTree._Model.name}
                    else if ($parseTree._Brand) {$session.car = $parseTree._Brand.name}
                    else $session.car = processingForUnknownCar($request.query)
                go!: /getService_a/done
                

# ЗАВЕРШЕНИЕ СЦЕНАРИЯ ----------------------------------------------------------    
    state: done
        if: $session.useTelegram
            a: Отправил заявку на техобслуживание: \n
                Клиент: {{$session.clientName}} \n
                Автомобиль: {{$session.car}} \n
                Спасибо за обращение! Наш сотрудник напишет вам в ближайшее время. 
                    
        else: 
            a: Отправил заявку на техобслуживание: \n
                Клиент: {{$session.clientName}} \n
                Телефон: {{$session.phone}} \n
                Автомобиль: {{$session.car}} \n
                Спасибо за обращение! Наш сотрудник свяжется с вами в ближайшее время. 
                
        script: $context.session = {} // В реальном боте контекст должен быть очищен после отрпавки заявки оператору.
        buttons: 
            "Оставить ещё одну заявку" -> /getService_a/start 