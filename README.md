# sortit
Задание:
  Написать программу сортировки содержимого файла
  
  Входной файл содержит данные одного из двух видов: целые числа или строки. Данные записаны
  в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные
  символы.
  Результатом работы программы должен являться новый файл с содержимым входного файла,
  отсортированным по возрастанию или убыванию. Для сортировки строк использовать
  лексикографический порядок (по кодам символов).
  
  Необходимо самостоятельно реализовать алгоритм сортировки методом вставок (Insertion sort) и
  использовать его для сортировки содержимого файла (не использовать библиотечные функции
  сортировки). Т.к. этот алгоритм не эффективен на больших объемах данных, можно считать, что
  входной файл содержит малое количество элементов: не больше 100.

  Все возможные виды ошибок должны быть обработаны. Программа не должна «падать». Если
  после ошибки продолжить выполнение невозможно, программа должна сообщить об этом
  пользователю с указанием причины неудачи.
  
  Имя входного, выходного файла, режим сортировки, а так же тип содержимого задаются при
  запуске через аргументы командной строки. Примеры запуска из командной строки для Windows:
  sort-it.exe in.txt out.txt -i -a (для целых чисел по возрастанию)
  sort-it.exe in.txt out.txt -i -d (для целых чисел по убыванию)
  sort-it.exe in.txt out.txt -s -a (для строк по возрастанию
  
 ---------------------------------------------------------------
 Решение на Java
 В консоли в папке проекта где лежит файл pom.xml выполнить следующие 2 команды:
       win/unix: mvn package
       win: mvn exec:java -D"exec.mainClass"="Solution" -D"exec.args"="arg1 arg2 arg3 arg4"
       unix: mvn exec:java -Dexec.mainClass="Solution" -Dexec.args="arg1 arg2 arg3 arg4"
       
       arg1 - путь к входному файлу
       arg2 - путь к выходному файлу
       arg3 - тип содержимого файла -i(Целые числа) -s(Строки)
       arg4 - порядок сортировки -a(увеличивающийся) -d(уменьшающийся)