# SauceDemo UI Autotests

Практическое занятие №13 — автоматизированное тестирование проекта SauceDemo.

## Стек

- Java 17+
- Maven
- Selenium WebDriver
- TestNG
- Page Object
- Maven Surefire

## Реализованные сценарии

1. Позитивная авторизация `standard_user`.
2. Негативная авторизация `locked_out_user`.
3. Добавление `Sauce Labs Backpack` в корзину.
4. Полное оформление заказа.
5. Сортировка товаров A-Z.
6. Сортировка товаров Price Low to High.

## Запуск

Требуются JDK 17+, Maven и Google Chrome.

```bash
mvn clean test
```

Selenium Manager автоматически подберёт ChromeDriver для установленного Chrome.

## Отчёты

После запуска результаты находятся в:

```text
target/surefire-reports
```

## Git

Для практической работы рекомендуется создать ветку:

```text
feature/<Группа>_<Фамилия>_saucedemo
```

После этого сделать информативные коммиты и открыть Pull Request в `main`.
