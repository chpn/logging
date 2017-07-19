package chpn.log.server;

 
public interface IMessageProcessor {

    public void process(Message message, WriteProxy writeProxy);

}
