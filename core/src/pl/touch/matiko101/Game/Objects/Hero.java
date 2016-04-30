package pl.touch.matiko101.Game.Objects;

import com.badlogic.gdx.math.Vector2;

import pl.touch.matiko101.Game.Objects.ObjectContents.InputContent;
import pl.touch.matiko101.Game.Objects.ObjectContents.PhysicsContent;
import pl.touch.matiko101.Graphics;

/**
 * Created by mateusz on 2016-04-15.
 */
public class Hero extends Object
{
    public Hero(float x, float y, String pathToFile)
    {
        super(x, y, pathToFile);

        physicsContent = new PhysicsContent()
        {
            @Override
            public void action()
            {
                jump();
                changeDirection();
                move();
                checkChangePositionTo();
                teleport();
            }

            @Override
            public void init()
            {
                changePositionTo = ChangePositionTo.ACTUALPOSITION;

                shouldChangeDirection = false;

                acceleration = new Vector2(0,0);
            }
        };

        inputContent = new InputContent()
        {
            @Override
            public void action()
            {

            }

            @Override
            public void init()
            {

            }
        };

        physicsContent.init();
        inputContent.init();


        }

    public void jump()
    {
        if (inputContent.touchedScreen())
        {
            physicsContent.getBody().setLinearVelocity(physicsContent.getBody().getLinearVelocity().x, physicsContent.getAcceleration().y);
        }
    }

    private void changeDirection()
    {
        if (physicsContent.getShouldChangeDirection())
        {
            float opposedAccelerationX = physicsContent.setFloatVariableOnOpposed(physicsContent.getAcceleration().x);

            physicsContent.setAcceleration(new Vector2(opposedAccelerationX, physicsContent.getAcceleration().y));
            physicsContent.setShouldChangeDirection(false);
        }
    }

    private void move()
    {
        physicsContent.getBody().setLinearVelocity(physicsContent.getAcceleration().x, physicsContent.getBody().getLinearVelocity().y);
    }

    private void checkChangePositionTo()
    {
        physicsContent.getChangePositionTo(new Vector2(graphicsContent.getSprite().getWidth(), graphicsContent.getSprite().getHeight()), new Vector2(Graphics.getCamera().viewportWidth, Graphics.getCamera().viewportHeight));
    }

    private void teleport()
    {
        Vector2 pos = physicsContent.getBody().getPosition();
        Vector2 bodyDim = new Vector2 (graphicsContent.getSprite().getWidth(), graphicsContent.getSprite().getHeight());
        float angle = physicsContent.getBody().getAngle();
        physicsContent.getBody().setTransform(physicsContent.getMethodSetFromChangePositionTo(pos, bodyDim), angle);
    }

    @Override
    public void action()
    {
        physicsContent.action();
    }

}
