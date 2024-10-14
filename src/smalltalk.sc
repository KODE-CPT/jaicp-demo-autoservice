theme: /smalltalk.sc
    
    state: Hello
        intent!: /привет
        a: Привет! Как дела?

        state: AnswerGood
            intent: /хорошо
            a: Это отлично! Чем я могу помочь?
            
        state: AnswerBad
            intent: /плохо
            a: Ужас! Могу ли я чем-то помочь?
                
    state: Bye
        intent!: /пока
        a: Всего доброго и удачи на дорогах!

    state: WhoAreYou
        intent!: /кто ты
        a: Меня зовут Вася. А вас?
        
        state: Answer
            q: *
            a: Приятно познакомиться!
