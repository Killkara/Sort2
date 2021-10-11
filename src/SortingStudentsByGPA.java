import java.util.Arrays;
import java.util.Scanner;

public class SortingStudentsByGPA implements Comparator {
    private String[] name;
    private int[] id;

    SortingStudentsByGPA() {
        System.out.println("Ввод кол-ва студентов");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        name = new String[n];
        id = new int[n];
        for (int i = 0; i < name.length - 1; i++)
            name[i] = in.nextLine();
        for (int i = 0; i < name.length; i++)
            id[i] = i;
    }

    public int[] getId() {
        return id;
    }

    @Override
    public void QuickSort(int low, int high) {
        if (id.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = id[middle];
        int i = low, j = high;
        while (i <= j) {
            while (id[i] < opora) {
                i++;
            }
            while (id[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = id[i];
                id[i] = id[j];
                id[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            QuickSort(low, j);
        if (high > i)
            QuickSort(i, high);
    }

    @Override
    public String toString() {
        return "SortingStudentsByGPA{" +
                "name=" + Arrays.toString(name) +
                ", id=" + Arrays.toString(id) +
                '}';
    }

    public static void main(String[] args) {
        SortingStudentsByGPA a = new SortingStudentsByGPA();
        a.QuickSort(a.getId()[0], a.getId()[a.getId().length]);
        System.out.println(a);
    }
}
