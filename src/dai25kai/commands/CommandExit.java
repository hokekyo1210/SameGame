package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Exit�N���X�́AExit�R�}���h�̏������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
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
			System.out.println("�V�X�e�����I�����܂��B");
			commandLine.exit();
		}else{
			System.out.println("���̃R�}���h��admin�ȊO���s�ł��܂���B");
		}
		return true;
	}

}
