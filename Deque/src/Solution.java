  import java.util.*;
    public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();

            for (int i = 0; i <n; i++) {
                int num = in.nextInt();
                if(!deque.contains(num)) {
            deque.add(num);
            
                }
            }
           
            if(deque.size()<m)
            {  System.out.println(deque.size());
                }
                else{System.out.println(m);}
          
        }
    }
