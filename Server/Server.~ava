import java.util.ArrayList;
class Server{
  private ArrayList<Lobby> lobbys;
  private ArrayList<ClientThread> clients;
  private ServerSocket serverSocket;
  
  Server(int port){
    try {
      serverSocket=new ServerSocket(port);
    } catch(Exception e) {
      System.out.println("Server konnte nicht gestartet werden!!");
    } 
    
    lobbys=new ArrayList<Lobby>();
    clients=new ArrayList<ClientThread>();
    }
  
  
  void starteServer(){
    while (true) { 
      ClientThread temp=new ClientThread(serverSocket.accept());
      temp.start();
      clients.add(temp);
      } // end of while
    }
  
  public void createLobby(String name, int pass){
    lobbys.add(new Lobby(name,pass));
    }
  
  
  }
