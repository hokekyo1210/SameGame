package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>ICommand�́A�e�R�}���h���������Ă��Ȃ���΂Ȃ�Ȃ��C���^�t�F�[�X�ł���B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public interface ICommand {
	
	/**
	 * �R�}���h�̖��O��Ԃ��܂��B
	 * @return �R�}���h��
	 */
	abstract String getCmdName();
	
	/**
	 * �R�}���h�����s���܂��B
	 * @param user �R�}���h�����s�������[�U�̃C���X�^���X
	 * @param args �R�}���h
	 * @param commandLine CommandLine�̃C���X�^���X
	 * @return �R�}���h�̐���
	 */
	abstract boolean run(User user, String[] args, CommandLine commandLine);

}
