package factory;

import factory.product.EngineProduct;

public class CommonFactory extends AbstractFactory {
    public <T extends EngineProduct> T getInstance(Class<T> cls) {
        EngineProduct product = null;
        try {
            product = cls.newInstance();
        } catch (Exception e) {
            System.out.println("produce product failed!");
        }
        return (T)product;
    }
}
