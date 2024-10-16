theme: /main

    state: start
        q!: $regex</start>
        go!: /main_a/start
            
    # Глобальный noMatch
    state: noMatch
        event!: noMatch
        go!: /main_a/noMatch
        
    # Сообщение о превышении лимита символов
    state: lengthLimit
        event!: lengthLimit
        go!: /main_a/lengthLimit