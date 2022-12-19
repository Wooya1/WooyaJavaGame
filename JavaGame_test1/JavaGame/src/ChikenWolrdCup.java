import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ChikenWolrdCup {
	static JPanel panelNorth;
	static JPanel panelCenter;
	static JLabel labelMessage;
	static JLabel labelVs;
	static JButton buttonLeft;
	static JButton buttonRight;
	static String[] images = {
	    "BHC 맛초킹.jpg", "BHC 뿌링클.jpg", "BHC 핫후라이드.jpg", "교촌 레드콤보.jpg", "교촌 허니콤보.jpg",
	    "굽네 고추바사삭.jpg", "굽네 오리지널.jpg", "네네 스노윙.jpg", "네네 오리엔탈파닭.jpg", "멕시칸 닭강정.jpg",
		"비비큐 자메이카통다리.jpg", "비비큐 황금올리브.jpg", "지코바 숯불양념치킨.jpg", "처갓집 슈프림양념.jpg",
		"페리카나 양념치킨.jpg", "푸라닭 블랙알리오.jpg"
    };
	static int imageIndex = 2; //3번째 이미지 위치값 초기화
	//이미지를 버튼으로 사용
	static ImageIcon changeImage(String filename) {
		ImageIcon icon =   new ImageIcon("./"+filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}
	
	static class MyFrame extends JFrame implements ActionListener{
		public MyFrame(String title) {
			super( title );
			
			//ui 초기화
			this.setSize(450, 250);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panelNorth = new JPanel();
			labelMessage = new JLabel("Find Your Chicken!");
			labelMessage.setFont(new Font("Arial", Font.BOLD, 20));
			panelNorth.add(labelMessage);
			this.add( "North", panelNorth );
			
			panelCenter = new JPanel();
			labelVs = new JLabel("vs");
			labelVs.setFont( new Font("Arial", Font.BOLD, 20));
			buttonLeft = new JButton("LeftButton");
			buttonLeft.setIcon(changeImage("BHC 맛초킹.jpg"));
			buttonLeft.setPreferredSize(new Dimension(200,200));
			buttonRight = new JButton("RightButton");
			buttonRight.setIcon(changeImage("BHC 뿌링클.jpg"));
			buttonRight.setPreferredSize(new Dimension(200,200));
			//이미지 클릭하면 이벤트 발생.
			buttonLeft.addActionListener(this);
			buttonRight.addActionListener(this);
			panelCenter.add(buttonLeft);
			panelCenter.add(labelVs);
			panelCenter.add(buttonRight);
			this.add( "Center", panelCenter );
			
			//빈공간을 팩으로 묶음.
			this.pack();
			
		}
		//버튼 클릭시 콜백.
		@Override
		public void actionPerformed(ActionEvent e) {
		if( imageIndex == 16) {
				//마지막 치킨.
				labelMessage.setText("Found Your Chicken!");
				//마지막 이미지 하나.
			if(e.getActionCommand().equals("LeftButton")) {
				buttonRight.hide();
		        labelVs.hide();
			}else {
				buttonLeft.hide();
			    labelVs.hide();
			}
				
		}else {
			if(e.getActionCommand().equals("LeftButton") ) {
				//왼쪽버튼 클릭.
				buttonRight.setIcon(changeImage(images[imageIndex]));
				imageIndex++;
			}else {
				//오른쪽버튼 클릭.
				buttonLeft.setIcon(changeImage(images[imageIndex]));
				imageIndex++;
			}
			
		}
	}
}		
	
	public static void main(String[] args) {
		new MyFrame("Chiken Wolrd Cup"); 
	}

}