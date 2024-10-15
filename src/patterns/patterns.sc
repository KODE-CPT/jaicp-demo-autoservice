theme: /patterns
    
patterns:
    
# ИМЕНОВАННЫЕ СУЩНОСТИ -----------------------------------------------------
    $Name = @pymorphy.name 
    $SurName = @pymorphy.surn
    $Phone = @duckling.phone-number
    $Brand = $entity<Brands> || converter = brandConverter
    $Model = $entity<Models> || converter = modelConverter
    
    # Доп. сущности для заявки
    $ClientName = ($Name|$SurName|{$Name $SurName})
    $Car = [$Brand] [$Model]
    
# CИНОНИМЫ -----------------------------------------------------------------
    $GoTo = (пройти|проходить|отправить*)
    $Form = (~заявка|~анкета)
    $Register = (запиши*|записать*)
    $Telegram = (telegram|телеграм|~телега|тг|tg)
    $Service = (ТО|ТЭО|~техобслуживание|~обслуживание|~техосмотр|~осмотр|~проверка|~сервис)