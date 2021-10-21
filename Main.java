public class Main {
    public static void main(String[] args) {
        String[][] stringArrCorrect = new String[][]{
                {"10", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "32", "33"},
                {"40", "41", "42", "43"}};
        String[][] stringArrIncorrect1 = new String[][]{
                {"1u", "11", "12", "13"},
                {"20", "21", "22", "23"},
                {"30", "31", "**", "33"},
                {"40", "41", "42", "43"}};
        String[][] stringArrIncorrect2 = new String[][]{
                {"11", "12", "13"},
                {"&", "21", "22", "23"},
                {"30", "31", "32", "33"}};

        //проброс исключений
        try {
            System.out.println("Сумма элементов массива равна " + strTransformation(stringArrCorrect));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Сумма элементов массива равна " + strTransformation(stringArrIncorrect1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Сумма элементов массива равна " + strTransformation(stringArrIncorrect2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    //преобразование в int
    public static int strTransformation(String[][] strArray)
            throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (4 != strArray.length) throw new MyArraySizeException();
        for (int i = 0; i < strArray.length; i++) {
            if (4 != strArray[i].length) throw new MyArraySizeException();
            for (int k = 0; k < strArray[i].length; k++) {

                try {
                    sum += Integer.parseInt(strArray[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке [%d][%d] неверное значение %s.", i, k, strArray[i][k]));
                }

            }
        }

        return sum;
    }



}
