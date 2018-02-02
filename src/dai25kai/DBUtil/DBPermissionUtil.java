package dai25kai.DBUtil;

import java.util.ArrayList;
import java.util.List;

import dai25kai.Permission;
/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>DBPermissionUtil�N���X�́A�����f�[�^�x�[�X�ƃv���O�����̘A�g�������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class DBPermissionUtil {
	
	/**
	 * �ΏۂƂȂ郆�[�U�������������Ă��邩���肷�郁�\�b�h�ł��B
	 * @param userID �ΏۂƂȂ郆�[�U��ID
	 * @param key ������key
	 * @param value ������value
	 * @return ���[�U�������������Ă��邩�B
	 */
	public static boolean hasPermission(String userID, String key, String value){
		List<Permission> permissions = DBPermissionUtil.getPermissions(userID);
		for(Permission permission : permissions){
			if(permission.equals(key, value))return true;
		}
		return false;
	}
	
	/**
	 * �ΏۂƂȂ郆�[�U�Ɍ�����t�^���܂��B
	 * @param userID �ΏۂƂȂ郆�[�U��ID
	 * @param key ������key
	 * @param value ������value
	 */
	public static void setPermission(String userID, String key, String value){
		
		////
		//�Z�b�g����
		////
	}
	
	/**
	 * �ΏۂƂȂ郆�[�U�������Ă��錠�������ׂĕԂ��܂��B
	 * @param userID �ΏۂƂȂ郆�[�U��ID
	 * @return ���[�U�������ׂĂ̌�������ꂽ���X�g
	 */
	public static List<Permission> getPermissions(String userID){
		List<Permission> ret =  new ArrayList<Permission>();
		
		////
		//�Q�b�g����
		////
		
		return ret;
	}

}
