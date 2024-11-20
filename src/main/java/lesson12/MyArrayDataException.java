package lesson12;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int colum) {
        super("Неверный формат в ячейке [" + row + "][" + colum + "]");
    }
}