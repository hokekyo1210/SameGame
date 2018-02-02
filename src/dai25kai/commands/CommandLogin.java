package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
import dai25kai.DBUtil.DBUserUtil;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exitクラスは、loginコマンドの処理を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class CommandLogin implements ICommand{

	@Override
	public String getCmdName() {
		return "login";
	}

	@Override
	public boolean run(User user, String[] args, CommandLine commandLine) {
		if(user != null)return false;
		if(args.length != 3)return false;
		String id = args[1];
		String pw = args[2];
		User loginUser = DBUserUtil.login(id, pw);
		if(loginUser == null){
			System.out.println("login error!");
			return true;
		}
		commandLine.login(loginUser);
		return true;
	}

}
