package com.gmail.chibitopoochan.soqlexec.soap.wrapper;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

/**
 * SalesforceAPIのラップ.
 * 実API呼び出しを分離して依存を下げます。
 * テストを考慮し、インスタンス化は{@link #createNewInstance(ConnectorConfig)}で行うため、
 * 使用前に呼び出しが必要です。他のメソッドは元のAPIと同じシグネチャとします。
 */
public interface ConnectionWrapper {
	/**
	 * {@link com.sforce.soap.partner.PartnerConnection}のインスタンス化
	 * @param config インスタンス化のパラメータ
	 * @throws ConnectionException 接続情報のエラー
	 */
	public void createNewInstance(ConnectorConfig config) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#login(String, String)}のラップ.
	 * 詳細は呼び出し先のAPIを参照のこと
	 * @param username ユーザ名
	 * @param password パスワード
	 * @return ログイン結果
	 * @throws ConnectionException 接続エラー
	 */
	public LoginResultWrapper login(String username, String password) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#logout()}のラップ
	 * 詳細は呼び出し先のAPIを参照のこと
	 * @throws ConnectionException 接続エラー
	 */
	public void logout() throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#describeGlobal()}のラップ
	 * @return グローバル記述結果
	 * @throws ConnectionException 接続エラー
	 */
	public DescribeGlobalResultWrapper describeGlobal() throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#describeSObject(String)}のラップ
	 * @param name SObjectタイプ
	 * @return 項目情報
	 * @throws ConnectionException 接続エラー
	 */
	public DescribeSObjectResultWrapper describeSObject(String name) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#setQueryOptions(int)}のラップ
	 * @param batchSize 取得件数
	 */
	public void setQueryOption(int batchSize);

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#getQueryOptions()}のラップ
	 * バッチサイズ取得のため、内部でgetBatchSize()を呼び出している。
	 * @return 取得件数
	 */
	public int getQueryOption();

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#query(String)}}
	 * @param soql SOQL
	 * @return 実行結果
	 * @throws ConnectionException 接続エラー
	 */
	public QueryResultWrapper query(String soql) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#queryAll(String)}のラップ
	 * @param soql SOQL
	 * @return 実行結果
	 * @throws ConnectionException 接続エラー
	 */
	public QueryResultWrapper queryAll(String soql) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#queryMore(String)}のラップ
	 * @param queryLocator クエリ位置
	 * @return 実行結果
	 * @throws ConnectionException 接続エラー
	 */
	public QueryResultWrapper queryMore(String queryLocator) throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#getUserInfo()}のラップ
	 * @return ユーザ情報
	 * @throws ConnectionException 接続エラー
	 */
	public GetUserInfoResultWrapper getUserInfo() throws ConnectionException;

	/**
	 * {@link com.sforce.soap.partner.PartnerConnection#setLocaleOptions(String, boolean)}のラップ
	 * @param language 言語
	 * @param localizeErrors
	 */
	public void setLocaleOptions(String language, boolean localizeErrors);

}
