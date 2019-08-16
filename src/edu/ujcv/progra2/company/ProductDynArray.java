package edu.ujcv.progra2.company;

public class ProductDynArray implements Lista {
    private Producto[] items;
    private int size;

    public ProductDynArray() {
        this.items = new Producto[3];
        size = 0;
    }

    public Producto getProduct(int index){
        return items[index];
    }

    public int getSize() {
        return size;
    }

    @Override
    public Object getItem(int index) {
        return getProduct(index);
    }

    /**
     *  Method : add
     *  adds the producto to the items array.
     *
     * @param product: the product to add.
     */
    public void add(Producto product){

        if(size >= items.length){
            grow();
        }
        items[size] = product;
        size++;

    }

    private void grow() {
        Producto[] temp = new Producto[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * Method: remove
     *  removes an object at a the specified index
     *  if posible returns false if it fails.
     * @param index: index of the object to be removed.
     * @return true if it removes the item successfully.
     */
    public Producto remove(int index){
        if(index >= size)
            return null;
        Producto retval = items[index];

        for (int i = index + 1; i < size ; i++) {
            items[i-1] = items[i];
        }
        size--;
        return retval;
    }

    @Override
    public void add(Object data) {
        this.add((Producto) data);
    }

    public boolean isEmpty(){

        if(size == 0)
            return true;
        return false;
    }

}
