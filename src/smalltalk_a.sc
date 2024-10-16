theme: /smalltalk_a
    
    # Приветствие
    state: hello
        a: Привет! Как дела?
        go: /smalltalk/hello
        
        state: good
            a: Это отлично! Чем я могу помочь?
            
        state: bad
            a: Ужас! Могу ли я чем-то помочь?
                
    # Прощание
    state: bye
        a: Всего доброго и удачи на дорогах!

    # Кто ты
    state: whoAreYou
        a: Меня зовут Вася. А вас?
        go: /smalltalk/whoAreYou
        state: answer
            a: Приятно познакомиться!

