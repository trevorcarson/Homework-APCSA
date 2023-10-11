public class sort{
   public static void insertionSort(IntList unsorted){
      /*Sort the contents of this list in ascending order
      Input:
         this: an IntList object
      Output: None
      Side Effects: this list is now sorted in ascending order
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      l.toString() -> [4, -1, 5, 2]
      l.insertionSort();
      l.toString() -> [-1, 2, 4, 5]
      */
      for(int i = 0; i < unsorted.size; i++){
         int sortedIndex = i-1;
         while((sortedIndex >= 0) && (unsorted.array[sortedIndex+1] < unsorted.array[sortedIndex])){
            unsorted.swap(sortedIndex+1,sortedIndex);
            StdOut.println(unsorted);
            sortedIndex--;
         }
      }
   }
   public static void bubbleSort(IntList unsorted){
      /*sort given list in ascending order using bubble sort.
      Print out (to StdOut) what list looks like after each step
      Input:
         this: an IntList object
      Output: None
      Side Effects: this list is now sorted in ascending order
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      l.toString() -> [4, -1, 5, 2]
      l.bubbleSort();
      l.toString() -> [-1, 2, 4, 5]
      */
      for(int i = 0; i < unsorted.size - 1; i++){
         for(int j = 0; j < unsorted.size - i - 1; j++){
            if(unsorted.array[j] > unsorted.array[j+1]){
               unsorted.swap(j,j+1);
               StdOut.println(unsorted);
            }
         }
      }
   }
   public static void selectionSort(IntList unsorted){
      /*Sort the contents of this list in ascending order
      Input:
         this: an IntList object
      Output: none
      Side Effects: the contents of this list are now sorted in 
                    ascending order
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      l.toString() -> [4, -1, 5, 2]
      l.selectionSort();
      l.toString() -> [-1, 2, 4, 5]
      */
      int counter = 0;
      int smallestNumber = 0;
      int numberIndex = 0;
      while(counter < unsorted.size){
         for(int i = counter; i < unsorted.size; i++){
            if(i == counter){
               smallestNumber = unsorted.array[i];
               numberIndex = i;
            }
            else if(unsorted.array[i] < smallestNumber){
               smallestNumber = unsorted.array[i];
               numberIndex = i;
            }
         }
         unsorted.swap(counter,numberIndex);
         counter++;
         StdOut.println(unsorted);
      }
   }
   public static void main(String [] args){
      //load list from StdIn
      IntList l = new IntList();
      String line = StdIn.readLine();
      String[] tokens = line.split(", ");
      for(int i = 0; i < tokens.length; i++){
         int num = Integer.parseInt(tokens[i]);
         l.add(num);
      }
      //Sort the list using helper:
      selectionSort(l);
      //insertionSort(l);
      //bubbleSort(l);
   }
}
      