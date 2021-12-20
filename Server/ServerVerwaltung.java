class ServerVerwaltung {
  
  public static void main(String[] args){
    System.out.println("Versuche Serverstart");
    Server server=new Server(10000);
    server.start();
    server.createLobby("test",123);
    
    }
  
  
  }
