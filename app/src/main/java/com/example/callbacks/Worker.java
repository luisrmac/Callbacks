package com.example.callbacks;

public class Worker {

    public void doSomething(final WorkerCallback callback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++) {
                    try {
                        Thread.sleep(1000); // this should actually be long operation
                        callback.onUpdate(i + " " + Thread.currentThread().getName());
                    } catch (InterruptedException ie) {
                        callback.onError(ie.getMessage());
                        ie.printStackTrace();
                    }
                }
                callback.onFinished("Finished worker");
            }
        });
        thread.start();
    }

    interface WorkerCallback {
        void onUpdate(String update);
        void onFinished(String message);
        void onError(String error);
    }
}
