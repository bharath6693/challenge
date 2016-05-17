/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottery.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Bharath
 */
public class LotteryMachine {

    /**
     * @param args the command line arguments
     */
    
    private int Pick3 = 50,Pick4 = 40,Pick5 = 60;
    Map<Integer,List<Integer>> customer = new HashMap<Integer,List<Integer>>();
    private Random r;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new LotteryMachine().run();
    }
    
    public void run(){
        int id,type;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome!!");
        System.out.println("Beginning simulation...");
        while(true){
            if(Pick3 == 0 && Pick4 == 0 && Pick5 == 0){
                System.out.println("All tickets sold!! Type 1 to begin drawing the winning numbers. Type 0 to reset the machine.");
                if (s.nextInt() == 1){
                    draw(3);
                    draw(4);
                    draw(5);
                }
            }
            System.out.println("Enter your Customer ID to atart: ");
            id = s.nextInt();
            System.out.println("What type of ticket would you like to purchase?(Type 3 or 4 or 5)");
            type = s.nextInt();
            switch(type){
                case 3:
                    if(Pick3 != 0){
                        System.out.println("Your ticket number is: "+generateTicket(id,3));
                        Pick3--;
                    }
                    else
                        System.out.println("Sorry, we have sold all 3-digit tickets. Try another type.");
                    break;
                
                case 4:
                    if(Pick4 != 0){
                        System.out.println("Your ticket number is: "+generateTicket(id,4));
                        Pick4--;
                    }
                    else
                        System.out.println("Sorry, we have sold all 4-digit tickets. Try another type.");
                    break;
                
                case 5:
                    if(Pick5 != 0){
                        System.out.println("Your ticket number is: "+generateTicket(id,5));
                        Pick5--;
                    }
                    else
                        System.out.println("Sorry, we have sold all 5-digit tickets. Try another type.");
                    break;
                
                default:
                    System.out.println("Invalid ticket type! Enter again!");
            }
        }
    }
    
    public void generateTicketsFor(int id,int count,int type){
        switch (type) {
            case 3:
                while(Pick3 != 0 && count > 0){
                    System.out.println(generateTicket(id,3));
                    count--;
                    Pick3--;
                }   break;
            case 4:
                while(Pick4 != 0 && count > 0){
                    System.out.println(generateTicket(id,4));
                    count--;
                    Pick4--;
                }   break;
            case 5:
                while(Pick5 != 0 && count > 0){
                    System.out.println(generateTicket(id,5));
                    count--;
                    Pick5--;
                }   break;
            default:
                break;
        }
    }
    
    private int generateTicket(int CustomerID,int type){
        
        int TicketNumber = 0;
        List<Integer> ticketlist;
        switch(type){
            case 3:
                TicketNumber = generateRandom(900,100);
                break;
            case 4:
                TicketNumber = generateRandom(9000,1000);
                break;
            case 5:
                TicketNumber = generateRandom(90000,10000);
                break;
        }
        if(customer.containsKey(CustomerID)){
            ticketlist = new ArrayList<Integer>();
            ticketlist = customer.get(CustomerID);
            if(ticketlist.contains(TicketNumber))
                generateTicket(CustomerID,type);
            else{
                ticketlist.add(TicketNumber);
                customer.put(CustomerID,ticketlist);
            }
        }
        else{
            ticketlist = new ArrayList();
            ticketlist.add(TicketNumber);
            customer.put(CustomerID,ticketlist);
        }
        
        return TicketNumber;
    }
    
    private int generateRandom(int ra,int increment){
        r = new Random();
        return r.nextInt(ra)+increment;
    }
    
    public void draw(int type){
        int Winner = 0;
        switch(type){
            case 3:
                Winner = generateRandom(900,100);
                break;
            case 4:
                Winner = generateRandom(9000,1000);
                break;
            case 5:
                Winner = generateRandom(90000,10000);
                break;
        }
        System.out.println("The winning ticket for type "+type+" is: "+Winner);
    }
    
    public void generateCustomerReport(){
        List<Integer> al = new ArrayList<Integer>();
        for(Integer key : customer.keySet()){
            System.out.println("Customer "+key+" :\n");
            al = customer.get(key);
            
            for(Integer val: al){
                System.out.print(val+"\t");
            }
            System.out.println("");
        }
        
    }
    public void ResetMachine(){
        System.out.println("Resetting the machine...");
        Pick3 = 50;
        Pick4 = 40;
        Pick5 = 60;
        System.out.println("Machine reset!!");
    }
}
