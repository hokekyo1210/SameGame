package dai25kai;

import java.util.Scanner;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Pashiri�́A�v���O�����̏��߂ɐ��������C���X�^���X�ł���B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class Pashiri {
	
	/**
	 * ���̃��\�b�h�́A�v���O�����̏��߂ɌĂ΂�郁�\�b�h�ł��B
	 */
	public void runCommandLine(){
		CommandLine commandLine = new CommandLine();
		commandLine.run();
	}

}
