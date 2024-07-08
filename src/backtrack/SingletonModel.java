package backtrack;

public class SingletonModel {
    private static volatile SingletonModel singletonModel;

    private SingletonModel() {
    }

    public static SingletonModel getInstance() {

        if (singletonModel == null) {
            synchronized (SingletonModel.class) {
                if (singletonModel == null) {
                    singletonModel = new SingletonModel();
                }
            }
        }
        return singletonModel;
    }
}
