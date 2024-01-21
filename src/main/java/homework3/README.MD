## Использование Spring для разработки серверного приложения
### Задание: Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:
Проверка работы:
Для теcтирования проекта использовать программу PostMan:
a) Добавление пользователя - запрос :
метод - POST<br>
адрес - http://localhost:8080/user/body <br>
тело -<br>
{<br>
"name":"Artur",<br>
"age":23,<br>
"email":"exam1@yandex.ru"<br>
}<br>
b) Получение списка пользователей на сервере - запрос:<br>
метод - GET<br>
адрес - http://localhost:8080/user <br>
c) Проверка сортировки - запрос:<br>
метод - GET<br>
адрес - http://localhost:8080/tasks/sort <br>
d) Проверка фильтрации - запрос: <br>
метод - GET<br>
адрес - http://localhost:8080/tasks/filter/23 <br>
e) Проверка среднего арифметического - запрос:<br>
метод - GET<br>
адрес - http://localhost:8080/tasks/calc <br>

### Базовое задание
1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

### Задание со звездочкой
1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса
2) Перенести репозиторий проекта с List<User> на базу данных H2