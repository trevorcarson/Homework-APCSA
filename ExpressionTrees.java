public class ExpressionTrees{
      public static BTNode makeTree1(){
      /*Make a binary tree representing the expression:
      3.0*2.0 - 6.0/3.0
      */
      BTNode a = new BTNode("-");
      BTNode b = new BTNode(2.0);
      BTNode c = new BTNode(6.0);
      BTNode d = new BTNode(3.0);
      BTNode e = new BTNode("*");
      BTNode f = new BTNode("/");
      BTNode g = new BTNode(3.0);
      a.setLeft(e);
      a.setRight(f);
      e.setLeft(d);
      e.setRight(b);
      f.setLeft(c);
      f.setRight(g);
      return a;
   }
   public static BTNode makeTree2(){
      /*Make a binary tree representing the expression:
      0.75*(5.5 - 1.5) + 2.0*4.0
      */
      BTNode a = new BTNode("+");
      BTNode b = new BTNode("*");
      BTNode c = new BTNode("*");
      a.setLeft(b);
      a.setRight(c);
      BTNode d = new BTNode(2.0);
      BTNode e = new BTNode(4.0);
      c.setLeft(d);
      c.setRight(e);
      BTNode f = new BTNode(0.75);
      BTNode g = new BTNode("-");
      b.setLeft(g);
      b.setRight(f);
      BTNode h = new BTNode(5.5);
      BTNode i = new BTNode(1.5);
      g.setLeft(h);
      g.setRight(i);
      return a;  
   }
   public static double arithmetic(String operator, double operand1, double operand2){
      /*Evaluate basic arithmetic operations
      Input:
      String operator: a String representing a supported 
                          arithmetic operation:
                          +: addition
                          -: subtraction
                          *: multiplication
                          /: division
                          ^: power
         double operand1: the 1st operand
         double operand2: the 2nd operand
      Output:
         return: the result of the operation
      Ex.
      arithmetic("+", 1, 2) -> 3.0
      arithmetic("-", 7, 6) -> 1.0
      arithmetic("*", 1.5, 2) -> 3.0
      arithmetic("/", 4, 5) -> 0.8
      arithmetic("^", 2, 3) -> 8.0
      */
      if(operator.equals("+")){
         return operand1 + operand2;
      }
      else if(operator.equals("-")){
         return operand1 - operand2;
      }
      else if(operator.equals("*")){
         return operand1 * operand2;
      }
      else if(operator.equals("/")){
         return operand1 / operand2;
      }
      else if(operator.equals("^")){
         return Math.pow(operand1, operand2);
      }
      else{
         throw new IllegalArgumentException("unsupported operator: "+operator);
      }
   }  
   public static double evaluate(BTNode expTree){
      /*Evaluate an expression tree
      Input:
         BTNode expTree: an expression tree to evaluate
      Output:
         return: the result of evaluating the whole expression
      Ex.
      BTNode tree1 = makeTree1();
      BTNode tree2 = makeTree2();
      evaluate(tree1) -> 4.0
      evaluate(tree2) -> 11.0
      */
      BTNode Left = expTree.getLeft();
      BTNode Right = expTree.getRight();
      double left;
      double right;
      if(expTree.isLeaf() == true) return Double.valueOf(expTree.toString());
      if(Left.isLeaf() == false){
         left = evaluate(Left);
      }
      else left = Double.valueOf(Left.getData().toString());
      if(Right.isLeaf() == false){
         right = evaluate(Right);
      }
      else right = Double.valueOf(Right.getData().toString());
      return arithmetic((expTree.getData().toString()),left,right);
   }
}