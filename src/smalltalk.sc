theme: /smalltalk

    # Приветствие
    state: hello
        q!: $Hello
        go!: /smalltalk_a/hello

        state: good
            q: $Good
            go!: /smalltalk_a/hello/good
            
        state: bad
            q: $Bad
            go!: /smalltalk_a/hello/bad
    
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
