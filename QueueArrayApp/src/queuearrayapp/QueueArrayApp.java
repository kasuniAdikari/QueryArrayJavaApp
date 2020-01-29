/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearrayapp;

/**
 *
 * @author 174004M
 */
public class QueueArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QueueArray x=new QueueArray(5);
        x.display();
        x.EnQueue(7);
         x.EnQueue(3);
          x.EnQueue(9);
           x.EnQueue(1);
            x.EnQueue(27);
            x.display();
            x.EnQueue(8);
            try{
            x.Dequeue();
            x.display();
             int peekValue=x.peek();
            System.out.println("peek = "+peekValue);
            }catch(Exception e){
            System.out.println(e);
            }
            
           
        
    }

}

class QueueArray {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int size) {

        this.queArray = new int[size];
        this.maxSize = size;
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;

    }

    public boolean isEmpty() {
        return this.nItems == 0;
    }

    public boolean isFull() {
        return this.nItems == this.maxSize;
    }

    public int size() { //no. of elements currently in the array
        return this.nItems;
    }

    public void EnQueue(int value) {
        if (isFull()) {
            System.out.println("queue is full. cannot insert");
            return;
        }
        if (this.rear == this.maxSize - 1) {
            this.rear = 0;
        } else {
            this.rear++;
        }

        this.queArray[rear] = value;
        this.nItems++;
        System.out.println("value inserted");

    }
//assuming front is not at the end of the array

    public int Dequeue() throws Exception {  //to return the value removed  
        if (isEmpty()) {
            throw new Exception("Queue is empty. cannot remove");
        }

        int temp = this.queArray[front];  //to get the removed element before front updated
        if (this.front == this.maxSize - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
        this.nItems--;
        return temp;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty. cannot get peek/front");
        }
        return this.queArray[this.front];
    }
//display() -->method 1
    public void display() {
        if(isEmpty()){
        System.out.println("Que is empty nothing to print");
        return;
        }
        int i = this.front;
        while (i != this.rear) {

            System.out.print("Queue Array is= " + queArray[i] + " ");
            if (i == this.maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.print(queArray[rear] + " ");
        System.out.println();
    }

}

//if the array is full and we want to replace/errase the front values and insert new values 
/*public void EnQueue(int value){
    if(this.rear==this.maxSize-1){
        this.rear=0;
    }else{
        this.rear++;
    }
        
    this.queArray[rear]=value;
    this.nItems++;
    System.out.println("value inserted");
    
    }*/

//display()  -->method 2

 /*
public void display() {
        int i = this.front;
        while (true) {

            System.out.print("Queue Array is= " + queArray[i] + " ");
if(i==this.rear){
break;
}
            if (i == this.maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }
       // System.out.print(queArray[rear]+" ");
        System.out.println();
    }
 */
