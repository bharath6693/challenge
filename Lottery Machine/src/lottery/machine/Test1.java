/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery.machine;

import java.util.Scanner;

/**
 *
 * @author Bharath
 */
public class Test1 {
    
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        LotteryMachine lm = new LotteryMachine();
        
        System.out.println("This test case simulates an entire sale cycle of teh tickets");
        System.out.println("Press 1 to continue");
        s.next();
        while(true){
            lm.generateTicketsFor(0, 5, 3);
            lm.generateTicketsFor(0, 5, 4);
            lm.generateTicketsFor(0, 5, 5);
            lm.generateTicketsFor(1, 3, 3);
            lm.generateTicketsFor(1, 1, 4);
            lm.generateCustomerReport();
            lm.draw(3);
            lm.draw(4);
            lm.draw(5);
            System.out.println("type 1 to reset the machine and start over. Type 0 to exit");
            if(s.nextInt() == 1)
                lm.ResetMachine();
            else
                break;
        }
    }
}
