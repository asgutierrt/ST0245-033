package Taller7;

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada

public class LinkedListMauricio {
    private Node first;
    private int size;
    public Node next;

    public LinkedListMauricio()
    {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     *
     * @return el tamaño actual de la lista
     */
    public int size()
    {
       return size;
    }

    /**
     *
     * @param data se inserta en la primera posición
     */
    public  void addFirst(int data){
        Node entrante = new Node(data);
        if(first==null){
            first=entrante;
        }else{
            entrante.next=first;
            first=entrante;
        }
        size++;
    }

    /**
     *
     * @param data dato para insertar
     * @param index índice para insertar
     */
    public void insert(int data, int index)
    {
        if(index>=0 && index<size+1){
            Node entrante = new Node(data);
            if(first==null || index==0) {
                addFirst(data);
            } else
                {
                    Node tmp = getNode(index-1);
                    entrante.next = tmp.next;
                    tmp.next = entrante;
                    size++;
                }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     *
     * @param data se inserta al final de la lista
     */
    public void insert(int data){
        Node entrante = new Node(data);
        Node tmp= getNode(size-1);
        tmp.next=entrante;
        size++;
    }

    /**
     *
     * @param index indice del dato para borrar
     */
    public void remove(int index)
    {
        if(first!=null && index>=0 && index <size-1){
            if(index==0){
                removeFirst();
            }else{
                Node eliminado = getNode(index- 1);
                Node tmp= eliminado.next;
                eliminado.next = tmp.next;
                tmp.next = null;
                size--;
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeFirst(){
        if(first!=null){
            Node tmp = first;
            first = first.next;
            tmp= null;
            size--;
        }
    }

    /**
     *
     * @param data
     * @return verifica si está el dato
     */
    public boolean contains(int data)
    {
        Node tmp = first;
        for (int i=0;i<size;i++){
            if(tmp.data==data) {
                return true;
            }
            tmp=tmp.next;
        }
        return false;
    }

}
