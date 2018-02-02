package dai25kai.commands;

import dai25kai.CommandLine;
import dai25kai.User;
/**
 * 設計したクラスは11個(Pashiri, CommandLine, Permission, User, CommandAdd, CommandExit, CommandList, CommandLogin, CommandLogout, ICommand, DBPermissionUtil, DBUserUtil)
 * 
 * <p>ICommandは、各コマンドが実装していなければならないインタフェースである。</p>
 * 
 * @author 5415 土田 雄輝
 *
 */
public interface ICommand {
	
	/**
	 * コマンドの名前を返します。
	 * @return コマンド名
	 */
	abstract String getCmdName();
	
	/**
	 * コマンドを実行します。
	 * @param user コマンドを実行したユーザのインスタンス
	 * @param args コマンド
	 * @param commandLine CommandLineのインスタンス
	 * @return コマンドの成否
	 */
	abstract boolean run(User user, String[] args, CommandLine commandLine);

}
