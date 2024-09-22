package model;
/**
 * パーツクラス
 * @author Y.Tsuruta
 */
public class Part {
	/******** フィールド ******************************************/
	/**
	 * パーツID
	 */
	private String id;
	
	/**
	 * パーツ名
	 */
	private String name;
	
	/**
	 * 重量
	 */
	private int weight;
	
	/**
	 * 値段
	 */
	private int price;

	/******** コンストラクタ **************************************/
	/**
	 * フィールド初期化コンストラクタ
	 * @param id
	 * @param name
	 * @param weight
	 * @param price
	 */
	public Part(String id, String name, int weight, int price) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	/******** メソッド ******************************************/
	/*--------------------getter/setter--------------------*/
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * @return weight
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 重量を文字列で返す（３桁カンマ区切り＋"g"）
	 * @return 重量 + g
	 */
	public String getWeightString() {
		return String.format("%,d", weight) + "g";
	}
	
	/**
	 * 値段を文字列で返す（３桁カンマ区切り＋"g"）
	 * @return 重量 + 円
	 */
	public String getPriceString() {
		return String.format("%,d", price) + "円";
	}

}
