//        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
//        подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
//        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//        3 В методе main() вызвать полученный метод, обработать возможные исключения
//        MyArraySizeException и MyArrayDataException и вывести результат расчета.


public class Main {


    public static void main(String[] args) {
        String[][] array1 = new String [4][4];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                array1[i][j] = String.format("%d",i);
                System.out.print(array1[i][j]);
            }
        }

        try {
            System.out.println(String.format("результат сложения - %d", arrayStringToInt(array1)));}
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static int arrayStringToInt(String[][] array) throws MyArrayDataException, MyArraySizeException{
        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Размер массива должен быть 4х4");
       }

        int res = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    res += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(String.format("\nэлемент с индексом ['%d'],['%d'] не цифра", i,j));
                }
            }
        }
        return res;
    }
}
