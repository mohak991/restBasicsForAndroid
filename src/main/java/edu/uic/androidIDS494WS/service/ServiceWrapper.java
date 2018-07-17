package edu.uic.androidIDS494WS.service;

public final class ServiceWrapper {
	
	public static final AppService service = new AppService();
	
	private ServiceWrapper() {}
	
	public static AppService getInstance() {
		return service;
	}
}
