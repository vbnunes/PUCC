public class ArrayCalc extends Thread{
    private int[] array;
    private int total;

    public ArrayCalc(int[] arr){
        this.array = arr;
    }

    public void somaInteiros(){
        for(int i=0;i<array.length;i++){
            total += array[i];
        }
        Main.total += total;
    }

    public void run(){
        this.somaInteiros();
    }
}
