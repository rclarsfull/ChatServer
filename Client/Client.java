import java.util.Scanner;
class Client{
  
  public static void main(String[] args){
    String name="test";//args[0];
    String ip="127.0.0.1";//args[1];
    int port=10000;//Integer.parseInt(args[2]);
    boolean connected=false;
    Scanner in =new Scanner(System.in);
    String input="";
    
    try {
      Socket socket=new Socket(ip,port);
      if (socket.connect()) {
        System.out.println("Verbindung zum Server wurde hergestellt.");
        connected=true; 
        ClientDrucker drucker=new ClientDrucker(socket);
      drucker.start();
      } else {
        System.out.println("Es konnte keine Verbindung zum Server hergestellt werden.");
        connected=false; 
      } // end of if-else
      
      
      
      while (connected) {
        try {
          Thread.sleep(100);
        } catch (Exception e) {
          //TODO: handle exception
        }
        System.out.print("->");
        input=in.nextLine();
       
        if (input.equalsIgnoreCase("ende\n")) {
          connected=false;
          socket.close();
          break;
        } else {
          //System.out.println(input);
          socket.write(input+"\n");
          input="";
        } // end of if-else
      } // end of while
    } catch(Exception e) {
      System.out.println("Es konnte keine verbindung zum Server hergestellt werden.");
    }
    
    
    
    
    
    
    
  }
  
  
}
