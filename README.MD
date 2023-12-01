# Справка
## UserAgentParsing
Получение информации о клиенте по строке user-agent.

## Использование
#### Получение всех данных
```java
UserAgentParsing userAgentParser = new UserAgentParser();
userAgentParser.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
userAgentParser.getAll();
```

Результат выполнения:
```
[
	browser_name=Google Chrome,
	browser_version=89.0.4389.105,
	device_type=Mobile,
	device_model=SM-A300FU,
	operating_system_name=Android,
	operating_system_version=6.0.1
]
```

#### Получение данных по отдельности
```java
UserAgentParsing userAgentParser = new UserAgentParser();
userAgentParser.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
```

Возвращает название браузера:
```java
userAgentParser.getBrowserName();
```

Результат выполнения:
```
Google Chrome
```

Возвращает версию браузера:
```java
userAgentParser.getBrowserVersion();
```

Результат выполнения:
```
89.0.4389.105
```

Возвращает тип устройства:
```java
userAgentParser.getDeviceType();
```

Результат выполнения:
```
Mobile
```

Возвращает модель устройства:
```java
userAgentParser.getDeviceModel();
```

Результат выполнения:
```
SM-A300FU
```

Возвращает название операционной системы:
```java
userAgentParser.getOperatingSystemName();
```

Результат выполнения:
```
Android
```

Возвращает версию операционной системы:
```java
userAgentParser.getOperatingSystemVersion();
```

Результат выполнения:
```
6.0.1
```

#### Получение информации о браузере
```java
Browser browser = new Browser();
browser.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
```

Возвращает название браузера:
```java
browser.getName();
```

Результат выполнения:
```
Google Chrome
```

Возвращает версию браузера:
```java
browser.getVersion();
```

Результат выполнения:
```
89.0.4389.105
```

#### Получение информации об устройстве
```java
Device device = new Device();
device.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
```

Возвращает тип устройства:
```java
device.getType();
```

Результат выполнения:
```
Mobile
```

Возвращает модель устройства:
```java
device.getModel();
```

Результат выполнения:
```
SM-A300FU
```

#### Получение информации об операционной системе
```java
OperatingSystem operatingSystem = new OperatingSystem();
operatingSystem.setUserAgent(
	"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
);
```

Возвращает название операционной системы:
```java
operatingSystem.getName();
```

Результат выполнения:
```
Android
```

// Возвращает версию операционной системы:
```java
operatingSystem.getVersion();
```

Результат выполнения:
```
6.0.1
```

#### Получение списка всех названий браузеров
```java
BrowserType.getAllNames();
```

#### Получение списка всех типов устройств
```java
DeviceType.getAllNames();
```

#### Получение списка всех названий операционных систем
```java
OperatingSystemType.getAllNames();
```
