package pl.touch.matiko101;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javafx.scene.Camera;
import pl.touch.matiko101.Game.Objects.*;
import pl.touch.matiko101.Game.Objects.Object;

/**
 * Created by mateusz on 2016-04-03.
 */
public class Graphics
{
    private SpriteBatch batch;
    private BitmapFont font;
    private static OrthographicCamera camera;


    public Graphics(int cameraWidth, int cameraHeight)
    {
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, cameraWidth, cameraHeight);
    }

    public void setCameraToOrtho(float width, float height)
    {
        camera.setToOrtho(false, width, height);
    }

    public void update()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.update();
    }

    public void draw(Object o) {
        batch.begin();
        o.getSprite().setPosition(o.getBody().getPosition().x - o.getSprite().getWidth() / 2, o.getBody().getPosition().y - o.getSprite().getHeight() / 2);
        o.getSprite().draw(batch);
        batch.end();
    }

    public void drawWithOutBox(Sprite sprite)
    {
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public static OrthographicCamera getCamera()
    {
        return camera;
    }
}
