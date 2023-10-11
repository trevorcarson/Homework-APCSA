/*
A class demonstrating some operations
using Stacks & Queues
*/

public class StacksNQueues{
   public static void queueToStack(LQueue q, LStack s){
      /*
      Transfers all of the items from q to s
      Input:
         q: a queue of Integers
         s: the stack to move them to
      Output: None
      Side Effects: q is empty and all the items have been
      moved to s
      Ex.
      q.toString() -> (front) [1, 2, 3, 4] (end)
      s.toString() -> (top) [] (bottom)
      queueToStack(q, s)
      q.toString() -> (front) [] (end)
      s.toString() -> (top) [4, 3, 2, 1] (bottom)
      */
      while(!q.isEmpty()){
         int n = (Integer) q.peek();
         s.push(n);
         q.remove();
      }
   }
   
   public static void stackToQueue(LStack s, LQueue q){
      /*
      Transfers all of the items from s to q
      Input:
         s: a stack of Integers
         q: the queue to move them to
      Output: None
      Side Effects: s is empty and all the items have been
      moved to q
      Ex.
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      q.toString() -> (front) [] (end)
      stackToQueue(s, q)
      s.toString() -> (top) [] (bottom)
      q.toString() -> (front) [1, 2, 3, 4] (end)
      */
      while(s.peek() != null){
         Object a = s.peek();
         q.add(a);
         s.pop();
      }
   }
   
   public static int sumQueue(LQueue q){
      /*
      Calculate the sum of all elements in the queue.
      At the end of the method, q should be unchanged.
      Input:
         q: a queue of Integers
      Output:
         return: the sum of all values in q
      Side Effects: none, q should be unchanged
      Ex.
      q.toString() -> (front) [1, 2, 3, 4] (end)
      sumQueue(q) -> 10
      q.toString() -> (front) [1, 2, 3, 4] (end)
      */
      int sum = 0;
      for(int i = 0; i < q.size(); i++){
         int n = (Integer) q.peek();
         sum += n;
         Object r = q.peek();
         q.remove();
         q.add(r);
      }
      return sum;
   }
   public static int sumStack(LStack s){
      /*
      Calculate the sum of all of the elements in s.
      At the end of the method s should be unchanged.
      Input:
         s: a stack of integers
      Output:
         return: the sum of the elements in s
      Side Effects: none, s should be unchanged at the 
      end of the method.
      Ex.
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      sumStack(s) -> 10
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      */
      int sum = 0;
      int ogsize = s.size();
      LQueue trevor = new LQueue();
      for(int i = 0; i < ogsize; i++){
         int n = (Integer) s.pop();
         sum += n;
         trevor.add(n);
      }
      queueToStack(trevor,s);
      stackToQueue(s,trevor);
      queueToStack(trevor,s);
      return sum;
   }
   public static boolean isPalindrome(LQueue q){
      boolean answer = true;
      if(q.size() == 0) return answer;
      LStack s = new LStack();
      int size = q.size()/2;
      for(int i = 0; i < size; i++){
         Object a = q.peek();
         q.remove();
         q.add(a);
         s.push(a);
      }
      if(q.size()%2 != 0){
         Object a = q.peek();
         q.remove();
         q.add(a);
      }
      for(int i = 0; i < size; i++){
         if((Integer) q.peek() != (Integer) s.peek()) answer = false;
         s.pop();
         Object a = q.peek();
         q.remove();
         q.add(a);
      }
      return answer;  
   }
   public static boolean isSorted(LStack s){
      LQueue q = new LQueue();
      boolean answer = true;
      if(s.size() == 1) return answer;
      stackToQueue(s,q);
      for(int i = 0; i <= q.size(); i++){
         int a = (Integer) q.remove();
         int b = (Integer) q.peek();
         if(a > b) answer = false;
         s.push(a);
      }
      s.push(q.remove());
      stackToQueue(s,q);
      queueToStack(q,s);
      return answer;
   }
}