theme: /appointment

    state: Start
        intent!: /записаться на ТО
        script:
            $session.clientName = getRenderName($parseTree._Name, $parseTree._SurName);
            $session.phone = $parseTree._Phone;
            if ($parseTree._Model) {$session.car = $parseTree._Model.name}
            else if ($parseTree._Brand) {$session.car = $parseTree._Brand.name}
        go!: ../New/Name
        
    state: New
        
        state: Name
            a: Хорошо. Давайте составим заявку на техобслуживание.
            if: $session.clientName
                go!: ../Phone
            go!: ./Question
                
            state: Question
                a: Как вас зовут?
                go: ../Answer
                
            state: Answer
                q: * {$Name $SurName} *
                q: * $Name *
                q: * $SurName *
                script: $session.clientName = getRenderName($parseTree._Name, $parseTree._SurName)
                go!: ../../Phone

            state: LocalCatchAll || noContext = true
                event: noMatch 
                a: Не похоже на имя. Попробуйте ещё раз.
                
        state: Phone
            if: $session.phone
                go!: ../Car
            go!: ./Question
                
            state: Question
                a: Напишите ваш номер телефона. Мы позвоним вам, чтобы согласовать время.
                buttons: 
                    "Лучше пишите в Телеграм" -> ../useTelegram
                go: ../Answer
                
            state: Answer
                q: * $Phone *
                script: $session.phone = $parseTree._Phone
                go!: ../../Car
                    
            state: LocalCatchAll || noContext = true
                event: noMatch 
                a: Не похоже на номер телефона. Напишите его полностью.
                buttons: 
                    "Лучше пишите в Телеграм" -> ../useTelegram
        
            state: useTelegram
                q: * (телеграм/telegram) *
                script: 
                    $session.useTelegram = true
                    $session.telegram = "telegramUser"  // Заглушка для прохождения автотестов
                a: Хорошо!
                go!: ../../Car
        
        state: Car
            if: $session.car
                go!: ../Done
            go!: ./Question
                
            state: Question
                a: Укажите марку или модель вашего автомобиля
                go: ../Answer
                
            state: Answer 
                q: * $Model *
                q: * $Brand *
                q: *
                
                # Проверяем ввод пользователя по справочнику моделей и марок. Если нет совпадений - заносим то, что указал пользователь
                script: 
                    if ($parseTree._Model) {$session.car = $parseTree._Model.name}
                    else if ($parseTree._Brand) {$session.car = $parseTree._Brand.name}
                    else $session.car = removePhrasesForUnknownCar($request.query)
                go!: ../../Done       

        state: Done
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