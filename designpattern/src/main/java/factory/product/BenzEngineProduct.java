package factory.product;

public class BenzEngineProduct extends EngineProduct {

    @Override
    public void provideMotivation(){
        System.out.println("provide motivation for Benz car!");
    }
}
