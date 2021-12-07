import java.util.ArrayList;
class Lobby extends Thread{
  private ArrayList<ClientThread> clients;
  private String name, verlauf;
  private int pass;
  
  Lobby(String name, int pass){
    this.name=name;
    this.pass=pass;
    verlauf="";
    clients=new ArrayList<ClientThread>();
    }
  
  void run(){
    for (ClientThread c: clients) {
      while (c.) { 
        
      } // end of while
    } // end of for
    
    }
  
  public void addClientThread(ClientThread c){
    clients.add(c);
    }
  
  public int getPass(){
    return pass;
    }
  
  public String getName(){
    return name;
    }
  
  public void updateVerlauf(String nachricht){
    verlauf+=nachricht+";\n";
    }
  
  public String getVerlauf(){
    return verlauf;
    }
  
  
  
  
  }
