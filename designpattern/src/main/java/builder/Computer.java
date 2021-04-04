package builder;

public class Computer {
    private String cpu;
    private String ram;
    private String mouse;//可选
    private String keyboard;//可选
    private String display;//可选

    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.mouse = builder.mouse;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }

    public static class Builder{
        private String cpu;
        private String ram;
        private String mouse;//可选
        private String keyboard;//可选
        private String display;//可选

        public Builder(String cpu,String ram){
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setMouse(String mouse) {
            this.mouse = mouse;
            return this;
        }
        public Builder setKeyboard(String keyboard){
            this.keyboard = keyboard;
            return this;
        }
        public Builder setDisplay(String display){
            this.display = display;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("intel", "samsung")
                .setMouse("logic")
                .setKeyboard("logical")
                .setDisplay("Lenovo")
                .build();
    }
}
