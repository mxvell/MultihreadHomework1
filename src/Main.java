public class Main {
    public static void main(String[] args) {
        int[] array = new int[200000000];
        int cores = 8;
        long before = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*9);
        }
        long after = System.currentTimeMillis();
        System.out.println("sum main " + sumMain(array));
        System.out.println("time sum main " + (after - before));
        int step = array.length / cores;
        long sum = 0;
        for (int i = 0; i <= cores - 1; i++){
            int start = step * i;
            int end =  start + step;
            ArrayElementCounterThread thread = new ArrayElementCounterThread(start, end, array);
            System.out.println(thread);
            thread.run();
            System.out.println(thread.getResultOfRunMethod());
            sum += thread.getResultOfRunMethod();
        }
        System.out.println("sum thread " + sum);



    }
    public static int sumMain(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {

            sum += array[i];
        }
        return sum;

    }

}