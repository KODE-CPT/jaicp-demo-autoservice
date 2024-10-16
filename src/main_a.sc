theme: /main_a

    state: start
        a: Здравствуйте! Чем могу помочь?
        buttons:
            "Записаться на ТО" -> /getService_a/start
            
    state: noMatch
        a: Извините, непонятно. Попробуйте ещё раз.
        
    state: lengthLimit
        a: Ваше сообщение слишком длинное. Попробуйте написать короче.