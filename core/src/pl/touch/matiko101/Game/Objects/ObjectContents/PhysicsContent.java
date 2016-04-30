package pl.touch.matiko101.Game.Objects.ObjectContents;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import pl.touch.matiko101.Graphics;

/**
 * Created by mateusz on 2016-04-26.
 */

public abstract class PhysicsContent implements Content
{
    protected enum ChangePositionTo
    {
        UPBORDEROFSCREEN
                {
                    @Override
                    public Vector2 set(Vector2 bodyPosition, Vector2 bodyDimensions)
                    {
                        this.position.y = Graphics.getCamera().viewportHeight - bodyDimensions.y ;
                        this.position.x = bodyPosition.x;
                        return this.position;
                    }
                },
        DOWNBORDEROFSCREEN
                {
                    @Override
                    public Vector2 set(Vector2 bodyPosition, Vector2 bodyDimensions)
                    {
                        this.position.y = 0 ;
                        this.position.x = bodyPosition.x;
                        return this.position;
                    }
                },
        ACTUALPOSITION
                {
                    @Override
                    public Vector2 set(Vector2 bodyPosition, Vector2 bodyDimensions)
                    {
                        this.position.y = bodyPosition.y;
                        this.position.x = bodyPosition.x;
                        return this.position;
                    }
                };

        Vector2 position = new Vector2(0,0);

        public abstract Vector2 set(Vector2 bodyPosition, Vector2 bodyDimensions);
        public ChangePositionTo setValueOfEnum(Vector2 bodyPosition, Vector2 bodyDimensions, Vector2 screenDimensions)
        {
            ChangePositionTo changePositionTo;
            if(bodyPosition.y - bodyDimensions.y > screenDimensions.y)
            {
                changePositionTo = DOWNBORDEROFSCREEN;
            }
            else if(bodyPosition.y < 0)
            {
                changePositionTo = UPBORDEROFSCREEN;
            }
            else
            {
                changePositionTo = ACTUALPOSITION;
            }
            return changePositionTo;

        }
    }

    protected ChangePositionTo changePositionTo;

    protected Body body;

    protected boolean shouldChangeDirection;

    protected Vector2 acceleration;

    public PhysicsContent()
    {

    }

    public float setFloatVariableOnOpposed(float variable)
    {
        variable *= -1;
        return variable;
    }

    public void setBody(Body body, String userDataName)
    {
        this.body = body;
        this.body.setUserData(userDataName);
    }

    public Body getBody()
    {
        return body;
    }

    public Vector2 getAcceleration()
    {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration)
    {
        this.acceleration = acceleration;
    }

    public boolean getShouldChangeDirection()
    {
        return shouldChangeDirection;
    }

    public void setShouldChangeDirection(boolean changeDirection)
    {
        this.shouldChangeDirection = changeDirection;
    }

    public void setChangePositionTo(ChangePositionTo changePositionTo)
    {
        this.changePositionTo = changePositionTo;
    }

    public ChangePositionTo getChangePositionTo(Vector2 bodyDimensions, Vector2 screenDimensions)
    {
        return changePositionTo.setValueOfEnum(body.getPosition(), bodyDimensions, screenDimensions );
    }

    public Vector2 getMethodSetFromChangePositionTo(Vector2 position, Vector2 dimensions)
    {
        return changePositionTo.set(position, dimensions);
    }


}
