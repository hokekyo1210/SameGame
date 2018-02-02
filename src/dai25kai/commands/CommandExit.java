package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exitクラスは、Exitコマンドの処理を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class CommandExit implements ICommand{

	@Override
	public String getCmdName() {
		return "exit";
	}

	@Override
	public boolean run(User user, String[] args, CommandLine commandLine) {
		if(user == null)return false;
		if(user.isAdmin()){
			System.out.println("システムを終了します。");
			commandLine.exit();
		}else{
			System.out.println("このコマンドはadmin以外実行できません。");
		}
		return true;
	}

}
