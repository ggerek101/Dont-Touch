package pl.touch.matiko101.Game.Objects.ObjectContents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import pl.touch.matiko101.Game.Box2D.MyWorld;

/**
 * Created by mateusz on 2016-04-15.
 */
public abstract class GraphicsContent implements Content
{
    private Sprite sprite;
    private Texture texture;
    private String pathToFile;
    private float positionX, positionY;

    public GraphicsContent(float x, float y, String pathToFile)
    {
        this.positionX = x;
        this.positionY = y;
        this.pathToFile = pathToFile;
    }

    public void initTextureContent()
    {
        texture = new Texture(Gdx.files.internal(pathToFile));
    }

    protected void initSpriteContent()
    {
        sprite = new Sprite(texture);
        sprite.setPosition(positionX * MyWorld.SCALE, positionY * MyWorld.SCALE);
        sprite.setSize(sprite.getWidth() * MyWorld.SCALE, sprite.getHeight() * MyWorld.SCALE);
        sprite.flip(false, false);
    }

    public Sprite getSprite()
    {
        return sprite;
    }
    public Texture getTexture()
    {
        return texture;
    }

}
