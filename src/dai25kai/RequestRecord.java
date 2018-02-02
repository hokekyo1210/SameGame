package dai25kai;

import java.util.Date;

public class RequestRecord {
	
	private int requestID;		///依頼ID
	private String name;		///依頼名
	private int clientID;		///発注者ID
	private int contractorID;	///受注者ID
	private int point;			///ポイント
	private int advancePoint;	///前金
	private String detail;		///内容
	private int status;			///状態
	private java.util.Date deadline;		///期限

}
