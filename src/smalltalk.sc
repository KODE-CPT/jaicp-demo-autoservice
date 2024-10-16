theme: /smalltalk

    # Приветствие
    state: hello
        q!: $Hello
        go!: /smalltalk_a/hello

    # Как дела
    state: howAreYou
        q!: $HowAreYou
        go!: /smalltalk_a/howAreYou
        
        state: good
            q: $Good
            go!: /smalltalk_a/howAreYou/good
            
        state: bad
            q: $Bad
            go!: /smalltalk_a/howAreYou/bad
    
    # Прощание           
    state: bye
        q!: $Bye
        go!: /smalltalk_a/bye

    # Кто ты  
    state: whoAreYou
        q!: $WhoAreYou
        go!: /smalltalk_a/whoAreYou
        
        state: answer
            q: *
            go!: /smalltalk_a/whoAreYou/answer
