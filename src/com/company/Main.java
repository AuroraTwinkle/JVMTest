package com.company;

public class Main {
    public static Main SAVE_HOOK =null;
    public void isAlive(){
        System.out.println("yes,i am still alive.");
    }
    @Override
    protected  void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed.");
        Main.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        SAVE_HOOK=new Main();
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);//stop to wait for Finalize method.
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead.");
        }
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);//stop to wait for Finalize method.
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i am dead.");
        }
    }
}
