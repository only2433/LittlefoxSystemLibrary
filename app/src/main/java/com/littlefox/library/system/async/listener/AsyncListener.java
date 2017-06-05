package com.littlefox.library.system.async.listener;

public interface AsyncListener
{
	void onRunningStart();
	/**
	 * Async 동작이 끝난 후 사용한 Code 값과 Result Object 를 전달
	 * @param code Section Code of User
	 * @param mObject Result Value
	 */
	void onRunningEnd(String code, Object mObject);
	void onRunningCanceled();
	void onRunningProgress(Integer progress);
	
	/**
	 * 결과를 보내기전에 먼저 보낼 정보가 있다면 해당 함수를 이용한다.
	 * @param object
	 */
	void onRunningAdvanceInformation(Object object);
	
	/**
	 * 에러가 생길시 전달
	 * @param code Section Code of User
	 * @param message Error Message
	 */
	void onErrorListener(String code, String message);
	
}
