# Запросные строки
require: patterns/intents.sc

# Паттерны и синонимы
require: patterns/patterns.sc

# Скрипты, конвертеры
require: js/scripts.js

# Запросные стейты
require: main.sc
require: getService.sc 
require: faq.sc
require: smalltalk.sc

# Ответные стейты
require: main_a.sc 
require: getService_a.sc 
require: faq_a.sc
require: smalltalk_a.sc

# Справочники
require: csv/brands.csv
    name = Brands
    var = Brands

require: csv/models.csv
    name = Models
    var = Models
  
