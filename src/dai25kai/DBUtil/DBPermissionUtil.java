package dai25kai.DBUtil;

import java.util.ArrayList;
import java.util.List;

import dai25kai.Permission;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>DBPermissionUtilクラスは、権限データベースとプログラムの連携処理を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class DBPermissionUtil {
	
	/**
	 * 対象となるユーザが権限を持っているか判定するメソッドです。
	 * @param userID 対象となるユーザのID
	 * @param key 権限のkey
	 * @param value 権限のvalue
	 * @return ユーザが権限を持っているか。
	 */
	public static boolean hasPermission(String userID, String key, String value){
		List<Permission> permissions = DBPermissionUtil.getPermissions(userID);
		for(Permission permission : permissions){
			if(permission.equals(key, value))return true;
		}
		return false;
	}
	
	/**
	 * 対象となるユーザに権限を付与します。
	 * @param userID 対象となるユーザのID
	 * @param key 権限のkey
	 * @param value 権限のvalue
	 */
	public static void setPermission(String userID, String key, String value){
		
		////
		//セット処理
		////
	}
	
	/**
	 * 対象となるユーザが持っている権限をすべて返します。
	 * @param userID 対象となるユーザのID
	 * @return ユーザが持つすべての権限を入れたリスト
	 */
	public static List<Permission> getPermissions(String userID){
		List<Permission> ret =  new ArrayList<Permission>();
		
		////
		//ゲット処理
		////
		
		return ret;
	}

}
