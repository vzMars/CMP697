import java.util.ArrayList;

public class Statistics {
    private ArrayList<Integer> vals;
    public Statistics() {
        this.vals = new ArrayList<>();
    }

    public Statistics(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    // Add value to the list
    public void add(int val) {
        this.vals.add(val);
    }

    // Add multiple values to the list
    public void add(ArrayList<Integer> vals) {
        for (int i = 0 ; i < vals.size(); i++) {
            this.vals.add(vals.get(i));
        }
    }

    // Get average of values in the list
    public double getAverage() {
        if (this.vals.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < this.vals.size(); i++) {
            sum += this.vals.get(i);
        }

        return sum / this.vals.size();
    }

    // Get the maximum value in the list
    public int getMaximum() {
        int max = this.vals.get(0);

        for (int i = 0; i < this.vals.size(); i++) {
            if (max < this.vals.get(i)) {
                max = this.vals.get(i);
            }
        }

        return max;
    }

    // Get the minimum value in the list
    public int getMinimum() {
        int min = this.vals.get(0);

        for (int i = 0; i < this.vals.size(); i++) {
            if (min > this.vals.get(i)) {
                min = this.vals.get(i);
            }
        }

        return min;
    }

    // Sorts the values in the list
    private void sortArray(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Get the median value in the list
    public double getMedian() {
        ArrayList<Integer> sorted = new ArrayList<>(this.vals);

        this.sortArray(sorted);
        if (sorted.size() % 2 == 0) {
            int middle1 = sorted.get(sorted.size() / 2);
            int middle2 = sorted.get(sorted.size() / 2 - 1);

            return (double) (middle1 + middle2) / 2;
        } else {
            return sorted.get(sorted.size() / 2);
        }
    }

    // Get the range of values in the list
    public int getRange() {
        return this.getMaximum() - this.getMinimum();
    }

    // Clear the list
    public void clear() {
        this.vals = new ArrayList<>();
    }

    public static void main(String[] args) {
//        ArrayList<Integer> values = new ArrayList<>();
//        values.add(10);
//        values.add(2);
//        values.add(38);
//        values.add(28);
//        values.add(35);
//
//        Statistics statistics = new Statistics(values);
//        statistics.add(5);
//        System.out.println(statistics.vals);
//        statistics.clear();
//        System.out.println("Average: " + statistics.getAverage());
//        System.out.println("Max: " + statistics.getMaximum());
//        System.out.println("Min: " + statistics.getMinimum());
//        System.out.println("Median: " + statistics.getMedian());
//        System.out.println("Range: " + statistics.getRange());
    }

}
