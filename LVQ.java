/**
 *
 * @author ichan
 */
public class LVQ {
    public LVQ() {}
    
    public void run(int a) {
        
       abs1 = 0;
       abs2 = 0;
      // abs3 = 0;
       minAbs = 0;
       
            for (int j= 0 ; j<=numXk; j++) {
                abs1 = abs1 + ((X1[a][j] - W1[j]) * (X1[a][j] - W1[j]));
               
                abs2 = abs2 + ((X1[a][j] - W2[j]) * (X1[a][j] - W2[j]));
              
              //  abs3 = abs3 + ((X1[a][j] - W3[j]) * (X1[a][j] - W3[j]));
                
            }

            
                abs1 = java.lang.Math.sqrt(abs1);
                abs2 = java.lang.Math.sqrt(abs2);
               // abs3 = java.lang.Math.sqrt(abs3);
            
          
                
                minAbs = java.lang.Math.min(abs1, abs2);
               // minAbs = java.lang.Math.min(minAbs, abs3);
            if (minAbs == abs1) {
                System.out.println("minAbs is W1 "+abs1 +" || "+abs2 );
              
                 for (int i=0; i<=numW; i++) {
                     
                    W1[i] = W1[i] +  lr*(X1[a][i] - W1[i]);
                    
                 }
                System.out.println("==================================" );
		
		} else {
                System.out.println("minAbs is W2 "+abs1 +" || "+abs2 );
                
                 for (int i=0; i<=numW; i++) {
                    W2[i] = W2[i] + lr*(X1[a][i] - W2[i]);
                    
                 }
                System.out.println("==================================" );
            } 
				
				
				/**
            } else if (minAbs == abs2) {
                System.out.println("minAbs is W2 "+abs1 +" || "+abs2+" || "+abs3 );
                 //fix the weights of W2
                 for (int i=0; i<=numW; i++) {
                    W2[i] = W2[i] + lr*(X1[a][i] - W2[i]);
                    //System.out.println(W2[i]);
                 }
                System.out.println("==================================" );
            } else {
                  System.out.println("minAbs is W3 "+abs1 +" || "+abs2+" || "+abs3 );
                 //fix the weights of W2
                 for (int i=0; i<=numW; i++) {
                    W3[i] = W3[i] + lr*(X1[a][i] - W3[i]);
                    //System.out.println(W2[i]);
                 }
                System.out.println("==================================" );
            }
        
			*/
    }     
    
    public void show() {
        System.out.println("Bobot akhir W1 ");
        for (int i=0; i<= numW; i++) {
            System.out.println(W1[i]);
        }
        System.out.println();
        System.out.println("Bobot akhir W2 ");
        for (int i=0; i<= numW; i++) {
            System.out.println(W2[i]);
        }
		/**
        System.out.println();
        System.out.println("Bobot akhir W3 ");
        for (int i=0; i<= numW; i++) {
            System.out.println(W3[i]);
        }
		*/
    }
    
    public void test(int a) {
       abs1 = 0;
       abs2 = 0;
     //  abs3 = 0;
       minAbs = 0;
       
            for (int j= 0 ; j<=numXk; j++) {
                abs1 = abs1 + ((X1[a][j] - W1[j]) * (X1[a][j] - W1[j]));
                
                abs2 = abs2 + ((X1[a][j] - W2[j]) * (X1[a][j] - W2[j]));
                
           //     abs3 = abs3 + ((X1[a][j] - W3[j]) * (X1[a][j] - W3[j]));
                
            }

                //sqrt the abs
                abs1 = java.lang.Math.sqrt(abs1);
                abs2 = java.lang.Math.sqrt(abs2);
               // abs3 = java.lang.Math.sqrt(abs3);
            
           
                
                minAbs = java.lang.Math.min(abs1, abs2);
              //  minAbs = java.lang.Math.min(minAbs, abs3);
            if (minAbs == abs1) {
               
                System.out.println("Data at Vector "+a+" is at class 1");
                System.out.println("==================================" );
           } else {
              
                System.out.println("Data at Vector "+a+" is at class 2");
                System.out.println("==================================" );
            }
		   
		   
		   
		   /**
		    } else if (minAbs == abs2) {
                //System.out.println("minAbs is W2 "+abs1 +" || "+abs2+" || "+abs3 );
                System.out.println("Data at Vector "+a+" is at class 2");
                System.out.println("==================================" );
            } else {
                //System.out.println("minAbs is W3 "+abs1 +" || "+abs2+" || "+abs3 );
                System.out.println("Data at Vector "+a+" is at class 3");
                System.out.println("==================================" );
            }
		   
		   
		   
		   */
		   
    }
    
    public static void main (String args[]) {
      LVQ o = new LVQ();
      
      while (o.lr >= o.minlr) {
     
          o.epoch++;
          System.out.println("========================= Epoch ke-"+o.epoch+" ==========================");
          System.out.println("learning rate = "+o.lr);
            for (int i=0; i<=o.numXb; i++) {
                System.out.println("Vector  "+i);
                o.run(i);
            }
          
         
            o.lr = o.lr - (o.lr * o.deca);
        }
        
        System.out.println("Minimum Alpha has reached = "+ o.lr);
        o.show();
        System.out.println("=========Now running on test set============");
            for (int i=0; i<=o.numXb; i++) {
                
                o.test(i);
            }
    }
//input
  double X1[][] = {{1,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0},{1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,1},{1,1,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,1,1}, 					{1,1,1,1,1,1,1,0,1,0,0,1,0,0,0,1,0,1,1,0,0,1,1,0,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,1,1,0,1,1}, {1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,0},{1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,1,1,0,1,0,0,1,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0}, {1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1}};
    
    double W1[] = {1,1,1,1,1,1,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,0};
    double W2[] = {1,1,1,1,1,1,1,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,1,0,1,0,0,1,1,1,0,1,0,0,1,0};
 //   double W3[] = {5,13};
                                
    
    double abs1, abs2, minAbs;
    double numXb = 7;
    double numXk = 5;
    double numW = 4;
    double lr = 0.05;   
    double minlr = 0.001;
    double deca = 0.1;
    int maxEp = 50;
    int epoch = 0;
                              
}

