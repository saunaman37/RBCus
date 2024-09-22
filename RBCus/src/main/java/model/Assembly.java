package model;

import java.util.List;

/**
 * アセン情報を表すクラス
 * @author Y.Tsuruta
 */

public class Assembly {
	/******** フィールド ******************************************/
	/**
	 * ユーザーID
	 */
	private String userId;

	/**
	 * アセン内の商品リスト
	 */
	private List<Part> listPrt;

	/******** コンストラクタ **************************************/
	/**
	 * フィールド初期化コンストラクタ
	 * @param userId
	 * @param listPrt
	 */
	public Assembly(String userId, List<Part> listPrt) {
		this.userId = userId;
		this.listPrt = listPrt;
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return listItem
	 */
	public List<Part> getListPrt() {
		return listPrt;
	}

	/*--------------------通常メソッド--------------------*/
	/**
	 * アセンにパーツを追加する
	 * @param prt 追加する商品
	 */
	public void add(Part prt) {
		listPrt.add(prt);
	}

	/**
	 * アセン内の特定のパーツを除去する
	 * @param index 削除するパーツのリスト内のインデックス
	 */
	public void remove(int index) {
		listPrt.remove(index);
	}
	
	/**
	 * アセン内の全ての商品を除去する
	 */
	public void clear() {
		listPrt.clear();
	}
	
	/**
	 * アセン内のパーツの合計重量を取得する
	 * @return 合計重量
	 */
	public int getTotalWeight() {
		int total = 0;
		for (Part prt : listPrt) {
			total += prt.getWeight();
		}
		
		return total;
	}
	
	/**
	 * アセン内のパーツの合計重量を文字列にして返す(３桁カンマ区切り＋kg)
	 * @return
	 */
	public String getTotalWeightString() {
		return String.format("%,d", getTotalWeight()) + "g";
	}

	/**
	 * アセン内のパーツの価格合計を取得する
	 * @return 価格合計
	 */
	public int getTotalPrice() {
		int total = 0;
		for (Part prt : listPrt) {
			total += prt.getPrice();
		}
		
		return total;
	}
	
	/**
	 * アセン内のパーツの価格合計を文字列にして返す(３桁カンマ区切り＋円)
	 * @return
	 */
	public String getTotalPriceString() {
		return String.format("%,d", getTotalPrice()) + "円";
	}

}
