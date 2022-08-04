# UserAgentParsing

Получение информации о клиенте по строке user-agent.

## Использование

#### Получение всех данных

```java
UserAgentParsing userAgentParser = new UserAgentParser();
userAgentParser.setUserAgent(
    "Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
userAgentParser.getAll();
/*
Результат выполнения:
{
    browser_name=Google Chrome,
    browser_version=89.0.4389.105,
    
    device_type=Mobile,
    device_model=SM-A300FU,
    
    operating_system_name=Android,
    operating_system_version=6.0.1
}
*/
```

#### Получение данных по отдельности

```java
UserAgentParsing userAgentParser = new UserAgentParser();
userAgentParser.setUserAgent(
    "Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);

// Возвращает название браузера
userAgentParser.getBrowserName();
// Результат выполнения: Google Chrome

// Возвращает версию браузера
userAgentParser.getBrowserVersion();
// Результат выполнения: 89.0.4389.105

// Возвращает тип устройства
userAgentParser.getDeviceType();
// Результат выполнения: Mobile

// Возвращает модель устройства
userAgentParser.getDeviceModel();
// Результат выполнения: SM-A300FU

// Возвращает название операционной системы
userAgentParser.getOperatingSystemName();
// Результат выполнения: Android

// Возвращает версию операционной системы
userAgentParser.getOperatingSystemVersion();
// Результат выполнения: 6.0.1
```

#### Получение информации о браузере

```java
Browser browser = new Browser();
browser.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);

// Возвращает название браузера
browser.getName();
// Результат выполнения: Google Chrome

// Возвращает версию браузера
browser.getVersion();
// Результат выполнения: 89.0.4389.105
```

#### Получение информации об устройстве

```java
Device device = new Device();
device.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
// Возвращает тип устройства
device.getType();
// Результат выполнения: Mobile

// Возвращает модель устройства
device.getModel();
// Результат выполнения: SM-A300FU
```

#### Получение информации об операционной системе

```java
OperatingSystem operatingSystem = new OperatingSystem();
operatingSystem.setUserAgent(
    "Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);

// Возвращает название операционной системы
operatingSystem.getName();
// Результат выполнения: Android

// Возвращает версию операционной системы
operatingSystem.getVersion();
// Результат выполнения: 6.0.1
```

#### Получение списка всех названий браузеров

```java
Browser.getAll();
```

#### Получение списка всех типов устройств

```java
Device.getAll();
```

#### Получение списка всех названий операционных систем

```java
OperatingSystem.getAll();
```

## Установка

Для установки этого проекта, введите в терминале:

```bash
git clone https://github.com/kalenchukov/UserAgentParsing.git
```

## Версии

Доступные [версии](https://github.com/kalenchukov/UserAgentParsing/releases).

## Авторы

[Алексей Каленчуков](https://github.com/kalenchukov)

## Лицензия

[MIT](https://opensource.org/licenses/MIT)
