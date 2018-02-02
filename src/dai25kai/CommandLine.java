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
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>CommandLine�N���X�́A�[����Ŏ��s�����R�}���h���C���̓�����L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class CommandLine {
	
	private static ICommand[] commands = {new CommandLogin(), new CommandList(), new CommandLogout(), new CommandExit(), new CommandAdd()
										};
	
	private User user = null;

	/**
	 * �R�}���h�ɂ�郍�O�C���������ɌĂ΂�郁�\�b�h�ł��B
	 * @param user ���O�C���ɐ����������[�U�[�̃C���X�^���X
	 */
	public void login(User user){
		this.user = user;
	}
	
	/**
	 * �R�}���h�ɂ�郍�O�A�E�g�������ɌĂ΂�郁�\�b�h�ł��B
	 */
	public void logout(){
		user = null;
	}
	
	/**
	 * ���̃��\�b�h�ɂ��A�R�}���h���C���̏��������s����܂��B
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
	 * �R�}���h�ɂ��exit�������ɌĂ΂�郁�\�b�h�ł��B
	 */
	public void exit(){
		System.exit(0);
	}

}
