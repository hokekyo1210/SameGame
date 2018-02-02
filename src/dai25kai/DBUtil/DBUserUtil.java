package dai25kai.DBUtil;

import java.util.ArrayList;
import java.util.List;

import dai25kai.User;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>DBUserUtilクラスは、ユーザデータベースとプログラムの連携処理を記述する。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public class DBUserUtil {
	
	/**
	 * すべてのユーザの名前を返します。
	 * @param user コマンドを実行したユーザのインスタンス
	 * @return すべてのユーザの名前を入れたリスト
	 */
	public static List<String> getAllUserName(User user){
		List<String> ret = new ArrayList<String>();
		
		////
		//ゲット処理
		////
		
		return ret;
	}
	
	/**
	 * ユーザ名を元にしてユーザを検索します。
	 * @param name 検索に用いるユーザ名
	 * @param user コマンドを実行したユーザのインスタンス
	 * @return 検索結果(userID)を入れたリスト
	 */
	public static List<String> findUser(String name, User user){
		List<String> ret = new ArrayList<String>();
		
		////
		//検索処理
		////
		
		return ret;
	}
	
	/**
	 * 新しいユーザをデータベースに追加します。
	 * @param id 新規ユーザのID 
	 * @param pw 新規ユーザのPW
	 * @param name 新規ユーザのユーザ名
	 * @param user コマンドを実行したユーザのインスタンス
	 * @return コマンドの成否
	 */
	public static boolean addUser(String id, String pw, String name, User user){
		
		////
		//追加処理
		////
		
		return true;
	}
	
	/**
	 * データベースからユーザを削除します。
	 * @param id 対象となるユーザのユーザID
	 * @param user コマンドを実行したユーザのインスタンス
	 * @return コマンドの成否
	 */
	public static boolean removeUser(String id, User user){
		
		////
		//削除処理
		////
		
		return true;
	}
	
	/**
	 * データベースと照合しログイン処理を行います。
	 * @param id ログインしたいユーザのID
	 * @param pw ログインしたいユーザのPW
	 * @return ユーザのインスタンス、失敗であればnull
	 */
	public static User login(String id, String pw){
		
		////
		//ログイン処理
		////
		
		return null;
	}
}
