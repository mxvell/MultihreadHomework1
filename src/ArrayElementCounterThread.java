import java.util.Arrays;

public class ArrayElementCounterThread  implements Runnable {
    private int startIndex;
    private int endIndex;
    private int [] array;
    private long resultOfRunMethod;

    public ArrayElementCounterThread(int startIndex, int endIndex, int[] array) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = startIndex; i < endIndex; i++){
            sum += array[i];
        }
        resultOfRunMethod = sum;
    }

    public long getResultOfRunMethod() {
        return resultOfRunMethod;
    }

    @Override
    public String toString() {
        return "ArrayElementCounterThread{" +
                "startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                '}';
    }
}

