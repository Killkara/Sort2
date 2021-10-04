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
        for (int i = 0; i < name.length-1; i++)
            name[i] = in.nextLine();
        for (int i = 0; i < name.length; i++)
            id[i] = i;
    }

    public int[] getId() {
        return id;
    }

    @Override
    public void QuickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = id[(id[0] + id[id.length]) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (id[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (id[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = id[leftMarker];
                    id[leftMarker] = id[rightMarker];
                    id[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            QuickSort(leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            QuickSort(leftBorder, rightMarker);
        }
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
        a.QuickSort(a.getId()[0],a.getId()[a.getId().length]);
        System.out.println(a);
    }
}
