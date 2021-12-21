import java.util.ArrayList;
class Server extends Thread{
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
  
  
  public void run(){
    while (true) { 
      try {
        ClientThread temp=new ClientThread(serverSocket.accept(),this,lobbys.get(0));
        temp.start();
        clients.add(temp);
        System.out.println("Client Thread started");
      } catch(Exception e) {
        
      } 
      
      
      } // end of while
    }
  
  public void createLobby(String name, int pass){
    Lobby tempL=new Lobby(name,pass);
    tempL.start();
    lobbys.add(tempL);
    System.out.println("Lobby Created");
    }

  public ArrayList<Lobby> getLobbys(){
     return lobbys;
    }
 
  
  }
