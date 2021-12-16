import java.util.Scanner;
class Client{
  
  public static void main(String[] args){
    String name=args[0];
    String ip=args[1];
    int port=Integer.parseInt(args[2]);
    boolean connected=false;
    Scanner in =new Scanner(System.in);
    String input="";
    
    try {
      Socket socket=new Socket(ip,port);
      if (socket.connect()) {
        System.out.println("Verbindung zum Server wurde hergestellt.");
      } else {
        System.out.println("Es konnte keine Verbindung zum Server hergestellt werden.");
        
      } // end of if-else
      connected=true; 
      ClientDrucker drucker=new ClientDrucker(socket);
      drucker.start();
      
      
      while (connected) {
        input=in.next();
        if (input.equalsIgnoreCase("ende")) {
          connected=false;
          socket.close();
          break;
        } else {
          socket.write(input);
        } // end of if-else
      } // end of while
    } catch(Exception e) {
      System.out.println("Es konnte keine verbindung zum Server hergestellt werden.");
    }
    
    
    
    
    
    
    
  }
  
  
}
