package dai25kai;

/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Permissionクラスは、keyとvalueの対で、権限を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class Permission {
	
	String key;
	String value;
	
	/**
	 * Permissionクラスのインスタンスを作成します。
	 * @param key 権限のkey
	 * @param value 権限のvalue
	 */
	public Permission(String key, String value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Permissionが一致しているかを返します。
	 * @param key_ 権限のkey
	 * @param value_ 権限のvalue
	 * @return keyおよびvalueが一致しているか。
	 */
	public boolean equals(String key_, String value_){
		return (key.equals(key_) && value.equals(value_));
	}

}
