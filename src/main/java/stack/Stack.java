package stack;

public class Stack<X> {
    private X[] data;
    private int stackPointer;

    public Stack(){
        data = (X[]) new Object[100];
        stackPointer =0;
    }

    // ++x means first increase the value of x by 1 and then use it
    // whereas x++ means first use the value of x and then increment it's value by 1
    public void push(X newItem){
        data[stackPointer++] = newItem;
    }

    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("No more items on the stack");
        }
        return data[--stackPointer];
    }

    public boolean contains(X item){
        boolean found = false;
        for (int i = 0 ; i<stackPointer;i++){
            if(data[i] == item){
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item){
        while (stackPointer >0){
            X temItem = pop();
            if (item.equals(temItem)){
                return temItem;
            }
        }
        throw new IllegalArgumentException("did not found that item");
    }

    public int size(){
        return stackPointer;
    }
}
