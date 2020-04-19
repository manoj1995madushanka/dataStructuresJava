package Queue;

public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this(100);
    }
    public BasicQueue(int size){
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }

    public int size(){
        if(front== -1 && end == -1){
            return 0;
        }
        else
        {
            return end-front+1;
        }
    }

    public void enQueue(X item){
        if((end+1)%data.length==front){
            throw new IllegalStateException("The queue is ull");
        }
        else if(size()==0){
            front++;
            end++;
            data[end] = item;
        }
        else{
            end++;
            data[end] = item;
        }
    }

    public X deQueue(){
        X item =null;
        if(size() ==0){
            throw  new IllegalStateException("queue is also zero can't dequeue");
        }

        else if(front == end){
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        else
        {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public X access(int position){
        if(size()==0||position>size()){
            throw new IllegalArgumentException("queue is empty or position is greeter than zero");
        }
        int trueIndex = 0;
        for(int i=front;i<end;i++){
            if(trueIndex == position)
            {
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("cloud not get queue item on that position");
    }

    public boolean contains(X item){
        boolean found = false;
        // if size is zero
        if(size()==0){
            return found;
        }
        for(int i=front;i<end;i++){
            if(data[i].equals(item)){
                found=true;
                break;
            }
        }
        return found;
    }


}
