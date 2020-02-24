package info;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    private String ip="";
    private int port = 4444;
    private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	
	public MyClient()throws UnknownHostException, IOException{
		Socket s=new Socket(ip,port);
		oos=new ObjectOutputStream(s.getOutputStream());
		ois=new ObjectInputStream(s.getInputStream());
	}
	
	
	
}
