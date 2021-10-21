public class MyArrayDataException extends Exception {

    public MyArrayDataException(String msg) {
        super("Неверное значение в ячейке.\n" + " " + msg);
    }
}
