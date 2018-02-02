package dai25kai;

import java.util.Scanner;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Pashiriは、プログラムの初めに生成されるインスタンスである。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class Pashiri {
	
	/**
	 * このメソッドは、プログラムの初めに呼ばれるメソッドです。
	 */
	public void runCommandLine(){
		CommandLine commandLine = new CommandLine();
		commandLine.run();
	}

}
