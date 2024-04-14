public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        boolean a = (name.length() >= 3) && (name.length() <= 19);
        boolean b = name.contains(" ");
        boolean c = name.trim().equals(name);

        if (a && b && c) {
            System.out.println("Строка соответствует требованиям");
        }
        return a && b && c;
    }

}