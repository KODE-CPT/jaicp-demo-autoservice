theme: /smalltalk_a
    
    # Приветствие
    
    state: hello    
        random:
            a: Здравствуйте!
            a: Привет-привет!
    
    state: howAreYou
        a: Отлично! А у вас?
        go: /smalltalk/howAreYou
        
        state: good
            a: Я рад. Теперь давайте поговорим про автомобили.
            
        state: bad
            a: Жаль. Возможно, я смогу помочь. Задайте мне любой вопрос про наш автосервис.
                
    # Прощание
    state: bye
        a: Всего доброго и удачи на дорогах!

    # Кто ты
    state: whoAreYou
        a: Меня зовут Вася. А вас?
        go: /smalltalk/whoAreYou
        state: answer
            a: Приятно познакомиться!

