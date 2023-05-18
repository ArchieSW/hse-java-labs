# 📔 JavaHomeworks

👨‍🎓 Кутузов Дмитрий 21ПИ1

* tg: *[@archiensky](https://archiensky.t.me)*
* vk: *[Дмитрий Кутузов](https://vk.com/archietotsamblu)*

## ДЗ на 16.02.2023

<details> 
    <summary>Click me</summary>

> ### 🧮 ComplexNumbers
> ***Реализовано:***
>  - [X] Создать комплексное число (конструктор)
>  - [X] Сложить
>  - [X] Перемножить
>  - [X] Модуль
>  - [X] Отрицание комплексного числа
>  - [X] Аргумент
>  - [X] Алгебраическая форма
>  - [X] Тригонометрическая форма
>
> ***Дополнительно***
>  - [X] Тесты на Junit5 (корректность тестов можно посмотреть в CI в Github actions)
>
> ### ⬛ Matrices
> ***Реализовано:***
>  - [X] Матрица комплексных чисел
>  - [X] Сложение матриц
>  - [X] Отрицание матриц
>  - [X] Умножение на число
>  - [X] Умножение матриц
>  - [X] Транспонирование
>  - [X] Детерминант
>
> ***Дополнительно***
> - [X] Тесты на Junit5 (корректность тестов можно посмотреть в CI в Github actions)
</details>

## ДЗ на 9.03.2023

<details> 
    <summary>Click me</summary>

> ### 🧮 CharacterCounter
> ***Реализовано:***
>  - [X] Считывание имени файла для чтения
>  - [X] Подсчет количества символов в файле
>  - [X] Запись количества в файл
</details>

## ДЗ на 13.04.2023

<details>
    <summary> Click me </summary>

> ### ✂️ Full name shortener
> ***Реализовано***
>  - [X] Считывание ФИО и даты рождения из терминала
>  - [X] Сокращение имени
>  - [X] Подсчет количества полных лет
>  - [X] Вычисление пола
</details>

## ДЗ на 20.05.2023

> ### 🏋 Elevator
> ***Реализовано:***
>  - [X] Запуск лифтов в тред пуле
>  - [X] Обработка запросов в ConcurrentLinkedQueue
>  - [X] Вызывается оптимальный лифт к нужному этажу
>  - [X] Вывод действий в лог:
>  ```
> [2] Elevator at floor 0 and going STAY 
> [1] Elevator at floor 0 and going STAY
> [pool-1-thread-3] Generated request Request[floor=6, direction=UP]
> [1] Called with request Request[floor=6, direction=UP]
> [1] Elevator at floor 1 and going UP
> [pool-1-thread-3] Generated request Request[floor=0, direction=UP]
> [2] Called with request Request[floor=0, direction=UP]
> [1] Elevator at floor 2 and going UP
> [1] Elevator at floor 3 and going UP
> [pool-1-thread-3] Generated request Request[floor=0, direction=UP]
> [2] Called with request Request[floor=0, direction=UP]
> [1] Elevator at floor 4 and going UP
> [1] Elevator at floor 5 and going UP
> [pool-1-thread-3] Generated request Request[floor=10, direction=DOWN]
> [1] Called with request Request[floor=10, direction=DOWN]
> [1] Elevator at floor 6 and going UP
> [1] Elevator at floor 7 and going UP
> [pool-1-thread-3] Generated request Request[floor=9, direction=UP]
> [1] Called with request Request[floor=9, direction=UP]
> [1] Elevator at floor 8 and going UP
> [1] Elevator at floor 9 and going UP
> [pool-1-thread-3] Generated request Request[floor=10, direction=DOWN]
> [1] Called with request Request[floor=10, direction=DOWN]
> [1] Elevator at floor 10 and going UP
> [1] Elevator at floor 10 and going STAY
> [1] Elevator at floor 9 and going DOWN
> [pool-1-thread-3] Generated request Request[floor=8, direction=UP]
> [1] Called with request Request[floor=8, direction=UP]
> [1] Elevator at floor 8 and going DOWN
> [1] Elevator at floor 8 and going STAY
> ```