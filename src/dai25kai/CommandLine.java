package dai25kai;

import java.util.List;
import java.util.Scanner;

import dai25kai.commands.CommandAdd;
import dai25kai.commands.CommandExit;
import dai25kai.commands.CommandList;
import dai25kai.commands.CommandLogin;
import dai25kai.commands.CommandLogout;
import dai25kai.commands.ICommand;

/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>CommandLineクラスは、端末上で実行されるコマンドラインの動作を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class CommandLine {
	
	private static ICommand[] commands = {new CommandLogin(), new CommandList(), new CommandLogout(), new CommandExit(), new CommandAdd()
										};
	
	private User user = null;

	/**
	 * コマンドによるログイン成功時に呼ばれるメソッドです。
	 * @param user ログインに成功したユーザーのインスタンス
	 */
	public void login(User user){
		this.user = user;
	}
	
	/**
	 * コマンドによるログアウト成功時に呼ばれるメソッドです。
	 */
	public void logout(){
		user = null;
	}
	
	/**
	 * このメソッドにより、コマンドラインの処理が実行されます。
	 */
	public void run(){
		Scanner scan = new Scanner(System.in);
		while(true){
			String userName = user == null?"":user.getUserID();
			System.out.print(userName+"#");
			String cmd = scan.nextLine();
			String[] args = cmd.split(" ");
			ICommand targetCmd = null;
			for(int i = 0;i < commands.length;i++){
				if(commands[i].getCmdName().equalsIgnoreCase(args[0])){
					targetCmd = commands[i];
				}
			}
			if(targetCmd==null || !targetCmd.run(user, args, this)){
				System.out.println("Command Error!");
			}
		}
	}
	
	/**
	 * コマンドによるexit成功時に呼ばれるメソッドです。
	 */
	public void exit(){
		System.exit(0);
	}

}
