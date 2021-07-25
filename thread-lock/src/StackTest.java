class Stack {

    class StackNode{
        int data;
        StackNode NextNode = null;
        StackNode(int data){
            this.data = data;
        }
    }

    StackNode currnetNode;

    void push(int data){
        StackNode newNode = new StackNode(data);
        newNode.NextNode = this.currnetNode;
        this.currnetNode = newNode;

    }

    int pop() throws Exception {
        if (!isEmpty()){
            int data = this.currnetNode.data;
            currnetNode  = currnetNode.NextNode;

            return data;
        }else{
            throw new Exception();
        }
    }

    int peek(){
        if (!isEmpty()){
            return this.currnetNode.data;
        }else{
            return -1;
        }

    }

    boolean isEmpty(){
        if (this.currnetNode == null){
            return true;
        }else{
            return false;
        }
    }
}





public class StackTest {
    public static void main(String atgs[]){
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);


        try{
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());


            System.out.println(stack.isEmpty());
            stack.push(4);
            System.out.println(stack.peek());
            System.out.println(stack.isEmpty());
            System.out.println(stack.pop());


        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}