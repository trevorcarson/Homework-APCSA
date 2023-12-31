/*
A minimal stack implementation using linked nodes as storage
*/

public class LStack{
   private LNode top; //the top-most item in the stack
   
   public LStack(){
      /*
      Constructor. Initialize an empty stack.
      */
      this.top = null;
   }
   public Object peek(){
      /*
      Peek at the current item on top of the stack.
      Does not remove that item from the stack.
      Returns null if the stack is empty.
      Inputs:
         this: a stack you want to peek at
      Outputs:
         return: the item currently on top of the stack,
                 or null if the stack is empty
      Side Effects: None, the stack remains unchanged
      Ex.
      LStack s = new LStack()
      s.peek() -> null
      s.push(1)
      s.peek() -> 1
      s.push(2)
      s.peek() -> 2
      s.push(3)
      s.peek() -> 3
      */
      if(this.top == null) return null;
      else{
         return this.top.getData();
      }
   }
   public void push(Object o){
      /*
      Push data onto the top of the stack.
      Inputs:
         this: the stack you want to push onto
         o: the data to push onto the stack
      Outputs: None
      Side Effects: this stack now has o on top of it
      Ex.
      LStack s = new LStack()
      s.peek() -> null
      s.push(1)
      s.peek() -> 1
      s.push(2)
      s.peek() -> 2
      s.push(3)
      s.peek() -> 3
      */
      LNode newNode = new LNode(o);
      if(this.top == null){
         this.top = newNode;
      }
      else{
         newNode.setNext(this.top);
         this.top = newNode;
      }
   }
   public Object pop(){
      /*
      Remove and return the item on top of the stack.
      Return null if the stack is empty.
      Inputs:
         this: the stack you want to pop from
      Outputs:
         return: the item that was on top of the stack,
                 or null if the stack was empty
      Side Effects: the returned item is no longer on top of the stack
      Ex.
      LStack s = new LStack()
      s.pop() -> null
      s.push(1)
      s.pop() -> 1
      s.pop() -> null
      s.push(1)
      s.push(2)
      s.pop() -> 2
      s.pop() -> 1
      s.pop() -> null
      s.push(1)
      s.push(2)
      s.push(3)
      s.pop() -> 3
      s.pop() -> 2
      s.pop() -> 1
      s.pop() -> null
      */
      Object t = this.peek();
      if(this.top == null) return null;
      else{
         this.top = this.top.getNext();
      }
      return t;
   }
   public boolean isEmpty(){
      /*
      Check if this stack has no items in it.
      Inputs:
         this: the stack you are checking
      Outputs:
         return: true if this stack is empty,
                 false if not
      Side Effects: None, the stack is unchanged
      Ex.
      LStack s = new LStack()
      s.isEmpty() -> true
      s.push(1)
      s.isEmpty() -> false
      s.pop()
      s.isEmpty() -> true
      */
      if(this.top == null) return true;
      else return false;
   }
   public int size(){
      /*
      Check how many items are currently in the stack.
      Inputs:
         this: the stack you want to check
      Outputs:
         return: the number of items in this stack
      Side Effects: None, the stack is unchanged
      Ex.
      LStack s = new LStack()
      s.size() -> 0
      s.push(1)
      s.size() -> 1
      s.pop()
      s.size() -> 0
      s.push(1)
      s.push(2)
      s.size() -> 2
      s.pop()
      s.size() -> 1
      s.pop()
      s.size() -> 0
      */
      LNode count = this.top;
      int i = 0;
      while(count != null){
         count = count.getNext();
         i++;
      }
      return i;
   }
}

      