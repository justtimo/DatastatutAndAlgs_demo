package com.example.demo.fanxing.cha869;

public interface Task {
    void run() throws  Exception;

    @SuppressWarnings("unchecked")
    static <T extends Throwable> void throwAs(Throwable t) throws T {
        throw (T) t;
    }
    static Runnable asRunnable(Task task){
        return ()->{
            try {
                task.run();
            } catch (Exception e) {
                Task.<RuntimeException>throwAs(e);
            }
        };
    }
}
class Test{
    public static void main(String[] args) {
//        Thread thread = new Thread(
//                Task.asRunnable(
//                        () -> {
//                            Thread.sleep(1000);
//                            System.out.println("hello ,wordl");
//                            throw new Exception("check this out!");
//                        }
//                )
//        );
//        thread.start();

        Thread thread1 = new Thread(
                        () -> {
                            try {
                                Thread.sleep(1000);
                                throw new Exception("check this out!");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                System.out.println("hello ,wordl");
                            }
                        }

        );
        thread1.start();
    }
}
