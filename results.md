Your implementation information goes here.
The main solution is contained in Lottery Machine.java
I have used a HashMap to maintain the info about each customer and the tickets he/she has purchased. The key is the Customer ID and the value is a list of tickets that has been purchased. 
The ticket numbers are generated at the run-time after purchasing the ticket. They are stored in the HashMap where every new generated ticket number is checked against the existing tickets for uniqueness.
The draw method generates a random number for each ticket type to declare the winning ticket number.
Finally. the report generator method generates report about every customer and his/her corresponding tickets.
Since majority of the complutation involves a lookup, I have chosen to implement my solution using a HashMap.
And since we have the info for which customer posessing which ticket, we can display our required data accordingly.
Run the LotteryTicket.java file to simulate a real-time Lottery Machine that generates tickets

Run the Test1.java file to simulate the requirements of the coding challenge.
