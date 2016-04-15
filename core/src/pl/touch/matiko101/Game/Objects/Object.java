package pl.touch.matiko101.Game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

import pl.touch.matiko101.Game.Box2D.MyWorld;

/**
 * Created by mateusz on 2016-04-15.
 */
public abstract class Object
{
    Sprite sprite;
    Texture texture;
    Body body;

    public Object(float x, float y, String pathToFile)
    {
        texture = new Texture(Gdx.files.internal(pathToFile));
        sprite = new Sprite(texture);
        sprite.setPosition(x * MyWorld.SCALE, y * MyWorld.SCALE);
        sprite.setSize(sprite.getWidth() * MyWorld.SCALE, sprite.getHeight() * MyWorld.SCALE);
        sprite.flip(false, false);
    }

    public void setBody(Body body)
    {
        this.body = body;
        body.setUserData(this);
    }
    public void setObjectProperties(float density, float friction, float restitution )
    {
        body.getFixtureList().first().setDensity(density);
        body.getFixtureList().first().setFriction(friction);
        body.getFixtureList().first().setRestitution(restitution);
    }

    public abstract void action();


    public Sprite getSprite()
    {
        return sprite;
    }
    public Texture getTexture()
    {
        return texture;
    }
    public Body getBody()
    {
        return body;
    }
}
