import java.util.List;

public class BinarySearch {
    private List<Integer> listOfUnits;

    public BinarySearch(List<Integer> listOfUnits) {
        this.listOfUnits = listOfUnits;
    }

    public int indexOf(int unit) throws ValueNotFoundException {
        return dichotomicSearch(listOfUnits, unit);
    }

    private int dichotomicSearch(List<Integer> list, int unit) throws ValueNotFoundException {
        if(list.size() == 0) {
            throw new ValueNotFoundException("Value not in array");
        }

        int middle = list.size() /2;

        if(list.get(middle) == unit) {
            return middle;
        }

        if(list.get(middle) > unit) {
            return dichotomicSearch(list.subList(0, middle), unit);
        } else {
            middle += 1;
            return dichotomicSearch(list.subList(middle, list.size()), unit) + middle;
        }
    }
}