import java.util.ArrayList;
import java.util.LinkedList ;
class Lobby extends Thread{
  private ArrayList<ClientThread> clients;
  private ArrayList<Nachricht> nachrichten;
  private LinkedList<Nachricht> newNachrichten;
  private String name, verlauf;
  private int pass;
  
  Lobby(String name, int pass){
    this.name=name;
    this.pass=pass;
    verlauf="";
    clients=new ArrayList<ClientThread>(); 
    nachrichten=new ArrayList<Nachricht>();
    newNachrichten=new LinkedList<Nachricht>();
    }
  
  public void run(){
    while (newNachrichten.size()>0) { 
      for (ClientThread c:clients) {
        c.sendMessage(newNachrichten.getLast().toString());
      } // end of for
      newNachrichten.removeLast();
    } // end of while
    
    } // end of for
    
    
  
  public void addClientThread(ClientThread c){
    for (Nachricht n:nachrichten) {
      c.sendMessage(n.toString());
    } // end of for
    
    clients.add(c);
    }
  
  public int getPass(){
    return pass;
    }
  
  public String getLobbyName(){
    return name;
    }
  
//  public void updateVerlauf(String nachricht){
//    verlauf+=nachricht+";\n";
//    }
  
  public String getVerlauf(){
    return verlauf;
    }
  
  public void schreibeNachricht(Nachricht nachricht){
    nachrichten.add(nachricht);
    newNachrichten.add(nachricht);
    }
  
  
  
  
  
  }
