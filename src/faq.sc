theme: /faq

    # Зачем нужно ТО
    state: whyService 
        q!: $WhyService
        go!: /faq_a/whyService
        
        
    # Когда ехать на ТО
    state: whenService
        q!: $WhenService 
        go!: /faq_a/whenService
    
    
    # Возникла конфликтная ситуация
    state: conflictSituation
        q!: $ConflictSituation 
        go!: /faq_a/conflictSituation


    # Повод для записи на сервис
    state: reasonForService
        q!: $ReasonForService 
        go!: /faq_a/reasonForService
        
        state: Yes
            q: $Yes
            go!: /faq_a/reasonForService/yes
            
        state: No
            q: $No
            go!: /faq_a/reasonForService/no 
            

    # Скидки
    state: discount 
        q!: $Discount
        go!: /faq_a/discount
   
   
    # Cколько по времени займет ТО
    state: howLongService     
        q!: $HowLongService 
        go!: /faq_a/howLongService 


    # Cколько стоит ТО
    state: costOfService
        q!: $CostOfService
        go!: /faq_a/costOfService
 
 
    # Что входит в ТО
    state: contentsOfService
        q!: $ContentsOfService 
        go!: /faq_a/contentsOfService
