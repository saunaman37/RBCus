package model;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

/**
 * 工場オペレーションクラス
 * @author Y.Tsuruta
 */

public class Operation {
	/**
	 * ログイン時の処理
	 * @param userId リクエストパラメータ
	 * @param password リクエストパラメータ
	 * @param session セッションオブジェクト
	 * @return true .. 正常、false .. ID／パスワード誤り
	 */
	public boolean loginProc(String userId, String password, HttpSession session) {

		// ログイン認証
		boolean result = authenticate(userId, password);

		if (result) {
			// 工場データの作成⇒セッションに格納
			Factory factory = makeFactory();
			session.setAttribute("factory", factory);
			
			// アセンの作成（userId設定・パーツリストは空）⇒セッションに格納
			Assembly assembly = new Assembly(userId, new ArrayList<Part>());
			session.setAttribute("assembly", assembly);
		}

		return result;
	}

	/**
	 * 認証する
	 * @param userId ユーザID
	 * @param password パスワード
	 * @return 結果 (true / false)
	 */
	private boolean authenticate(String userId, String password) {

		// ★ここでは password = "pass" であれば true とする
		boolean result = password.equals("pass");

		return result;
	}
	/**
	 * 工場情報（工場選択データ（リスト））を作成する
	 * @return 工場情報
	 */
	private Factory makeFactory() {

		// 工場情報作成
		Factory factory = new Factory("ROAD BIKE CUSTOM", new ArrayList<Part>());
		
		// 商品追加
		factory.add(new Part("FRAME", "CARBON（S-WORKS Aethos）", 550, 660000));
		factory.add(new Part("FRAME", "CARBON（S-WORKS TARMAC SL8）", 1043, 792000));
		factory.add(new Part("FRAME", "CARBON（TREK Madone SLR Gen8）", 1146, 790000));
		factory.add(new Part("FRAME", "ALUMINUM（RIDLEY Fenix SLA）", 1992, 79800));
		factory.add(new Part("FRAME", "CHROMOLY（HOLKS TOEI）", 2720, 66000));
		factory.add(new Part("FRAME", "CHROMOLY（TESTAIH）", 2300, 28000));
		factory.add(new Part("HANDLE", "SPECIALIZED ROVAL RAPIDE COCKPIT", 310, 85000));
		factory.add(new Part("HANDLE", "TREK Madone KVF エアロハンドルバー", 333, 103600));
		factory.add(new Part("COMPO", "105(R7200)", 3055, 130106));
		factory.add(new Part("COMPO", "ULTEGRA Di2(R8170)", 2716, 278055));
		factory.add(new Part("COMPO", "DURA-ACE Di2(R8170)", 2508, 453866));
		factory.add(new Part("WHEEL", "CARBON（MAVIC COSMIC ALTIMATE45）", 1255, 528000));
		factory.add(new Part("WHEEL", "CARBON（SHIMANO ULTEGRA C50）", 1570, 205756));
		factory.add(new Part("WHEEL", "ALUMINUM（MAVIC KSYRIUM SL）", 1550, 126500));
		factory.add(new Part("SADDLE", "CARBON（S-WORKS PHENOM MIRROR)", 223, 55000));
		factory.add(new Part("SADDLE", "CARBON（TREK Aeolus RSL）", 142, 55900));
		factory.add(new Part("TIRE", "Panaracer AGILEST", 230, 8410));
		factory.add(new Part("TIRE", "PIRELLI P ZERO RACE", 205, 12400));
		factory.add(new Part("TIRE", "Continental GP5000", 200, 11000));
		factory.add(new Part("TIRE", "BONTRAGER R2", 245, 6900));
		
		return factory ;
	}
	/**
	 * ログアウト時の処理
	 * @param session
	 */
	public void logoutProc(HttpSession session) {

		session.invalidate();
		
	}

	/**
	 * パーツ追加処理
	 * @param idx パーツ一覧の選択した商品のidx (セッション：store内)
	 * @param session セッションオブジェクト
	 */
	public void addPrt(int idx, HttpSession session) {
		
		// 工場情報・アセン情報の取得（セッションより）
		Factory factory = (Factory) session.getAttribute("factory");
		Assembly assembly = (Assembly) session.getAttribute("assembly");

		if ((factory != null) && (assembly != null)) {
			// アセンに指定のパーツを追加
			assembly.add(factory.getListPrt().get(idx));

			// セッションに再度格納
			session.setAttribute("assembly", assembly);
		}

	}

	/**
	 * アセンからパーツ削除処理
	 * @param idx アセンの中の選択した商品のidx
	 * @param session セッションオブジェクト
	 */
	public void removePrt(int idx, HttpSession session) {
	
		// アセン内商品情報の取得（セッションより）
		Assembly assembly = (Assembly) session.getAttribute("assembly");
	
		if (assembly != null) {
			// アセンから指定のパーツを削除
			assembly.remove(idx);

			// セッションに書き戻す
			session.setAttribute("assembly", assembly);
		}
			
	}
	
	/**
	 * 完成処理
	 * @param session セッションオブジェクト
	 */
	public void total(HttpSession session) {

		// アセン内商品情報の取得
		Assembly assembly = (Assembly) session.getAttribute("assembly");

		if ( assembly!= null) {
			// セッションに格納（完成済みデータ）
			session.setAttribute("total", assembly);

			// アセン情報の新規作成⇒セッションに格納
			Assembly newAssembly = new Assembly(assembly.getUserId(), new ArrayList<Part>());
			session.setAttribute("assembly", newAssembly);
		}

	}

}
