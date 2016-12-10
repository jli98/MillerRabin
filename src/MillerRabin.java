/* not required in exam */
import java.io.*;
import java.util.*;
import java.math.BigInteger;  
public class MillerRabin {
    public static BigInteger PowerMod(BigInteger a,BigInteger b,BigInteger m){  
            BigInteger ans = BigInteger.ONE;  
            a = a.mod(m);  
            while(!(b.equals(BigInteger.ZERO))){  
                    if((b.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)){  
                            ans = (ans.multiply(a)).mod(m);  
                            b = b.subtract(BigInteger.ONE);  
                    }  
                    b = b.divide(BigInteger.valueOf(2));  
                    a = (a.multiply(a)).mod(m);  
            }  
            return ans;  
    }  
      
    public static boolean MillerRabin(BigInteger n, int times){  
            if(n.equals(BigInteger.valueOf(2))) 
            	return true;  
            if(n.equals(BigInteger.ONE)) 
            	return false;  
            if((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)) 
            	return false;  
            BigInteger m = n.subtract(BigInteger.ONE);  
            BigInteger y = BigInteger.ZERO;  
            int k = 0;  
            while((m.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)){  
                    k++;  
                    m = m.divide(BigInteger.valueOf(2));  
            }  
            Random d = new Random();  
            for(int i=0;i<times;i++){  
                    int t = 0;  
                            t = n.intValue() - 1;  
                    int a = d.nextInt(t) + 1;  
                    BigInteger x = PowerMod(BigInteger.valueOf(a),m,n);  
                    for(int j=0;j<k;j++){  
                            y = (x.multiply(x)).mod(n);  
                            if(y.equals(BigInteger.ONE) && !(x.equals(BigInteger.ONE)) && !(x.equals(n.subtract(BigInteger.ONE)))) 
                            	return false;  
                            x = y;  
                    }  
                    if(!(y.equals(BigInteger.ONE))) 
                    	return false;  
            }  
            return true;  
    }  
	
public static void main(String[] a) throws Exception{
	int c =50;
	Scanner s = new Scanner(new FileReader("hw2.dat"));
	while(s.hasNextInt()){
	int n = s.nextInt();
	BigInteger x = BigInteger.valueOf(n);
    boolean b = MillerRabin(x,c);
    System.out.print(n+" ");
    System.out.println(b);
	}
	s.close();
}
}