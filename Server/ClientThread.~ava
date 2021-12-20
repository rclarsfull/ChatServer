import java.util.ArrayList;
class ClientThread extends Thread{
  String name;
  Socket socket;
  Lobby lobby;
  Server server;
  
  
  ClientThread(Socket socket,Server server){
    this.socket=socket;
    this.server=server;
  }
  
  
  public void run() {
    String text="Willkommen im Vorraum, waehlen sie eine der folgenden Lobbys:\n";
//    for (int i=0;i<server.getLobbys().size();i++) {
//      text+=(i+1)+": "+server.getLobbys().get(i).getName();
//    } // end of for
    
    try {
//      socket.write(text);
//      int auswahl=socket.read();
//      lobby=server.getLobbys().get(auswahl);
      
      socket.write("\nGeben Sie ihren Namen ein: ");
      name=socket.readLine();
      
      
      text="Sie sind jetzt mit der Lobby: "+lobby.getName()+" verbunden.";
      socket.write(text);
      lobby.addClientThread(this);
      
      
      while (true) { 
        String message=socket.readLine();
        sendMessage(message);
      } // end of while
    } catch(Exception e) {
      System.out.println("Fehler zu begin");
    } finally {
      
    } // end of try
    
  }
  

  
  public String getClientName(){
    return name;
    }
  
  public void sendMessage(String m){
    try {
      socket.write(m);
    } catch(Exception e) {
      System.out.println("Fehler beim senden einer Nachricht");
    } finally {
      
    } // end of try
    }
  
  public void schreibeNachricht(String nachricht){
     lobby.schreibeNachricht(new Nachricht(nachricht,this));
    }
    
  
  
  
  
  
  
  
}
