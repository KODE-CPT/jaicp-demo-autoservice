theme: /smalltalk.sc
    
    state: Hello
        q!: $Hello
        a: Привет! Как дела?

        state: AnswerGood
            q: $Good
            a: Это отлично! Чем я могу помочь?
            
        state: AnswerBad
            q: $Bad
            a: Ужас! Могу ли я чем-то помочь?
                
    state: Bye
        q!: $Bye
        a: Всего доброго и удачи на дорогах!

    state: WhoAreYou
        q!: $WhoAreYou
        a: Меня зовут Вася. А вас?
        
        state: Answer
            q: *
            a: Приятно познакомиться!
