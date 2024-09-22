package model;

import java.util.List;

/**
 * 工場情報を表すクラス
 * @author Y.Tsuruta
 */

public class Factory {
	/******** フィールド ******************************************/
	/**
	 * 工場名
	 */
	private String name;

	/**
	 * パーツリスト
	 */
	private List<Part> listPrt;

	/******** コンストラクタ **************************************/
	/**
	 * フィールド初期化コンストラクタ
	 * @param name
	 * @param listPrt
	 */
	public Factory(String name, List<Part> listPrt) {
		this.name = name;
		this.listPrt = listPrt;
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return listProd
	 */
	public List<Part> getListPrt() {
		return listPrt;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/*--------------------通常メソッド--------------------*/
	/**
	 * パーツを追加する
	 * @param prod 追加する商品
	 */
	public void add(Part prt) {
		listPrt.add(prt);
	}

	/**
	 * 特定のパーツを除去する
	 * @param index 削除するパーツのリスト内のインデックス
	 */
	public void remove(int index) {
		listPrt.remove(index);
	}
	
	/**
	 * 全てのパーツを除去する
	 */
	public void clear() {
		listPrt.clear();
	}

}
