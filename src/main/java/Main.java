import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String input = "ABBBAACCCCCDDDC";

        System.out.println(candyCrash(converterStringToList(input)));
    }

    private static List<Character> converterStringToList(String input) {
        char[] charArrayFromInputString = input.toCharArray();
        List<Character> listOfElementFromInput = new ArrayList<>();
        for (char aCharArrayFromInputString : charArrayFromInputString) {
            listOfElementFromInput.add(aCharArrayFromInputString);
        }

        return listOfElementFromInput;
    }

    private static String candyCrash(List<Character> listOfElementFromInput) {

        List<Character> listOfElementToDelete = new ArrayList<>();
        for (int i = 0; i < listOfElementFromInput.size() - 1; ) {
            int j = i;
            while (listOfElementFromInput.get(i).equals(listOfElementFromInput.get(j))) {
                listOfElementToDelete.add(listOfElementFromInput.get(j));
                if (j < listOfElementFromInput.size()) {
                    ++j;
                    if (j >= listOfElementFromInput.size()) {
                        break;
                    }
                }
            }
            if (listOfElementToDelete.size() >= 3) {
                int k = listOfElementToDelete.size();
                while (k != 0) {
                    listOfElementFromInput.remove(i);
                    k--;
                }
                i = 0;
                listOfElementToDelete.clear();
                candyCrash(listOfElementFromInput);
            }
            i++;
            listOfElementToDelete.clear();
        }
        return String.valueOf(listOfElementFromInput);
    }
}
