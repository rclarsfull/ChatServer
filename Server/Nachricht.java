import java.time.LocalDateTime;
class Nachricht{
  String text;
  ClientThread client;
  LocalDateTime time;
  Nachricht(String text,ClientThread client) {
    time=LocalDateTime.now();
    this.client=client;
    this.text=text;
    }
  
  public String toString(){
     return time.toString()+ "\t"+client.getClientName()+": "+text;
  }
  }
