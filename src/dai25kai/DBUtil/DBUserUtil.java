package dai25kai.DBUtil;

import java.util.ArrayList;
import java.util.List;

import dai25kai.User;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>DBUserUtil�N���X�́A���[�U�f�[�^�x�[�X�ƃv���O�����̘A�g�������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class DBUserUtil {
	
	/**
	 * ���ׂẴ��[�U�̖��O��Ԃ��܂��B
	 * @param user �R�}���h�����s�������[�U�̃C���X�^���X
	 * @return ���ׂẴ��[�U�̖��O����ꂽ���X�g
	 */
	public static List<String> getAllUserName(User user){
		List<String> ret = new ArrayList<String>();
		
		////
		//�Q�b�g����
		////
		
		return ret;
	}
	
	/**
	 * ���[�U�������ɂ��ă��[�U���������܂��B
	 * @param name �����ɗp���郆�[�U��
	 * @param user �R�}���h�����s�������[�U�̃C���X�^���X
	 * @return ��������(userID)����ꂽ���X�g
	 */
	public static List<String> findUser(String name, User user){
		List<String> ret = new ArrayList<String>();
		
		////
		//��������
		////
		
		return ret;
	}
	
	/**
	 * �V�������[�U���f�[�^�x�[�X�ɒǉ����܂��B
	 * @param id �V�K���[�U��ID 
	 * @param pw �V�K���[�U��PW
	 * @param name �V�K���[�U�̃��[�U��
	 * @param user �R�}���h�����s�������[�U�̃C���X�^���X
	 * @return �R�}���h�̐���
	 */
	public static boolean addUser(String id, String pw, String name, User user){
		
		////
		//�ǉ�����
		////
		
		return true;
	}
	
	/**
	 * �f�[�^�x�[�X���烆�[�U���폜���܂��B
	 * @param id �ΏۂƂȂ郆�[�U�̃��[�UID
	 * @param user �R�}���h�����s�������[�U�̃C���X�^���X
	 * @return �R�}���h�̐���
	 */
	public static boolean removeUser(String id, User user){
		
		////
		//�폜����
		////
		
		return true;
	}
	
	/**
	 * �f�[�^�x�[�X�Əƍ������O�C���������s���܂��B
	 * @param id ���O�C�����������[�U��ID
	 * @param pw ���O�C�����������[�U��PW
	 * @return ���[�U�̃C���X�^���X�A���s�ł����null
	 */
	public static User login(String id, String pw){
		
		////
		//���O�C������
		////
		
		return null;
	}
}
