theme: /getService

# ЗАПУСК СЦЕНАРИЯ --------------------------------------------------------------
    state: start
        q!: $GoToService
        go!: /getService_a/start
        
        
# ОТПРАВКА ЗНАЧЕНИЙ ПАРАМЕТРОВ -------------------------------------------------  
    state: name 
        state: getName
            q: $GetName 
            go!: /getService_a/name/reaction/correct
            
        state: noMatch 
            event: noMatch 
            go!: /getService_a/name/reaction/noMatch

    state: phone 
        state: getPhone
            q: $GetPhone
            go!: /getService_a/phone/reaction/correct
        
        state: getTelegram
            q: $UseTelegram
            go!: /getService_a/telegram/reaction/correct 
            
        state: noMatch 
            event: noMatch 
            go!: /getService_a/phone/reaction/noMatch    
        
    state: car 
        state: getCar
            q: $GetCar
            go!: /getService_a/car/reaction/correct
