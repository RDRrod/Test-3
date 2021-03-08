//The class contains static methods that are called in other classes 

public class calculator {
    public static int getCheck(int a, int b, String card){ //performance calculation 
        int perfom;
        
        if(card=="Nvidia")
            perfom = (50*a+300*b)/1000;
        else
            perfom = 2*(50*a+300*b)/1000;
        return perfom;
        
    }
    
    public static int getTDP(int a, int b, String card){ //TDP calculation 
        int perfom;
        
        if(card=="Nvidia")
            perfom = (70*a+20*b)/2000;
        else
            perfom =  (70*a+20*b)/1500;
        return perfom;
        
    }
    
     public static double getCriptPerHour(int a){  //Cryptocurrency production per hour 
        double mining;
        mining = a/20;
        return mining;
        
    }
     public static double getCryptNow(double a, double b){ //Incremental crypto wallet balance 
         a= a + b/100.0; 
         return a;
     }
     
    
}



