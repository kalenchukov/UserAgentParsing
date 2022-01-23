# UserAgentParser
Получение информации о клиенте по строке user-agent.

### Получение всех данных
```java
UserAgentParsing userAgentParser = new UserAgentParser();

// Устанавливает строку user-agent для которой необходимо получить данные
userAgentParser.setUserAgent(
    "Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);

// Возвращает все данные
userAgentParser.getAll();

/*
Результат выполнения:
{
    browser_id=1,
    browser_name=Google Chrome,
    browser_version=89.0.4389.105,
    
    device_id=2,
    device_type=Mobile,
    device_model=SM-A300FU,
    
    operating_system_id=5,
    operating_system_name=Android,
    operating_system_version=6.0.1
}
*/
```

### Получение данных по отдельности
```java
UserAgentParsing userAgentParser = new UserAgentParser();

// Устанавливает строку user-agent для которой необходимо получить данные
userAgentParser.setUserAgent(
    "Mozilla/5.0 (X11; Linux x86_64; rv:91.0) Gecko/20100101 Firefox/91.0"
);

// Возвращает ID браузера
userAgentParser.getBrowserId();
/*
    Результат выполнения: 1
*/
    
// Возвращает название браузера
userAgentParser.getBrowserName();
/*
    Результат выполнения: Google Chrome
*/

// Возвращает версию браузера
userAgentParser.getBrowserVersion();
/*
    Результат выполнения: 89.0.4389.105
*/

// Возвращает ID устройства
userAgentParser.getDeviceId();
/*
    Результат выполнения: 2
*/

// Возвращает тип устройства
userAgentParser.getDeviceType();
/*
    Результат выполнения: Mobile
*/

// Возвращает модель устройства
userAgentParser.getDeviceModel();
/*
    Результат выполнения: SM-A300FU
*/
    
// Возвращает ID операционной системы
userAgentParser.getOperatingSystemId();
/*
    Результат выполнения: 5
*/

// Возвращает название операционной системы
userAgentParser.getOperatingSystemName();
/*
    Результат выполнения: Android
*/

// Возвращает версию операционной системы
userAgentParser.getOperatingSystemVersion();
/*
    Результат выполнения: 6.0.1
*/ 
```

### Работа с классом "Browser"
```java
// Возвращает название браузера по идентификатору
Browser.getById(3L);

// Возвращает идентификатор браузера по названию
Browser.getByName("Firefox");

// Возвращает список всех браузеров
Browser.getAll();
```

### Работа с классом "Device"
```java
// Возвращает тип устройства по идентификатору
Device.getById(2L);

// Возвращает идентификатор устройства по типу
Device.getByType("Mobile");

// Возвращает все типы устройств
Device.getAll();
```

### Работа с классом "OperatingSystem"
```java
// Возвращает название операционной системы по идентификатору
OperatingSystem.getById(7L);

// Возвращает идентификатор операционной системы по названию
OperatingSystem.getByName("Linux");

// Возвращает список всех операционных систем
OperatingSystem.getAll();
```