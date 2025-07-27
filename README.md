
# SauceDemo Automation Project / Проект автоматизации SauceDemo

## Test Plan / План тестирования

### 1. Project Overview / Обзор проекта
This project automates testing of the web application [SauceDemo](https://www.saucedemo.com/), using Selenium WebDriver, TestNG, and the Page Object Model pattern.
Этот проект автоматизирует тестирование веб-приложения [SauceDemo](https://www.saucedemo.com/), используя Selenium WebDriver, TestNG и паттерн Page Object Model.

### 2. Scope / Область применения
- Testing login functionality (valid and invalid) / Тестирование функциональности логина (валидного и невалидного)
- Verifying main inventory page loads after successful login / Проверка загрузки главной страницы инвентаря после успешного входа
- Testing main pages: LoginPage, InventoryPage, CartPage (as project expands) / Тестирование основных страниц: LoginPage, InventoryPage, CartPage (по мере расширения проекта)

### 3. Test Types / Типы тестов

| Test Type             | Description                                      | Тип теста             | Описание                                      |
|-----------------------|------------------------------------------------|-----------------------|-----------------------------------------------|
| Functional Tests       | Verify correct login and navigation             | Функциональные тесты  | Проверка корректной работы логина и перехода |
| Negative Tests        | Check error handling on invalid inputs           | Негативные тесты      | Проверка ошибок при неверных данных           |
| UI Tests              | Verify visibility of page elements                | UI тесты              | Проверка отображения элементов страницы       |
| Regression Tests      | Verify core functionality does not break          | Регрессионные тесты   | Проверка, что базовый функционал не ломается  |

### 4. Test Environment / Тестовая среда
- OS: Windows / MacOS / Linux  
- Browser: Google Chrome (latest version)  
- WebDriver: ChromeDriver managed by WebDriverManager  
- Java 17+  
- Maven for build and dependency management

- ОС: Windows / MacOS / Linux  
- Браузер: Google Chrome (последняя версия)  
- WebDriver: ChromeDriver, управляемый WebDriverManager  
- Java 17+  
- Maven для сборки и управления зависимостями

### 5. Test Framework / Тестовый фреймворк
- Selenium WebDriver  
- TestNG for test management and execution  
- Page Object Model for maintainable test code  
- Maven for dependency and build management  
- (Optional) Allure for reporting

- Selenium WebDriver  
- TestNG (для управления тестами и запуска)  
- Page Object Model для удобства поддержки и расширения тестов  
- Maven для управления зависимостями и сборки  
- (Опционально) Allure для отчётности

### 6. Test Execution / Запуск тестов
- Run tests: `mvn clean test`  
- Test configuration via `testng.xml`  
- Ability to run individual tests or groups  
- Parallel test execution planned

- Запуск тестов: `mvn clean test`  
- Конфигурация тестов через `testng.xml`  
- Возможность запуска отдельных тестов и групп  
- Параллельный запуск тестов (в планах)

### 7. Test Cases Examples / Примеры тест-кейсов

| ID   | Name / Название           | Description / Описание                                 | Expected Result / Ожидаемый результат                 |
|-------|--------------------------|-------------------------------------------------------|-------------------------------------------------------|
| TC01  | Valid Login              | Login with valid credentials                            | Redirect to inventory page with title "Products"      |
| TC02  | Invalid Login            | Login with invalid username/password                    | Error message displayed                                |
| TC03  | Login with Empty Fields  | Attempt login with empty username/password             | Error message displayed                                |
| TC04  | Inventory Page Elements  | Verify header and product list are displayed           | Elements are visible                                   |

### 8. Responsibilities / Ответственности
- Writing and maintaining tests — QA Automation Engineer  
- Updating Page Objects after UI changes — QA Automation Engineer  
- Managing configuration and dependencies — DevOps / QA Engineer

- Написание и поддержка тестов — QA Automation Engineer  
- Обновление Page Objects при изменениях UI — QA Automation Engineer  
- Управление конфигурацией и зависимостями — DevOps / QA Engineer

### 9. Risks and Mitigation / Риски и меры
- UI instability — use waits and logic in `BasePage`  
- Site updates — timely update selectors and pages  
- Performance — optimize tests and use parallel execution

- Нестабильность UI — использовать ожидания и логику в `BasePage`  
- Обновления сайта — своевременно обновлять селекторы и страницы  
- Производительность — оптимизировать тесты и использовать параллелизм

### 10. Future Improvements / Будущие улучшения
- Add negative and boundary tests  
- Expand coverage with Cart, Checkout, Product Details pages  
- Integrate Allure reports and CI/CD pipelines  
- Implement data-driven testing

- Добавить негативные и граничные тесты  
- Расширить покрытие страницами Cart, Checkout, Product Details  
- Подключить отчёты Allure и CI/CD интеграцию  
- Настроить data-driven тестирование

---

## How to Run Tests / Как запускать тесты

```bash
mvn clean test
```

Tests are configured via the `testng.xml` file.

Тесты конфигурируются через файл `testng.xml`.

