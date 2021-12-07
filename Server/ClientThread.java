import java.util.ArrayList;
class ClientThread extends Thread{
  String name;
  Socket socket;
  Lobby lobby;
  ArrayList<Lobby> lobbys;
  
  
  ClientThread(Socket socket,ArrayList<Lobby> lobbys){
    this.socket=socket;
    this.lobbys=lobbys;
  }
  
  
  public void run(){
    String text="Willkommen im Vorraum, waehlen sie eine der folgenden Lobbys:\n";
    for (int i=0;i<lobbys.size();i++) {
      text+=(i+1)+": "+lobbys.get(i).getName();
    } // end of for
    socket.write(text);
    int auswahl=socket.read();
    lobby=lobbys.get(auswahl);
    socket.write("\nGeben Sie ihren Namen ein: ");
    socket.readLine();
    
    
    text="Sie sind jetzt mit der Lobby: "+lobby.getName()+" verbunden.";
    socket.write(text);
    lobby.addClientThread(this);
  }
  
  
  
  
  
  
  
}
