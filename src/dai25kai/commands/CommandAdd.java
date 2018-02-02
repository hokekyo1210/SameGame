package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
import dai25kai.DBUtil.DBPermissionUtil;
import dai25kai.DBUtil.DBUserUtil;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>CommandAdd�N���X�́Auser�����permission�̒ǉ��R�}���h�̏������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class CommandAdd implements ICommand{

	@Override
	public String getCmdName() {
		return "add";
	}

	@Override
	public boolean run(User user, String[] args, CommandLine commandLine) {
		if(user == null)return false;
		if(args[1].equals("user")){
			String id = args[2];
			String pw = args[3];
			String name = args[4];
			DBUserUtil.addUser(id, pw, name, user);
		}else if(args[1].equals("permission")){
			String userID = args[2];
			String key = args[3];
			String value = args[4];
			DBPermissionUtil.setPermission(userID, key, value);
		}
		return false;
	}
	

}
