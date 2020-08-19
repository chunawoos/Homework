package hwjava12_서울_8반_천창민;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChatClientSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
    private JTextField inputTextField;
    private JButton sendButton, saveButton;
    private JList li;
    private JFrame f;
    private JPanel p;
    private JButton b;
    
    private ChatConnect chatConnect;
    private String name;

    public ChatClientSwing(String ip, int port) {
    	chatConnect = new ChatConnect( this, ip, port, name);
    	createUI();
        	
    }
    
    public ChatConnect getChatConnect() {
    	return chatConnect;
    }
    
    
    private void createUI() {
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();
        add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        saveButton = new JButton("저장");
        
        box.add(inputTextField);
        box.add(sendButton);
        box.add(saveButton);

		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 입력 값 
				String str = inputTextField.getText();
				if ( str != null && str.trim().length() > 0 ) {

					chatConnect.send(str);
					
				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
			
			
		};
        
		ActionListener saveListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringReader str = new StringReader(textArea.getText());
				BufferedReader br = new BufferedReader(str);
				String line;
				File f = new File("ChattingSave.txt");
				
				try {
					if(!f.exists())
						f.createNewFile();
				
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					while ( ( line = br.readLine() ) != null ){
						oos.writeBytes(line+"\n");
					}
					oos.close();
					fos.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		};
		
        inputTextField.addActionListener(sendListener);
        sendButton.addActionListener(sendListener);
        saveButton.addActionListener(saveListener);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

            	chatConnect.sendExit();
            	
            }
        });
    }

    public void updateChat(String message) {
    	textArea.append(message);
        textArea.append("\n");
    }
}