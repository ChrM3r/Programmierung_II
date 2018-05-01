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

        E[] tempArray = Arrays.copyOf(list, size + 1);
        tempArray[size] = e;
        list = Arrays.copyOf(tempArray, size + 1);

        this.size++;
        if (capacity < size) capacity++;

        return true;
    }

    protected boolean remove(int index){

        boolean rue = false;

        if (index < size  && index > -1 && size > 0) {

            E[] tempArray = (E[]) new Object[size - 1];

            System.arraycopy(list, 0, tempArray, 0, index);
            if (!(index + 1 >= size))
            System.arraycopy(list, index + 1, tempArray, index, tempArray.length - index);

            list = tempArray;
            rue = true;
        }

        size--;

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

    public static void main(String args[]){

    }
}