import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
ArrayList<Ticket> trainTicketList= TrainTicketReader.readTrainTickets("D:\\Documents\\Partial 3\\train_tickets.csv");
System.out.println("Lista bilete de tren");
for(Ticket ticket:trainTicketList){
    System.out.println(ticket.toString());
}
Collections.sort(trainTicketList,new SortByPrice());
System.out.println("\nLista sortata");
for(Ticket ticket:trainTicketList){
    System.out.println(ticket.toString());
}
        HashMap<String,ArrayList<Ticket>> Tg=new HashMap<>();
for(Ticket ticket:trainTicketList){
    Tg.computeIfAbsent(ticket.getStatus(),k->new ArrayList<>()).add(ticket);

}
 for(ArrayList<Ticket> Sg:Tg.values()){
     Collections.sort(Sg,new SortByPrice());
 }
    for(String status:Tg.keySet()){
        System.out.println();
        System.out.println("Status:"+status);
    for(Ticket ticket:Tg.get(status)){
        System.out.println(ticket);
    }
    System.out.println();
    }
    }
}