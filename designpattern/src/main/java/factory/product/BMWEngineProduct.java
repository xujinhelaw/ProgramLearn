package factory.product;

public class BMWEngineProduct extends EngineProduct {

    @Override
    public void provideMotivation(){
        System.out.println("provide motivation for BMW car!");
    }
}
