package proxy.staticproxy;

import proxy.GamPlayer;
import proxy.GamPlayerImpl;

public class StaticProxy implements GamPlayer {
    private GamPlayer gamPlayer;

    public StaticProxy(GamPlayer gamPlayer){
        this.gamPlayer = gamPlayer;
    }

    public void killBoss(){
        gamPlayer.killBoss();
    }

    public void upgrade(){
        gamPlayer.upgrade();
    }

    public static GamPlayer getStaticProxy(GamPlayer player){
        return new StaticProxy(player);
    }

    public static void main(String[] args) {
        GamPlayer player = new GamPlayerImpl();
        GamPlayer staticProxy = StaticProxy.getStaticProxy(player);
        staticProxy.killBoss();
        staticProxy.upgrade();
    }
}
