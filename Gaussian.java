public class Gaussian{
   public static double pdf(double x, double mean, double std){
      /*Evaluate the value of the probability density function
      at x for the given values of the mean and std. dev.
      Input:
         double x: the point where you want to evaluate the PDF
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
      Output:
         return: the value of the PDF at x
      Ex.
      pdf(0.5, 0.5, 1.0) -> 0.3989422804014327
      pdf(-1.0, 0.0, 1.0) -> 0.24197072451914337
      pdf(6.0, 0.0, 2.0) -> 0.0022159242059690038
      */
      double pdf = Math.exp(1);
      double exponent = (-1.0 / 2.0) * Math.pow(((x - mean)) / std, 2.0);
      double base = 1.0 / (std * (Math.sqrt(2.0 * Math.PI)));
      return base * Math.pow(Math.E, exponent);
   }
   public static double riemann(double xStart, double xFinish, double mean, double std, double dx){
      /*Calculate the area underneath PDF(x) from xStart to
      xFinish using a trapezoidal Riemann sum.
      Input:
         double xStart: the starting x-coordinate for the area 
         double xFinish: the ending x-coordinate for the area 
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step-size for drawing trapezoids
      Output:
         return: the area under PDF(x) from xStart to xFinish
      Ex.
      riemann(-1.0, 0.0, 0.0, 1.0, 0.001) -> 0.3413...
      riemann(-1.0, 1.0, 0.0, 1.0, 0.001) -> 0.6826...
      riemann(-1.0, 2.0, 1.0, 1.0, 0.001) -> 0.8185...
      */
      double sum = 0;
      while(xStart <= (xFinish-dx)){
         double a = pdf((xStart + dx), mean, std);
         double b = pdf(xStart, mean, std);
         sum += ((a+b)/2)*dx;
         xStart+=dx;
      }
      double leftover = Math.abs(xFinish-xStart);
      double a = pdf(xFinish, mean, std);
      double b = pdf((xFinish-leftover), mean, std);
      sum += ((a+b)/2)*leftover;
      return sum;
   }
   public static double cdf(double x, double mean, double std, double dx){
      /*Evaluate the value of the Gaussian cumulative
      distribution function at x for the given values of the
      mean and standard deviation. Calculate the result
      numerically using a trapezoidal Riemann sum with dx 
      step size.
      Input:
         double x: the point where you want to evaluate the CDF
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size to use for num. integration
      Output:
         return: the approx. value of the CDF at x
      Ex.
      cdf(-1.0, 0.0, 1.0, 0.01) -> 0.1586...
      cdf(2.0, 1.0, 2.0, 0.001) -> 0.6914...
      cdf(10.0, 10.0, 3.0, 0.001) -> 0.5
      */
      if(x >= 0.5){
         double a = 0.5 + riemann(mean,x,mean,std,dx);
         return a;
      }
      else{
         double a = 0.5 - riemann(x,mean,mean,std,dx);
         return a;
      }
   }
   public static double inv_cdf(double p, double xLeft, double xRight, double mean, double std, double dx, double error){
      /*Find x such that cdf(x) = p for a Gaussian distribution
      with the given mean and standard deviation.
      Input:
         double p: the probability output from cdf(x) we want
         double xLeft: initial left bracket i.e. cdf(xLeft) < p
         double xRight: initial right bracket i.e. cdf(xRight)>p
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size for evaluating the cdf(x)
         double error: the max. amount of acceptable error on x
      Output:
         return: the approx. value of x that makes cdf(x) = p
     Ex.
      inv_cdf(0.25, -3.0, 3.0, 0.0, 1.0, 0.0001, 0.0001) ~> -0.674...
      inv_cdf(0.80, -10.0, 10.0, 1.0, 3.0, 0.0001, 0.0001) ~> 3.524...
      */
      double middle = 0;
      while((xRight-xLeft) > error){
         middle = (xLeft+xRight)/2;
         if(cdf(middle,mean,std,dx) < p){
            xLeft = middle;
         }
         if(cdf(middle,mean,std,dx) > p){
            xRight = middle;
         }
      }
      return middle;
   }
   public static double inv_cdf(double p, double mean, double std, double dx, double error){
      /*Find x such that cdf(x) = p for a Gaussian distribution
      with the given mean and standard deviation.
      Input:
         double p: the probability output from cdf(x) we want
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size for evaluating the cdf(x)
         double error: the max. amount of acceptable error on x
      Output:
         return: the approx. value of x that makes cdf(x) = p
     Ex.
      inv_cdf(0.25, 0.0, 1.0, 0.0001, 0.0001) ~> -0.674...
      inv_cdf(0.80, 1.0, 3.0, 0.0001, 0.0001) ~> 3.524...
      */
      double left = mean-std;
      double right = mean+std;
      double dev = std;
      while(left > p){
         dev*=2;
         left = mean-dev;
      }
      while(right < p){
         dev*=2;
         left = mean-dev;
      }
      return inv_cdf(p,left,right,mean,std,dx,error);
   }
}