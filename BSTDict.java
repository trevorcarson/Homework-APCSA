/*
A Dictionary implemented using a Binary Search Tree
*/

public class BSTDict{
   private BTNode root; //the root of the BST
   
   public BSTDict(){
      /*Constructor. Make a new, empty BST*/
      this.root = null; //start with an empty tree
   }         

   public String toString(){
      /*Return a String showing the 1D dict representation*/
      if(this.root == null){//special case for empty tree
         return "{}";
      }
      else{
         String s = toStringHelper(this.root); //toString whole tree
         String sNoComma = s.substring(2, s.length()); //cut off first comma
         return "{" + sNoComma + "}";
      }
   }
   
   public static String toStringHelper(BTNode n){
      /*Return a String representing the contents of the sub-tree
      rooted at n in left-middle-right order*/
      String s = "";   
      //toString() the left tree
      if(n.hasLeft()){
         s += toStringHelper(n.getLeft());
      }
      //now my contents
      s += ", " + n.getData().toString();
      //toString() the right tree
      if(n.hasRight()){
         s += toStringHelper(n.getRight());
      }
      //return final String
      return s;
   }
   
   public String print2D(){
      /*Return a String showing the 2D tree structure of this dict*/
      return this.root.print2D();
   }
   
   
   /*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
               WRITE YOUR CODE ABOVE THIS LINE
   --------------------------------------------------------------
   Ignore the stuff below here. It is just code to make your life
   easier, but it is not important for the library to work. You
   should not be using any of these methods in your code (except
   to test your code).
   ------------------------------------------------------------*/
   
   private static BTNode makeKVNode(String key, Object value){
      /*Make a new BTNode containing a KVPair of key and value*/
      KVPair kv = new KVPair(key, value);
      BTNode n = new BTNode(kv);
      return n;
   }
   
   public static BTNode makeSubTree1(){
      /*Return a pre-made sub-tree for quick testing*/
      BTNode n1 = makeKVNode("f", 0);
      
      BTNode n2 = makeKVNode("d", 1);
      BTNode n3 = makeKVNode("h", 2);
      n1.setLeft(n2);
      n1.setRight(n3);
      
      BTNode n4 = makeKVNode("c", 3);
      BTNode n5 = makeKVNode("e", 4);
      n2.setLeft(n4);
      n2.setRight(n5);
      BTNode n6 = makeKVNode("g", 5);
      BTNode n7 = makeKVNode("i", 6);
      n3.setLeft(n6);
      n3.setRight(n7);
      
      return n1;
   }
   
   public static BSTDict makeBSTDict1(){
      /*Return a pre-made BSTDict for quick testing*/
      BSTDict d = new BSTDict();
      d.root = makeSubTree1();
      return d;
   }
   
   public static BTNode makeSubTree2(){
      /*Return a pre-made sub-tree for quick testing*/
      BTNode n1 = makeKVNode("T", 0);
      
      BTNode n2 = makeKVNode("H", 1);
      BTNode n7 = makeKVNode("U", 4);
      n1.setLeft(n2);
      n1.setRight(n7);
      
      BTNode n3 = makeKVNode("E", 2);
      BTNode n4 = makeKVNode("Q", 3);
      n2.setLeft(n3);
      n2.setRight(n4);
      
      BTNode n5 = makeKVNode("C", 6);
      BTNode n6 = makeKVNode("I", 5);
      n3.setLeft(n5);
      n4.setLeft(n6);
      
      BTNode n8 = makeKVNode("K", 7);
      n6.setRight(n8);
      
      return n1;
   }
   
   public static BSTDict makeBSTDict2(){
      /*Return a pre-made BSTDict for quick testing*/
      BSTDict d = new BSTDict();
      d.root = makeSubTree2();
      return d;
   }
   public static int sizeHelper(BTNode n){
      if(n == null) return 0;
      int s = 1;
      BTNode Left = n.getLeft();
      BTNode Right = n.getRight();
      s += sizeHelper(Left);
      s += sizeHelper(Right);
      return s;
   }
   public int size(){
      return sizeHelper(this.root);
   }
   public static Object getHelper(BTNode n,String key){
      Object value = null;
      if(n == null) return null;
      String key1 = ((KVPair)n.getData()).getKey();
      if(key1.equals(key)) value = ((KVPair)n.getData()).getValue();
      BTNode Left = n.getLeft();
      BTNode Right = n.getRight();
      if((key.compareTo(key1) <= 0) && (value == null)){
         value = getHelper(Left,key);
      }
      if((key.compareTo(key1) > 0) && (value == null)){
         value = getHelper(Right,key);
      }
      return value;
   }
   public Object get(String key){
      return getHelper(this.root,key);
   }
   public static void putHelper(BTNode n,String key,Object value){
      KVPair kv = new KVPair (key,value);
      String key1 = ((KVPair)n.getData()).getKey();
      BTNode a = new BTNode(kv);
      if(key1.equals(key)) n.setData(kv);
      else{
         BTNode Left = n.getLeft();
         BTNode Right = n.getRight();
         if(key.compareTo(key1) <= 0){ //go left
            if(Left == null){
               n.setLeft(a);
            }
            else{
               putHelper(Left,key,value);
            }
         }
         else{ //go right
            if(Right == null){
               n.setRight(a);
            }
            else{
               putHelper(Right,key,value);
            }
         }
      }
   }
   public void put(String key, Object value){
      KVPair kv = new KVPair (key,value);
      if(this.root == null) this.root = new BTNode(kv);
      putHelper(this.root,key,value);
   }
}