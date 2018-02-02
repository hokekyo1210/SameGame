package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exit�N���X�́Alogout�R�}���h�̏������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
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
