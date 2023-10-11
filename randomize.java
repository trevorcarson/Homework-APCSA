public class randomize{
   private int[] array;   //where the items in the list are stored
   private int size;      //how many items are in the list

   static int defaultCapacity = 10; //default storage capacity
   static int resizeFactor = 2; // resize factor

   public randomize(){
      /*Constructor. Initializes a new empty IntList object with 
      the given initial capacity.
      Inputs:
         int capacity: the initial capacity of this.array
      Output:
         this: a new empty IntList with the given capacity
      Ex.
      IntList l = new IntList(5);
      l is now an empty list with room for 5 initial values
      */
      this.array = new int[defaultCapacity];
      this.size = 0;
   }
   public void add(int value){
      /*Add the value to the end of this list.
      Input:
         int value: the value to be added to this list
         this: the IntList we are adding the value to
      Output: none
      Side Effect: value is now the last item in the list
      Ex.
      IntList l = new IntList(5);
      l.array -> [0, 0, 0, 0, 0]
      l.size -> 0
      l.add(1);
      l.array -> [1, 0, 0, 0, 0]
      l.size  -> 1
      l.add(2);
      l.array -> [1, 2, 0, 0, 0]
      l.size  -> 2
      */
      if(this.size == this.array.length){
         int [] clone = new int[this.array.length];
         for(int i = 0; i<this.array.length; i++){
            clone[i] = this.array[i];
         }
         this.array = new int[this.array.length*2];
         for(int i = 0; i < clone.length; i++){
            this.array[i] = clone[i];
         }
      }
      this.array[this.size] = value;
      this.size++;
   }
   public void swap(int index1, int index2){
      /*Swap the values at index1 and index2.
      Both indices must be in the list.
      Input:
         int index1: the index of the first value
         int index2: the index of the second value
         this: an IntList object
      Output: None
      Side Effects: the values at index1 and index2
      have swapped positions
      Ex.
      IntList l = new IntList()
      l.add(7);
      l.add(3);
      l.add(5);
      l.toString() -> [7, 3, 5]
      l.swap(0, 2);
      l.toString() -> [5, 3, 7]
      */
      int a = this.array[index2];
      int b = this.array[index1];
      this.array[index1] = a;
      this.array[index2] = b;
   }
   public void randomN(int n){
      /*
      randomize n elements
      Input:
         N, the size of the list to randomize
      Output:
         None
      Side Effects:
         The List 0 -> N has been randomized
      */
      for(int i = 1; i <= n; i++){
         this.add(i);
      }
      for(int i = 0; i <= n*2; i++){
         int rand1 = (int)((Math.random()*n));
         int rand2 = (int)((Math.random()*n));
         this.swap(rand1,rand2);
      }
   }    
   public String toString(){
      /*Return a String representation of this list.
      Input:
         this: an IntList object
      Output:
         return: a String representing this list
      Ex.
      IntList l = new IntList();
      l.toString() -> "[]"
      l.add(3);
      l.toString() -> "[3]"
      l.add(-14);
      l.toString() -> "[3, -14]"
      l.add(782);
      l.toString() -> "[3, -14, 782]"
      */
      String a = "";
      for(int i = 0; i<this.size; i++){
         a += this.array[i];
         if(i != this.size-1){
            a+=", ";
         }
      }
      return a;
   }
   public static void main(String [] args){
      /*Main method:
      1) Randomize a list that is N long
      2) Pipe out the randomized IntList to StdOut
      The other programs will be able to read from StdOut
      */
      int n = Integer.parseInt(args[0]);
      randomize trevor = new randomize();
      trevor.randomN(n);
      StdOut.print(trevor.toString());
   }
}