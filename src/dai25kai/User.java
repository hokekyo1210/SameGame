package dai25kai;

import java.util.List;

import dai25kai.DBUtil.DBPermissionUtil;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>User�N���X�́A���ꂼ��̃��[�U�[�̏����C���X�^���X�ɕێ�����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class User {
	
	private String name;
	private String userID;
	private int points;
	
	/**
	 * User�N���X�̃C���X�^���X���쐬���܂��B
	 * @param name ���[�U�̖��O
	 * @param userID ���[�U��ID
	 * @param points ���[�U�̃|�C���g
	 */
	public User(String name, String userID, int points){
		this.name = name;
		this.userID = userID;
		this.points = points;
	}
	
	/**
	 * 
	 * @return ���[�U��ID
	 */
	public String getUserID(){
		return userID;
	}
	
	/**
	 * 
	 * @return ���[�U��Admin�����������B
	 */
	public boolean isAdmin(){
		return hasPermission("admin","true");
	}
	
	/**
	 * ���[�U�������������Ă��邩���肷�郁�\�b�h�ł��B
	 * @param key ������key
	 * @param value ������value
	 * @return �����������Ă��邩�B
	 */
	public boolean hasPermission(String key, String value){
		return DBPermissionUtil.hasPermission(userID, key, value);
	}

}
