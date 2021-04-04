package factory;

import factory.product.EngineProduct;

public abstract class AbstractFactory {
    abstract <T extends EngineProduct> T getInstance(Class<T> cls);
}
