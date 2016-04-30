package pl.touch.matiko101;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        o.getGraphicsContent().getSprite().setPosition(o.getPhysicsContent().getBody().getPosition().x - o.getGraphicsContent().getSprite().getWidth() / 2, o.getPhysicsContent().getBody().getPosition().y - o.getGraphicsContent().getSprite().getHeight() / 2);
        o.getGraphicsContent().getSprite().draw(batch);
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
