package pl.touch.matiko101.Game;

import com.badlogic.gdx.Screen;

import pl.touch.matiko101.Game.Box2D.MyWorld;
import pl.touch.matiko101.Graphics;
import pl.touch.matiko101.Main;
import pl.touch.matiko101.Game.Objects.Object;

/**
 * Created by mateusz on 2016-04-03.
 */
public class Game implements Screen {

    final Main main;
    private Graphics gameGraphics;

    private ObjectManager objectManager;


    public Game(final Main m)
    {
        main = m;

        gameGraphics = new Graphics(1920, 1200);
        gameGraphics.setCameraToOrtho(19.2f,12f);

        objectManager = new ObjectManager( );
    }

    private void drawObjects()
    {
        gameGraphics.draw(objectManager.getHero());
        gameGraphics.draw(objectManager.getLeftLine());
        gameGraphics.draw(objectManager.getRightLine());
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        gameGraphics.update();
        drawObjects();
        objectManager.update();
        objectManager.getHero().action();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
