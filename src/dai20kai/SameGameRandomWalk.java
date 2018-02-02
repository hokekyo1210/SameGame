package dai20kai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SameGameRandomWalk{
	
	public static final int NULLCOLOR = -9999;
	
	public Random random;
	public SameGameJFrame samaGameFrame;
	public int[][] board;
	public int N;
	public int score;
	public int P_WIDTH,P_HEIGHT;
	
	public List<Integer> answer;
	
	public SameGameRandomWalk(int[][] board,int N,int P_WIDTH,int P_HEIGHT,SameGameJFrame sameGameFrame){
		this.random = new Random();
		this.N = N;
		this.P_WIDTH = P_WIDTH;
		this.P_HEIGHT = P_HEIGHT;
		this.samaGameFrame = sameGameFrame;
		this.board = new int[P_WIDTH][P_HEIGHT];
		for(int i = 0;i < P_HEIGHT;i++){
			for(int j = 0;j < P_WIDTH;j++){
				this.board[j][i] = board[j][i];
			}
		}
		this.answer = new ArrayList<Integer>();
	}
	
	public void run(){
		while(done()){
			
		}
	}
	
	public boolean done(){
		List<Integer> targetList = new ArrayList<Integer>();
		for(int i = 0;i < P_HEIGHT;i++){
			for(int j = 0;j < P_WIDTH;j++){
				if(board[j][i] == 0)continue;
//				if(board[j][i] == 1 && random.nextDouble() < 0.9)continue;
				int score = getBalls(j,i).size();
				if(2 <= score)targetList.add(convert(j,i));
			}
		}
		if(targetList.size() == 0)return false;
		System.out.println(targetList.size());
		int target = targetList.get(random.nextInt(targetList.size()));
		int x = inverseX(target);
		int y = inverseY(target);
		
		selectionDelete(x,y);
		answer.add(convert(x,y));
		return true;
	}
	
	public List<Integer> getBalls(int x,int y){
		List<Integer> balls = new ArrayList<Integer>();
		dfs(balls,x,y,board[x][y]);
		return balls;
	}
	
	public void selectionDelete(int x,int y){
		List<Integer> balls = getBalls(x,y);
		int size = balls.size();
		if(size < 2)return;
		for(int v:balls){
			int tx = inverseX(v);
			int ty = inverseY(v);
			board[tx][ty] = NULLCOLOR;
		}
		int score = (size - 2)*(size - 2);
		this.score += score;
		fall();
		left();
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

}
