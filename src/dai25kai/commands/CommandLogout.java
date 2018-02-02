package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exitクラスは、logoutコマンドの処理を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class CommandLogout implements ICommand{

	@Override
	public String getCmdName() {
		return "logout";
	}

	@Override
	public boolean run(User user, String[] args, CommandLine commandLine) {
		if(user == null)return false;
		if(args.length != 1)return false;
		commandLine.logout();
		return true;
	}

}
