package com.run.sango.controller;

import java.util.concurrent.ThreadFactory;

public class WorkerThreadFactory implements ThreadFactory {
		
	@Override
	public Thread newThread(Runnable r) {
        final Thread t = new Thread(r, "WorkerThread");
        return t;
	}
}
