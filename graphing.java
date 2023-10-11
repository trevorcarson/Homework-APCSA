public class graphing{
   public static void drawBarGraph(IntList heights){
      /*draw bar graphs in StdDraw windown from left to right with 
      the heights given in the list.
      The window has a domain of 0.0 to 1.0 and range from 0.0 to 1.0
      
      Input:
         An unsorted IntList
      Output:
         A visual representation of different bar heights
      EX:
      drawBarGraph(1,2,3,4,5);
      
          [][][][][O]
         [][][][O][O]
        [][][O][O][O]
       [][O][O][O][O]
      [O][O][O][O][O]
      */
      double HalfWidth = (1.0/(heights.size()*2.0));
      double XCenter = (1.0/((heights.size())*2.0));
      double HalfHeight;
      double YCenter;
      for(int i = 0; i < heights.size(); i++){ //Draw each rectangle with correct height
         int h = heights.get((int)i);
         double H = (double) h; //a double that represents the height of the bar
         HalfHeight = (H/(double)heights.size())/2;
         YCenter = HalfHeight;
         StdDraw.filledRectangle(XCenter,YCenter,HalfWidth,HalfHeight);
         XCenter += HalfWidth*2;
      }
      StdDraw.show();
   }
   public static void main (String [] args){
      /*
      1) Read first line from txt file
      2) Put all the values into the list
      3) graph the values
      4) repeat until end
      */
      int t = Integer.parseInt(args[0]);
      StdDraw.enableDoubleBuffering();
      while(StdIn.hasNextLine() == true){
         IntList l = new IntList();
         String line = StdIn.readLine();
         String lineNoBrackets = line.substring(1,line.length()-1);
         String[] tokens = lineNoBrackets.split(", ");
         for(int i = 0; i < tokens.length; i++){
            int num = Integer.parseInt(tokens[i]);
            l.add(num);
         }
         StdDraw.clear();
         drawBarGraph(l);
         StdDraw.pause(t);
      }
   }    
}     