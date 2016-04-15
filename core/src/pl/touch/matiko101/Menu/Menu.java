package pl.touch.matiko101.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import pl.touch.matiko101.Game.Game;
import pl.touch.matiko101.Graphics;
import pl.touch.matiko101.Main;

/**
 * Created by mateusz on 2016-04-03.
 */
public class Menu implements Screen
{
    final Main main;

    public Sprite inscriptionStart;
    Graphics menuGraphics;

    public Menu(final Main m)
    {
        this.main = m;

        inscriptionStart = new Sprite(new Texture(Gdx.files.internal("background.png")));
        inscriptionStart.setPosition(0,0);

        menuGraphics = new Graphics(1920, 1200);
    }

    private void updateGraphics()
    {
        menuGraphics.update();
        menuGraphics.drawWithOutBox(inscriptionStart);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        updateGraphics();
        if (Gdx.input.isTouched()) {
            main.setScreen(new Game(main));
            dispose();
        }
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
