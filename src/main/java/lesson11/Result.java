package lesson11;

public class Result {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {
                {"19", "21", "32", "43"},
                {"54", "65", "76", "87"},
                {"98", "10", "10", "11"},
                {"12", "13", "14", "15"}
        };

        try {
            int correctArray = correctArray(array);
            System.out.println("Cумма элементов массива " + correctArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int correctArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int size = 4;

        if (array.length != size) {
            throw new MyArraySizeException("Неправильный формат массива, нужен 4х4");
        }

        for (String[] column : array) {
            if (column.length != size) {
                throw new MyArraySizeException("Неправильный формат массива, нужен 4х4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.valueOf(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
