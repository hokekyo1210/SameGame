package dai20kai;

import java.util.List;

public class AnswerVisualizer implements Runnable{
	
	public List<Integer> answer;
	public SameGameJFrame frame;
	
	public AnswerVisualizer(List<Integer> answer, SameGameJFrame frame){
		this.answer = answer;
		this.frame = frame;
	}

	@Override
	public void run() {
		for(int index = 0;index < answer.size();index++){
			int v = answer.get(index);
			int x = inverseX(v);
			int y = inverseY(v);
			frame.selectionDelete(x, y);
			try {
				Thread.sleep(SameGameJFrame.sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int inverseX(int v){
		return v%(SameGameJFrame.P_WIDTH);
	}
	public int inverseY(int v){
		return v/(SameGameJFrame.P_WIDTH);
	}

}
