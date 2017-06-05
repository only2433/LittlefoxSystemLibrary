package com.littlefox.library.system.version_check;

public interface MarketVersionCheckListener
{
	/**
	 * 실패 시 Exception Log를 전달한다.
	 * @param exception Exception Log
	 */
	void onFail(String exception);
	
	/**
	 * 성공 시 마켓 버젼을 보내준다. ( 패키지가 같은데 버젼이 두개일 경우는 제대로 된 값을 전달 받지 못한다.)
	 * @param marketVersion Play Store 에 저장된 마켓 버젼
	 */
	void onSuccess(String marketVersion);
}
