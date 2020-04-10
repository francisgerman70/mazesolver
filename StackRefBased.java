public class StackRefBased<T> implements Stack<T> {

    public int count;
    StackNode<T> top;

    public StackRefBased() {
      top = null;


    count = 0;

}
    public int size() {
        return count;

    }


    public boolean isEmpty() {
      //boolean answer = false;
      //for(T data : temp){
        //if (top == null){
          //answer = true;
        //}

      //}
        //return answer;
        return top == null;
    }


    public void push(T data) {
      //StackNode<T> temp = new StackNode<T> (data, top);
      //top = temp;
      StackNode<T> temp = top;
        top = new StackNode<T>(data);
        top.data = data;
        top.next = temp;




      count++;

    }


    public T pop() throws StackEmptyException {
      //StackNode<T> oldtop = top;
      //if (count==0){
        //return null;
      //}
      //top = top.getNext();

      //count--;
      //return oldtop.getValue();
      if (isEmpty()) throw new StackEmptyException("Stack underflow");

        StackNode<T> oldtop = top;
        top = top.next;
        count--;
        return oldtop.getValue();

}

    public T peek() throws StackEmptyException {
      //if (count == 0){
        //return null;
      //}
        //return top.getValue();
        if (isEmpty()) throw new StackEmptyException("Stack underflow");
        return top.getValue();
    }


    public void makeEmpty() {
      count = 0;
      top = null;
    }


    public String toString() {
      String answer = "";
      StackRefBased<T> stack = new StackRefBased<T>();
      StackNode<T> temp = null;
      StackNode<T> curr = null;

    	for(temp = top; temp != null; temp = temp.next) {
    		stack.push(temp.getValue());
    	}
      if (stack.top != null) {
              for(curr = stack.top; curr != null; curr = curr.next) {
                  answer += curr.data + " ";
              }
          }

        return answer;
    }

}
