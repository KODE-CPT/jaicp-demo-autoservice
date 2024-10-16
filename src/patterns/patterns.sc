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
    $GoTo = (идти|ехать|отправить*)
    $Do = (проводить|делать|сделать|пройти|проходить)
    $Form = (~заявка|~анкета)
    $Register = (запиши*|записать*|запись)
    $TimeHasCome = (пришло время|подошло время|пора|собираюсь|планирую|подумываю)
    $Service = (ТО|ТЭО|~техобслуживание|~обслуживание|~техосмотр|~осмотр|~проверка|~сервис|техоб)