package dai25kai.commands;

import java.util.List;

import dai25kai.CommandLine;
import dai25kai.User;
import dai25kai.DBUtil.DBUserUtil;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exit�N���X�́Alist�R�}���h�̏������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class CommandList implements ICommand{

	@Override
	public String getCmdName() {
		return "list";
	}

	@Override
	public boolean run(User user, String[] args, CommandLine commandLine) {
		if(user == null)return false;
		if(args.length != 2)return false;
		if(args[1].equals("user")){
			System.out.println("���[�U�[�̈ꗗ��\��");
			List<String> userNames = DBUserUtil.getAllUserName(user);
			for(String name: userNames){
				System.out.println(name);
			}
			return true;
		}else{
			return false;
		}
	}

}
