import java.util.ArrayList;
class ClientThread extends Thread{
  String name;
  Socket socket;
  Lobby lobby;
  Server server;
  
  
  ClientThread(Socket socket,Server server, Lobby lobby){
    this.socket=socket;
    this.server=server;
    this.lobby=lobby;
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
      
      socket.write("Geben Sie ihren Namen ein: \n");
      name=socket.readLine();
      System.out.println("Empfangen");
      
      
      text="Sie sind jetzt mit der Lobby: "+lobby.getLobbyName()+" verbunden. \n";
      socket.write(text);
      lobby.addClientThread(this);
      
      
      while (true) {    
        //System.out.println("Loop");
        String message=socket.readLine();
        schreibeNachricht(message);
      } // end of while
    } catch(Exception e) {
      System.out.println("Fehler in ClientThread");
    } finally {
      
    } // end of try
    
  }
  

  
  public String getClientName(){
    return name;
    }
  
  public void sendMessage(String m){
    try {
      socket.write(m+"\n");
      System.out.println("Client Thread hat gesendet");
    } catch(Exception e) {
      System.out.println("Fehler beim senden einer Nachricht");
    } finally {
      
    } // end of try
    }
  
  public void schreibeNachricht(String nachricht){
     lobby.schreibeNachricht(new Nachricht(nachricht,this));
     System.out.println("nachricht übergeben");
    }
  
    
  
  
  
  
  
  
  
}
