import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick{

    private Lock lock;

    public Chopstick(){
        lock = new ReentrantLock();
    }
    public void pickUp(int number){
        lock.lock();
        lock.tryLock();
        System.out.println(number+" Chopstick used");
        //System.out.println(" Chopstick used");
    }
    public void putDown(){
        lock.unlock();
    }
}

class Philosophers extends Thread  {

    private int bites = 10;
    private Chopstick left,right;
    int number = -1;
    Philosophers(Chopstick left,Chopstick right, int number){
        this.left = left;
        this.right = right;
        this.number = number;
    }

    public void eat(){
        pickUp();
        chew();
        putDown();
    }

    public void pickUp(){
        left.pickUp(this.number);
        right.pickUp(this.number);
    }

    public void chew(){

    }

    public void putDown(){
        right.putDown();
        left.putDown();

    }

    public void run(){
        for (int i =0;i<10;i++){
            eat();
        }
    }
}


public class Philosopher{

    public static void main(String args[]){
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();
        Chopstick c3 = new Chopstick();
        Philosophers p1 = new Philosophers(c1,c2,1);
        Philosophers p2 = new Philosophers(c2,c3,2);
        Philosophers p3 = new Philosophers(c3,c1,3);

        p1.start();
        p2.start();
        p3.start();

    }
}