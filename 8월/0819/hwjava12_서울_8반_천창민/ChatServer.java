package hwjava12_서울_8반_천창민;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;

	public void service() {
		
		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {

				Socket s = ss.accept();
				System.out.println("ChatClient 가 접속했습니다.");

				ChatThread t = new ChatThread(s);
				synchronized (chatThreadList) {
					chatThreadList.add(t);
				}
				t.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast( String message ) {
		synchronized (chatThreadList) {
			for( ChatThread t : chatThreadList ){
				try {
					t.sendMessage( message );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) 	{
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket = null;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;
		
		public ChatThread(Socket socket) throws Exception {
			this.socket = socket;
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				while ( ! isExit ) {
					String msg = (String) ois.readObject();
					
					if( "^".contentEquals(msg) ) {
						synchronized (chatThreadList) {
							chatThreadList.remove(this);
						}
						isExit = true;
					}else {
						broadcast(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				synchronized (chatThreadList) {
					chatThreadList.remove(this);
				}
			}
		}

		public void sendMessage(String message) throws Exception {
			oos.writeObject(message);
		}
	}
}
