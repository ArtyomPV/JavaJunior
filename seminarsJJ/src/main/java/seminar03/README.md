<h1 style="color:darkgreen">Семинар 02 Java Junior</h1>
<h3>Задача 1 </h3>
<hr>
<ul>
    <li>Создайте класс UserData с полями String name, int age, transient String password.</li>
    <li>Поле password должно быть отмечено ключевым словом transient.</li>
    <li>Реализуйте интерфейс Serializable в вашем классе.</li>
    <li>В методе main создайте экземпляр класса UserData и инициализируйте его данными.</li>
    <li>Сериализуйте этот объект в файл, используя ObjectOutputStream в сочетании с FileOutputStream</li>
</ul>
<h3>Задача 2</h3>
<hr>
<ul>
    <li>Десериализуйте объект из ранее созданного файла обратно в объект Java, используя ObjectInputStream в сочетании с FileInputStream.</li>
    <li>Выведите данные десериализованного объекта UserData.</li>
    <li>Сравните данные до сериализации и после десериализации, особенно обратите внимание на поле, помеченное как transient.</li>
    <li>Обсудите, почему это поле не было сохранено после десериализации.</li>
</ul>