package hwjava12_서울_8반_천창민;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChatClient{
	
	public static void main(String[] args) 	{
		String ip = "localhost";
		int port = 4101;
		
		
		ChatClientSwing ui = new ChatClientSwing( ip, port );
		ui.setTitle("SSAFY V1 - connected to " + ip + ":" + port);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
        
        String name = JOptionPane.showInputDialog("이름을 입력하세요.");
        ui.getChatConnect().setName(name);
	}
}
