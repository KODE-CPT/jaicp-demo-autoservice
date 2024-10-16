theme: /getService

# ЗАПУСК СЦЕНАРИЯ --------------------------------------------------------------
    state: start
        q!: $GoToService
        go!: /getService_a/start
        
        
# ОТПРАВКА ЗНАЧЕНИЙ ПАРАМЕТРОВ -------------------------------------------------  
    state: name 
        state: sendName
            q: $SendName 
            go!: /getService_a/name/reaction/correct
            
        state: noMatch 
            event: noMatch 
            go!: /getService_a/name/reaction/noMatch

    state: phone 
        state: sendPhone
            q: $SendPhone
            go!: /getService_a/phone/reaction/correct
        
        state: sendTelegram
            q: $UseTelegram
            go!: /getService_a/telegram/reaction/correct 
            
        state: noMatch 
            event: noMatch 
            go!: /getService_a/phone/reaction/noMatch    

 
        
    state: car 
        state: sendCar
            q: $SendCar
            go!: /getService_a/car/reaction/correct
