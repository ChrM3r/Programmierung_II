package ESA_ALE.ALE_2;


import java.util.Arrays;

public class MeineArrayList<E> {
    private E[] list;
    private int size;
    private int capacity;
    private int increment;

    /**
     * constructs a MeineArrayList-Object with initial capacity c
     * and increment inc
     *
     * @param c   the initial capacity
     * @param inc the number of positions that will be added
     *            when the list is made bigger
     */
    public MeineArrayList(int c, int inc) {
        capacity = c;
        list = (E[]) new Object[c];
        size = 0;
        increment = inc;

    }
    protected boolean add(E e){

        E[] tempArray = Arrays.copyOf(this.list, this.size + 1);
        tempArray[size] = e;
        this.list = Arrays.copyOf(tempArray, this.size + 1);

        this.size++;
        if (this.capacity < this.size) this.capacity++;

        return true;
    }

    protected boolean remove(int index){

        boolean rue = false;

        if (!(index > list.length - 1 && index < 0 ) && size > 0){
            E[] tempArray = (E[]) new Object[size - 1];
            System.arraycopy(list, index, tempArray,index - 1, capacity - 1);
            for (int i = 0; i < index; i++) {
                System.arraycopy(list, i, tempArray,i, size - 1);
            }

            for (int i = index + 1; i < tempArray.length; i++){
                System.arraycopy(list, index + 1, tempArray, index, size - 1);
            }
            list = Arrays.copyOf(tempArray, size - 1);
            size--;
            rue = true;
        }
        return rue;
    }
    protected void clear(){

        E[] tempArray = (E[]) new Object[0];
        list = tempArray;
    }
    protected int size(){

        int zaehler = 0;
        for (E e: list) zaehler++;
        return zaehler;
    }

    public String toString(){
        return Arrays.toString(list);
    }
}