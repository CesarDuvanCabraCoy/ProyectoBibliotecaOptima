package models;

public abstract class MyThread implements Runnable{

	private Thread thread;
	private int sleep;
	private boolean stop;
	private boolean pause;
	
	public MyThread(int sleep) {
		this.sleep = sleep;
		thread = new Thread(this);
	}
	
	@Override
	public void run() {
		while (!stop) {
			executeTask();
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				if (stop) {
					break;
				}
				while (pause) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public synchronized void stop() {
		stop = true;
		notify();
	}
	
	public synchronized void pause() {
		pause = true;
		notify();
	}
	
	public synchronized void resume() {
		pause = false;
		notify();
	}
	
	abstract void executeTask();
}