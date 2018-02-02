package dai20kai;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SameGameJFrame extends JFrame implements MouseListener,MouseMotionListener{
	
	public static final int P_WIDTH = 30;
	public static final int P_HEIGHT = 30;
	public static final int NCOLOR = 4;
	public static final int NULLCOLOR = -9999;
	
	public static final int BALL_WIDTH = 30;
	
	public static final int FRAME_WIDTH = BALL_WIDTH*P_WIDTH;
	public static final int FRAME_HEIGHT = BALL_WIDTH*P_HEIGHT;
	public static final int MARGIN = 40;
	
	public static final long sleepTime = 10;
	
	JLabel earthLabel;
	BufferedImage image;
	public int[][] board;
	public int[] colorNum;
	public Color[] colors = {Color.ORANGE,Color.CYAN.darker(),Color.RED.darker(),Color.GREEN.darker(),Color.GRAY};
	public String[] colorName = {"ORANGE","CYAN","RED","GREEN","GRAY"};
	public Color NColor = Color.WHITE;
	
	public int SCORE;

	public SameGameJFrame(){
		super();
		init();
		gameInit();
		paint();
		this.setVisible(true);
	}
	
	public void gameInit(){
		Random rand = new Random();
		board = new int[P_WIDTH][P_HEIGHT];
		colorNum = new int[NCOLOR];
		for(int i = 0;i < NCOLOR;i++)colorNum[i] = 0;
		for(int i = 0;i < P_HEIGHT;i++){
			for(int j = 0;j < P_WIDTH;j++){
				int col = rand.nextInt(NCOLOR);
				board[j][i] = col;
				colorNum[col]++;
			}
		}
		SCORE = 0;
		scoreReload();
	}
	
	public void init(){
		this.setSize(new Dimension(FRAME_WIDTH+MARGIN,FRAME_HEIGHT+MARGIN));
		this.setLayout(null);
		this.setTitle("same game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		earthLabel = new JLabel();
		earthLabel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		earthLabel.addMouseListener(this);
		earthLabel.addMouseMotionListener(this);
		this.add(earthLabel);
	}
	
	public void paint(){
		image = new BufferedImage(FRAME_WIDTH,FRAME_HEIGHT,BufferedImage.TYPE_INT_ARGB);
		for(int y = 0;y < P_HEIGHT;y++){
			for(int x = 0;x < P_WIDTH;x++){
				paintBall(x,y,board[x][y]);
			}
		}
		earthLabel.setIcon(new ImageIcon(image));
	}
	
	public void paintBall(int x,int y,int color){
		Color c = (color==NULLCOLOR?NColor:colors[color]);
		paintBall(x,y,c);
	}
	public void paintBall(int x,int y,Color color){
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(x*BALL_WIDTH, y*BALL_WIDTH, BALL_WIDTH, BALL_WIDTH);
		g2d.setColor(color);
		g2d.fillRect(x*(BALL_WIDTH)-1, y*(BALL_WIDTH)-1, BALL_WIDTH-2, BALL_WIDTH-2);
//		g2d.fillOval(x*BALL_WIDTH, y*BALL_WIDTH, BALL_WIDTH, BALL_WIDTH);
		g2d.dispose();
	}
	
	public void selectionPaint(int x,int y){
		paint();
		List<Integer> balls = new ArrayList<Integer>();
		dfs(balls,x,y,board[x][y]);
		for(int v:balls){
			int tx = inverseX(v);
			int ty = inverseY(v);
			paintBall(tx,ty,Color.BLACK);
		}
	}
	
	public void scoreReload(){
		String title = "SCORE: "+SCORE+" [";
		for(int i = 0;i < NCOLOR;i++){
			title+=colorName[i]+":";
			title+=colorNum[i]+" ";
		}
		title+="]";
		this.setTitle(title);
	}
	
	public void fall(){
		for(int x = 0;x < P_WIDTH;x++){
			int at = P_HEIGHT-1;
			for(int y = P_HEIGHT-1;y != -1;y--){
				if(board[x][y] == NULLCOLOR)continue;
				int tmp = board[x][at];
				board[x][at] = board[x][y];
				board[x][y] = tmp;
				at--;
			}
		}
	}
	public void left(){
		List<Integer> valid = new ArrayList<Integer>();
		for(int x = 0;x < P_WIDTH;x++){
			int a = 0;
			for(int y = 0;y < P_HEIGHT;y++){
				if(board[x][y] != NULLCOLOR)a++;
			}
			if(a != 0)valid.add(x);
		}
		int[][] newBoard = new int[P_WIDTH][P_HEIGHT];
		for(int x = 0;x < P_WIDTH;x++)
			for(int y = 0;y < P_HEIGHT;y++)newBoard[x][y] = NULLCOLOR;
		int at = 0;
		for(int x = 0;x < P_WIDTH;x++){
			if(at >= valid.size())break;
			int realX = valid.get(at);
			for(int y = 0;y < P_HEIGHT;y++){
				newBoard[x][y] = board[realX][y];
			}
			at++;
		}
		board = newBoard;
	}
	
	public void selectionDelete(int x,int y){
		List<Integer> balls = new ArrayList<Integer>();
		dfs(balls,x,y,board[x][y]);
		int size = balls.size();
		if(size < 2)return;
		for(int v:balls){
			int tx = inverseX(v);
			int ty = inverseY(v);
			board[tx][ty] = NULLCOLOR;
		}
		int score = (size - 2)*(size - 2);
		SCORE += score;
//		System.out.println("add:"+score);
		scoreReload();
		fall();
		left();
		paint();
	}
	
	public void mouseMove(Point point){
		int location = getBallAtLocation(point);
		if(location == -1)return;
		int x = inverseX(location);
		int y = inverseY(location);
		selectionPaint(x,y);
	}
	
	public void mouseClicked(Point point){
		int location = getBallAtLocation(point);
		if(location == -1)return;
		int x = inverseX(location);
		int y = inverseY(location);
		selectionDelete(x,y);
	}
	
	public int getBallAtLocation(Point point){
		int locx = (int) point.getX();
		int locy = (int) point.getY();
		int x = locx/BALL_WIDTH;
		int y = locy/BALL_WIDTH;
		if(x < 0 || y < 0 || x >= P_WIDTH || y >= P_HEIGHT)return -1;
		if(board[x][y] == NULLCOLOR)return -1;
		return x + y*P_WIDTH;
	}
	
	public static final int[] DIRX = {-1,0,1,0};
	public static final int[] DIRY = {0,-1,0,1};
	public void dfs(List<Integer> list,int x,int y,int color){
		int v = convert(x,y);
		if(board[x][y] == NULLCOLOR)return;
		if(board[x][y]!=color)return;
		if(list.contains(v))return;
		list.add(v);
		for(int i = 0;i < 4;i++){
			int nx = x + DIRX[i];
			int ny = y + DIRY[i];
			if(nx < 0 || ny < 0 || nx >= P_WIDTH || ny >= P_HEIGHT)continue;
			dfs(list,nx,ny,color);
		}
		return;
	}
	
	public int convert(int x,int y){
		return x + y*P_WIDTH;
	}
	public int inverseX(int v){
		return v%P_WIDTH;
	}
	public int inverseY(int v){
		return v/P_WIDTH;
	}
	
	public static void main(String[] args){
		SameGameJFrame frame = new SameGameJFrame();
		SameGameRandomWalk solver = new SameGameRandomWalk(frame.board,NCOLOR,P_WIDTH,P_HEIGHT,frame);
		solver.run();
		Thread thread = new Thread(new AnswerVisualizer(solver.answer,frame));
		thread.start();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		mouseClicked(event.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		mouseMove(event.getPoint());
	}

}
