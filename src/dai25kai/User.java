package dai25kai;

import java.util.List;

import dai25kai.DBUtil.DBPermissionUtil;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Userクラスは、それぞれのユーザーの情報をインスタンスに保持する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class User {
	
	private String name;
	private String userID;
	private int points;
	
	/**
	 * Userクラスのインスタンスを作成します。
	 * @param name ユーザの名前
	 * @param userID ユーザのID
	 * @param points ユーザのポイント
	 */
	public User(String name, String userID, int points){
		this.name = name;
		this.userID = userID;
		this.points = points;
	}
	
	/**
	 * 
	 * @return ユーザのID
	 */
	public String getUserID(){
		return userID;
	}
	
	/**
	 * 
	 * @return ユーザがAdmin権限を持つか。
	 */
	public boolean isAdmin(){
		return hasPermission("admin","true");
	}
	
	/**
	 * ユーザが権限を持っているか判定するメソッドです。
	 * @param key 権限のkey
	 * @param value 権限のvalue
	 * @return 権限を持っているか。
	 */
	public boolean hasPermission(String key, String value){
		return DBPermissionUtil.hasPermission(userID, key, value);
	}

}
