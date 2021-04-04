package factory;

import factory.product.BMWEngineProduct;
import factory.product.BenzEngineProduct;

public class Client {
    public static void main(String[] args) {
        CommonFactory factory = new CommonFactory();
        BMWEngineProduct bmwEngineProduct = factory.getInstance(BMWEngineProduct.class);
        BenzEngineProduct benzEngineProduct = factory.getInstance(BenzEngineProduct.class);
        bmwEngineProduct.provideMotivation();
        benzEngineProduct.provideMotivation();
    }
}
