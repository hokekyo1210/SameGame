package dai25kai;

/**
 * �݌v�����N���X��11��(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>Permission�N���X�́Akey��value�̑΂ŁA�������L�q����B</p>
 * 
 * @author 5415 �y�c �Y�P
 *
 */
public class Permission {
	
	String key;
	String value;
	
	/**
	 * Permission�N���X�̃C���X�^���X���쐬���܂��B
	 * @param key ������key
	 * @param value ������value
	 */
	public Permission(String key, String value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Permission����v���Ă��邩��Ԃ��܂��B
	 * @param key_ ������key
	 * @param value_ ������value
	 * @return key�����value����v���Ă��邩�B
	 */
	public boolean equals(String key_, String value_){
		return (key.equals(key_) && value.equals(value_));
	}

}
