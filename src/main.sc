theme: /main
    
    state: start
        q!: $regex</start>
        go!: /main_a/start

    state: noMatch
        event!: noMatch
        go!: /main_a/noMatch
        a: Извините, непонятно. Попробуйте ещё раз.
        
    state: lengthLimit
        event!: lengthLimit
        go!: /main_a/lengthLimit
        a: Ваше сообщение слишком длинное. Попробуйте написать короче.